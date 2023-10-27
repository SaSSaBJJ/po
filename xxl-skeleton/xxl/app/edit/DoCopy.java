package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;
import xxl.core.Range;
import xxl.core.Spreadsheet;
import xxl.core.exception.UnrecognizedEntryException;
// FIXME import classes

/**
 * Copy command.
 */
class DoCopy extends Command<Spreadsheet> {

  DoCopy(Spreadsheet receiver) {
    super(Label.COPY, receiver);
    // FIXME add fields
    addStringField("range", Message.address());
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    try {
      _receiver.copy(_receiver.createRange(stringField("range")));
    }catch (UnrecognizedEntryException e) {
      throw new InvalidCellRangeException(stringField("range"));
    }

  }
}
