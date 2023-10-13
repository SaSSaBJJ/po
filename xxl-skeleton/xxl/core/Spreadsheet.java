package xxl.core;

// FIXME import classes
import java.io.IOException;
import java.util.*;

import java.io.Serial;
import java.io.Serializable;

import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class representing a spreadsheet.
 */
public class Spreadsheet implements Serializable {
  @Serial
  private static final long serialVersionUID = 202308312359L;
  
  // FIXME define attributes
  private int _rows;

  private int _columns;

  private Boolean _changed;

  private TreeMap<String, User> _users;

  private List<Cell> _cells;

  // FIXME define contructor(s)
  public Spreadsheet(int rows, int columns) {

    _rows=rows;

    _columns=columns;
  }

  // FIXME define methods
  public int getRows(){
    return _rows;
  }

  public int getColumns(){
    return _columns;
  }

  public Boolean isChanged() {
    return _changed;
  }

  /* FIX ME
  public List<Cell> getCutBuffer(){
    
  }
  */

  public void copy(String range){
    //FIX ME
  }

  public void clear(String range){
    //FIX ME
  }

  public void addUser(User user){
    _users.put(user.getName(), user);
  }

  Collection<User> getUsers(){
    return new ArrayList<User>(_users.values());
  }

  List<Cell> getCells(){
    return _cells;
  }

  public List<Cell> getCellsInRange(Range range) {
    return range.getCells();
  }

  public Cell getCell(int row, int column) throws UnrecognizedEntryException {
    for (Cell c: _cells) {
      if (c.getRow()==row & c.getColumn()==column) {
        return c;
      }
    }
    throw new UnrecognizedEntryException("Célula não existe");
  }
  
  
  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    if (row > _rows | column > _columns | row <= 0 | column <= 0) {
      throw new UnrecognizedEntryException("Célula não existe");
    }
    
    /*for (Cell c: _cells) {
      if (c.getRow()==row & c.getColumn()==column){
        
    }*/
  }

  void importFile(String txtfile) throws IOException, UnrecognizedEntryException {
		try {
			new Parser(this).parseFile(txtfile);
		}
    catch (IOException | UnrecognizedEntryException e) {
			throw e;
		}
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

    if (firstRow <=0 | firstColumn <= 0 | lastRow < firstRow | lastColumn < firstColumn) {
      throw new UnrecognizedEntryException("Range Inválido"); 
    }
    // check if coordinates are valid
    // if yes
    return new Range(firstRow, firstColumn, lastRow, lastColumn); //and spreadsheet;
  }

  
}
