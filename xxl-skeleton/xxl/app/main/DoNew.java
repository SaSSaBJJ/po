package xxl.app.main;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;

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
    String filename = Form.requestString("Enter the name of the new file:");
    
    try {
      _receiver.createNewFile(filename);
    } catch (IOException e) {
      return;
    }
  }
}
