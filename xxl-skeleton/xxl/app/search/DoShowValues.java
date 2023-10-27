package xxl.app.search;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Cell;
import xxl.core.Spreadsheet;

import java.util.List;
// FIXME import classes

/**
 * Command for searching content values.
 */
class DoShowValues extends Command<Spreadsheet> {

  DoShowValues(Spreadsheet receiver) {
    super(Label.SEARCH_VALUES, receiver);
    // FIXME add fields
    addStringField("value", Message.searchValue());
  }
  
  @Override
  protected final void execute() {
    String value = stringField("value");
    try {
      for (Cell c: _receiver.getCells()) {
        if (c.getContent().value().asString().equals(value)){
          _display.popup(c);
        }
      }
    }catch (Exception e){
      throw e;
    }
  }
}
