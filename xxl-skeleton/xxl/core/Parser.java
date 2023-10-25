package xxl.core;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;

import java.util.Collection;
import java.util.ArrayList;

import xxl.core.exception.UnrecognizedEntryException;

class Parser {

  private Spreadsheet _spreadsheet;


  Parser(Spreadsheet spreadsheet) {
    _spreadsheet = spreadsheet;
  }

  Spreadsheet parseImport(String filename) throws IOException, UnrecognizedEntryException /* More Exceptions? */ {
    int rows = -1;
    int columns = -1;
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

      for (int i = 0; i < 2; i++) {
        String line = reader.readLine();
        String[] dimension = line.split("=");
        if (dimension[0].equals("linhas"))
          rows = Integer.parseInt(dimension[1]);
        else if (dimension[0].equals("colunas"))
          columns = Integer.parseInt(dimension[1]);
        else
          throw new UnrecognizedEntryException("Dimensões inválidas para a folha");
      }
      Spreadsheet spreadsheet = new Spreadsheet(rows, columns);
      _spreadsheet = spreadsheet;
      String line;

      while ((line = reader.readLine()) != null){
        parseLine(line, spreadsheet);
      }
      return spreadsheet;
    }

  }

  private void parseLine(String line, Spreadsheet spreadsheet) throws UnrecognizedEntryException /*, more exceptions? */{
    String[] components = line.split("\\|");

    if (components.length == 1) // do nothing
      return;

    if (components.length == 2) {
      String[] address = components[0].split(";");
      Content content = parseContent(components[1]);
      spreadsheet.insertContent(Integer.parseInt(address[0]), Integer.parseInt(address[1]), content);
    } else
      throw new UnrecognizedEntryException("Wrong format in line: " + line);
  }

  // parse the begining of an expression
  Content parseContent(String contentSpecification) throws UnrecognizedEntryException {
    char c = contentSpecification.charAt(0);
//    System.out.println("PARSER: parsing content: " + contentSpecification);
     try {
        if (c == '=') {
            return parseContentExpression(contentSpecification.substring(1));
        } else {
            return parseLiteral(contentSpecification);
        }
    } catch (Exception e) {
        // Handle or rethrow the exception as needed.
        throw new UnrecognizedEntryException("Error parsing content specification", e);
    }
  }

  private Literal parseLiteral(String literalExpression) throws UnrecognizedEntryException {
    if (literalExpression.charAt(0) == '\'')
      return new LiteralString(literalExpression);
    else {
      try {
        int val = Integer.parseInt(literalExpression);
        return new LiteralInteger(val);
      } catch (NumberFormatException nfe) {
        throw new UnrecognizedEntryException("Número inválido: " + literalExpression);
      }
    }
  }

  // contentSpecification is what comes after '='
  private Content parseContentExpression(String contentSpecification) throws UnrecognizedEntryException /*more exceptions */ {
    if (contentSpecification.contains("("))
      return parseFunction(contentSpecification);
    // It is a reference
    String[] address = contentSpecification.split(";");
//    System.out.println("PARSER: parseContentExpression " + _spreadsheet);
    return new Reference(Integer.parseInt(address[0].trim()), Integer.parseInt(address[1]), _spreadsheet);
  }

  private Content parseFunction(String functionSpecification) throws UnrecognizedEntryException /*more exceptions */ {
    String[] components = functionSpecification.split("[()]");
    if (components[1].contains(","))
      return parseBinaryFunction(components[0], components[1]);
        
    return parseIntervalFunction(components[0], components[1]);
  }

  private Content parseBinaryFunction(String functionName, String args) throws UnrecognizedEntryException /* , more Exceptions */ {
    String[] arguments = args.split(",");
    Content arg0 = parseArgumentExpression(arguments[0]);
    Content arg1 = parseArgumentExpression(arguments[1]);
    
    return switch (functionName) {
      case "ADD" -> new Add(arg0, arg1);
      case "SUB" -> new Sub(arg0, arg1);
      case "MUL" -> new Mul(arg0, arg1);
      case "DIV" -> new Div(arg0, arg1);
      default -> throw new UnrecognizedEntryException("função inválida: " + functionName);
    };
  }

  private Content parseArgumentExpression(String argExpression) throws UnrecognizedEntryException {
    if (argExpression.contains(";")  && argExpression.charAt(0) != '\'') {
      String[] address = argExpression.split(";");
//      System.out.println("PARSER: parseArgumentExpression" + _spreadsheet);
      return new Reference(Integer.parseInt(address[0].trim()), Integer.parseInt(address[1]), _spreadsheet);
      // pode ser diferente do anterior em parseContentExpression
    } else
      return parseLiteral(argExpression);
  }

  private Content parseIntervalFunction(String functionName, String rangeDescription) throws UnrecognizedEntryException /* , more exceptions ? */ {
    Range range = _spreadsheet.createRange(rangeDescription);
    return switch (functionName) {
      case "CONCAT" -> new Concat(range);
      case "COALESCE" -> new Coalesce(range);
      case "PRODUCT" -> new Product(range);
      case "AVERAGE" -> new Average(range);
      default -> throw new UnrecognizedEntryException("Função Inválida: " + functionName);
    };
  }
  
}
