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
    addStringField("function", Message.searchFunction());
  }

  @Override
  protected final void execute() {
    String value = stringField("function");
    try {
      for (Cell c: _receiver.getCells()) {
        if(value.length() < c.getContent().asString().length()){
          if (c.getContent().asString().substring(0, value.length()).equals(value)){
            _display.popup(c);
          }
        }
      }
    }catch (Exception e){
      throw e;
    }
  }
}
