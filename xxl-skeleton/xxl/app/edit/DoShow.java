package xxl.app.edit;

import java.io.IOException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Spreadsheet;
// FIXME import classes
import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class for searching functions.3-3--+-
 */
class DoShow extends Command<Spreadsheet> {

  DoShow(Spreadsheet receiver) {
    super(Label.SHOW, receiver);
    // FIXME add fields
    addStringField("range", Message.address());
  }
  
  @Override
  protected final void execute() throws CommandException {

    try {
      _display.popup(_receiver.getCellsInRange(_receiver.createRange(stringField("range"))));
      
    } 
    catch (UnrecognizedEntryException e) {
      throw new InvalidCellRangeException(stringField("range"));
    }
  }
}
