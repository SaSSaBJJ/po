package xxl.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import xxl.core.exception.ImportFileException;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;
import xxl.core.exception.UnrecognizedEntryException;

// FIXME import classes
import java.util.ArrayList;
import java.io.*;

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
      // FIXME open import file and feed entries to new spreadsheet (in a cycle)
      //       each entry is inserted using insertContent of Spreadsheet. Set new
      // spreadsheet as the active one.
      // ....
      _spreadsheet.importFile(filename);

    } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(filename, e);
    }
  }

  public void createNewSpreadsheet(int rows, int columns) {
  
  }

  /*
  public boolean createUser(String name) {
    
  }
  */
}
