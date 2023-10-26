package xxl.app.search;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Cell;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Command for searching function names.
 */
class DoShowFunctions extends Command<Spreadsheet> {

  DoShowFunctions(Spreadsheet receiver) {
    super(Label.SEARCH_FUNCTIONS, receiver);
    // FIXME add fields
  }

  @Override
  protected final void execute() {
    int value = Form.requestInteger(Message.searchFunction());
    try {
      for (Cell c: _receiver.getCells()) {
        if (c.getContent().asInt() == value){
          _display.popup(c);
        }
      }
    }catch (Exception e){
      throw e;
    }
  }
}
