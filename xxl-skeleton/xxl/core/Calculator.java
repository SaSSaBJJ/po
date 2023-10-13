package xxl.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import xxl.core.exception.ImportFileException;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;
import xxl.core.exception.UnrecognizedEntryException;

// FIXME import classes
import java.io.*;
import java.util.*;

/**
 * Class representing a spreadsheet application.
 */
public class Calculator {
  /** The current spreadsheet. */
  private Spreadsheet _spreadsheet;
  
  // FIXME add more fields and methods if needed
  private String _filename="";
  
  /**
   * Return the current spreadsheet.
   *
   * @returns the current spreadsheet of this application. This reference can be null.
   */
  public final Spreadsheet getSpreadsheet() {
    return _spreadsheet;
  }

  public String getFilename() {
    return _filename;
  }

  public void setFilename(String filename) {
		_filename = filename;
	}

  public int getRows(){
    return _spreadsheet.getRows();
  }

  public int getColumns(){
    return _spreadsheet.getColumns();
  }

  public Boolean isChanged() {
    return _spreadsheet.isChanged();
  }

  Collection<User> getUsers(){
    return _spreadsheet.getUsers();
  }

  List<Cell> getCells(){
    return _spreadsheet.getCells();
  }

  List<Cell> getCellsInRange(Range range) {
    return _spreadsheet.getCellsInRange(range);
  }

  public Cell getCell(int row, int column) throws UnrecognizedEntryException {
    return _spreadsheet.getCell(row, column);
  }

  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened. 
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
    if (_filename == null) {
			throw new MissingFileAssociationException();
		}

		try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(_filename))) {
			objOut.writeObject(_filename);
			objOut.writeObject(_spreadsheet);
		}
  }
  
  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
    _filename = filename;
    save();
  }
  
  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   * @throws ClassNotFoundException
   */
  public void load(String filename) throws UnavailableFileException, ClassNotFoundException {
    // FIXME implement serialization method
    try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename))) {
			_filename = (String) objIn.readObject();
			_spreadsheet = (Spreadsheet) objIn.readObject();

		} catch (IOException e) {
			throw new UnavailableFileException(filename);
		}
  }
  
  /**
   * Read text input file and create domain entities.
   *
   * @param filename name of the text input file
   * @throws ImportFileException
   */
  public void importFile(String filename) throws ImportFileException {

    try {
      _spreadsheet.importFile(filename);
    } catch (IOException | UnrecognizedEntryException e) {
      throw new ImportFileException(filename, e);
    }
  }

  public void createNewSpreadsheet(int rows, int columns) {
    _spreadsheet = new Spreadsheet(rows, columns);
  }


  public boolean createUser(String name) throws UnrecognizedEntryException {
    User newUser = new User(name);
    for (User u: _spreadsheet.getUsers()){
      if (u.getName().equals(name)){
        throw new UnrecognizedEntryException("Nome duplicado: " + name);
      }
    }
    _spreadsheet.addUser(newUser);
    return true;
    
  }

  Range createRange(String range) throws UnrecognizedEntryException {
    return _spreadsheet.createRange(range);
  }

  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    _spreadsheet.insertContent(row, column, contentSpecification);
  }
}
