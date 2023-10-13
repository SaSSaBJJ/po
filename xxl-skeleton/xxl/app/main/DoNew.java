package xxl.app.main;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;
import xxl.core.exception.MissingFileAssociationException;

/**
 * Open a new file.
 */
class DoNew extends Command<Calculator> {

  DoNew(Calculator receiver) {
    super(Label.NEW, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    // pode nao estar bem
    String filename = Form.requestString(Message.newSaveAs());
    int rows = Form.requestInteger(Message.lines());
    int columns = Form.requestInteger(Message.columns());
    
    try {
      _receiver.saveAs(filename);
      _receiver.createNewSpreadsheet(rows, columns);
    } catch (IOException | MissingFileAssociationException e) {
      return;
    }
  }
}
