package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import xxl.core.exception.UnavailableFileException;

/**
 * Open existing file.
 */
class DoSearchClient extends Command<Calculator> {

  DoSearchClient(Calculator receiver) {
    super("Procura de clientes", receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    boolean save = false;
    int number;

    number = Form.requestInteger("utilizador");

  }
}
