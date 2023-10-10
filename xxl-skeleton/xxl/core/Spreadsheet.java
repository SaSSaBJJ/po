package xxl.core;

// FIXME import classes
import java.io.IOException;

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
  // FIXME define contructor(s)
  public Spreadsheet(int rows, int columns) {

    _rows=rows;

    _columns=columns;
  }
  // FIXME define methods
  /*
  public List<Cell> getCutBuffer(){

  }

  public void copy(String range){

  }

  public void clear(String range){

  }

  public void addUser(User u){

  }
  */
  
  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    //FIXME implement method
  }

  void importFile(String txtfile) throws IOException, UnrecognizedEntryException {
		try {
			new Parser(this).parseFile(txtfile);
		} catch (IOException e) {
			throw e;
		} catch (UnrecognizedEntryException e) {
			throw e;
		}
	}

  
}
