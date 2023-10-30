package xxl.core;

// FIXME import classes
import java.io.IOException;
import java.util.*;

import java.io.Serial;
import java.io.Serializable;

import xxl.app.exception.InvalidCellRangeException;
import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class representing a spreadsheet.
 */
public class Spreadsheet implements Serializable {
  @Serial
  private static final long serialVersionUID = 202308312359L;
  
  private int _rows;

  private int _columns;

  private Boolean _changed;

  private TreeMap<String, User> _users;

  private List<List<Cell>> _cells;

  private List<Cell> _cutBuffer;

  public Spreadsheet(int rows, int columns) {

    _rows=rows;

    _columns=columns;

    _cells=new ArrayList<>();

    for (int row = 1; row <= _rows; row++) {
      List<Cell> rowCells = new ArrayList<>();
      for (int col = 1; col <= _columns; col++) {
//        System.out.println("SPREADSHEET: adding cell on row: " + row + " col: " + col);
          rowCells.add(new Cell(row, col, new LiteralString("")));
      }
      _cells.add(rowCells);
    }
  }

  public int getRows(){
    return _rows;
  }

  public int getColumns(){
    return _columns;
  }

  public Boolean isChanged() {
    return _changed;
  }

  public List<Cell> getCutBuffer() throws InvalidCellRangeException {
    if(_cutBuffer.size() > 5){
      throw new InvalidCellRangeException("numero invalido de celulas no cut buffer");
    }
    return _cutBuffer;
  }

  public void copy(Range range){
    ArrayList<Cell> cutBuffer = new ArrayList<>();
    int row = 1 - range.getFirstRow();
    int col = 1 - range.getFirstColumn();
    for  (Cell c : range.getCells()){
      cutBuffer.add(new Cell(c.getRow() + row, c.getColumn() + col, c.getContent()));
    }
    _cutBuffer = cutBuffer;
  }

  public void clear(Range range) throws UnrecognizedEntryException {
    try {
      for (Cell c : range.getCells()){
        c.setContent(new LiteralString(""));
      }
    }catch (Exception e) {
      throw e;
    }
  }

  public void addUser(User user){
    _users.put(user.getName(), user);
  }

  Collection<User> getUsers(){
    return new ArrayList<User>(_users.values());
  }

  public Cell getCell(int row, int column) throws UnrecognizedEntryException {
    return _cells.get(row).get(column);
  }

  public List<Cell> getCells() {
    List<Cell> allCells = new ArrayList<>();

//    System.out.println("SPREADSHEET: getting cells" + _cells);
    for (List<Cell> rowCells : _cells) {
        allCells.addAll(rowCells);
    }

    return allCells;
}

  public List<Cell> getCellsInRange(Range range) {
//    System.out.println("SPEADSHEET: getting cels in range " + range);
    return range.getCells();
  }

  
  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * @param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    if (row > _rows | column > _columns | row <= 0 | column <= 0) {
      throw new UnrecognizedEntryException("Célula não existe");
    }

//    System.out.println("SPREADSHEET: SETTING CONTENT " + row + ";" + column + "|" + contentSpecification);
    for (List<Cell> c: _cells) {
      for(Cell c1: c){
        if (c1.getRow()==row & c1.getColumn()==column) {
          c1.setContent(new Parser(this).parseContent(contentSpecification));
        }
      }
    }
//    for (List<Cell> c: _cells) {
//      for(Cell c1: c){
//        if (c1.getRow()==row & c1.getColumn()==column) {
//          System.out.println("SPREADSHEET: CELL " + c1.getRow() + " " + c1.getColumn() + " " + c1.getContent());
//        }
//      }
//    }
  }

  public void insertContent(int row, int column, Content contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    if (row > _rows | column > _columns | row <= 0 | column <= 0) {
      throw new UnrecognizedEntryException("Célula não existe");
    }

//    System.out.println("SPREADSHEET: SETTING CONTENT " + row + ";" + column + "|" + contentSpecification);
    for (List<Cell> c: _cells) {
      for(Cell c1: c){
        if (c1.getRow()==row & c1.getColumn()==column) {
          c1.setContent(contentSpecification);
        }
      }
    }
//    for (List<Cell> c: _cells) {
//      for(Cell c1: c){
//        if (c1.getRow()==row & c1.getColumn()==column) {
//          System.out.println("SPREADSHEET: CELL " + c1.getRow() + " " + c1.getColumn() + " " + c1.getContent());
//        }
//      }
//    }
  }

  public Range createRange(String range) throws UnrecognizedEntryException {
    String[] rangeCoordinates;
    int firstRow, firstColumn, lastRow, lastColumn;
    
    if (range.indexOf(':') != -1) {
      rangeCoordinates = range.split("[:;]");
      firstRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = Integer.parseInt(rangeCoordinates[1]);
      lastRow = Integer.parseInt(rangeCoordinates[2]);
      lastColumn = Integer.parseInt(rangeCoordinates[3]);
    } else {
      rangeCoordinates = range.split(";");
      firstRow = lastRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = lastColumn = Integer.parseInt(rangeCoordinates[1]);
    }
//    System.out.println("SPREADSHEET: range is "+ range);
    // check if coordinates are valid
    if ((firstRow <1 || firstRow > _rows) | (firstColumn < 1 || firstColumn > _columns) | (lastRow < 1 || lastRow > _rows) |
            (lastColumn < 1 || lastColumn > _columns) | lastRow < firstRow | lastColumn < firstColumn) {
      throw new UnrecognizedEntryException("Range Inválido");
    }
    // if yes
//    System.out.println("RANGE IS BEGIN CREATED");
    return new Range(firstRow, firstColumn, lastRow, lastColumn, this); //and spreadsheet;
  }

  
}
