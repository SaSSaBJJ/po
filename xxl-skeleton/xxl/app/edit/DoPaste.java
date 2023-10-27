package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Cell;
import xxl.core.Range;
import xxl.core.Spreadsheet;
import xxl.core.exception.UnrecognizedEntryException;
// FIXME import classes

/**
 * Paste command.
 */
class DoPaste extends Command<Spreadsheet> {

  DoPaste(Spreadsheet receiver) {
    super(Label.PASTE, receiver);
    addStringField("range", Message.address());
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    try {
      Range range = _receiver.createRange(stringField("range"));
//      System.out.println("DoPaste: range" + range.getFirstRow() + ";" + range.getFirstColumn() + ":" + range.getLastRow() + ";" + range.getLastColumn());
      for(Cell c : _receiver.getCutBuffer()){
        if(range.getFirstRow() + c.getRow() - 1 <= _receiver.getRows() && range.getFirstColumn() + c.getColumn() - 1 <= _receiver.getColumns()){
          _receiver.insertContent(range.getFirstRow() + c.getRow() - 1, range.getFirstColumn() + c.getColumn() - 1, c.getContent());
        }
      }
    } catch (UnrecognizedEntryException e) {
      throw new RuntimeException(e);
    }
  }
}
