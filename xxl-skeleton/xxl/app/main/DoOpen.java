package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
// FIXME import classes
import xxl.core.exception.UnavailableFileException;

/**
 * Open existing file.
 */
class DoOpen extends Command<Calculator> {

  DoOpen(Calculator receiver) {
    super(Label.OPEN, receiver);
    addStringField("file", Message.openFile());
  }
  
  @Override
  protected final void execute() throws CommandException {
    String filename = stringField("file");
    try {
      _receiver.load(filename);
    } catch (UnavailableFileException | ClassNotFoundException e) {
      throw new FileOpenFailedException(e);
    }
  }
}
