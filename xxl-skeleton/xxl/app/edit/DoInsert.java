package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Class for inserting data.
 */
class DoInsert extends Command<Spreadsheet> {

  DoInsert(Spreadsheet receiver) {
    super(Label.INSERT, receiver);
    // FIXME add fields
    addStringField("range", Message.address());
    addStringField("conten", Message.contents());
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    try {
      _receiver.add
    }
  }
}
