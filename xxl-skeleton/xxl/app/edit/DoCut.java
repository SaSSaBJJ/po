package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Range;
import xxl.core.Spreadsheet;
import xxl.core.exception.UnrecognizedEntryException;
// FIXME import classes

/**
 * Cut command.
 */
class DoCut extends Command<Spreadsheet> {

  DoCut(Spreadsheet receiver) {
    super(Label.CUT, receiver);
    addStringField("range", Message.address());
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    try {
      Range range = _receiver.createRange(stringField("range"));
      _receiver.copy(range);
      _receiver.clear(range);
    } catch (UnrecognizedEntryException e) {
      throw new RuntimeException(e);
    }
  }
}
