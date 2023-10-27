package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;

import java.io.IOException;

/**
 * Open existing file.
 */
class DoOpen extends Command<Calculator> {

  DoOpen(Calculator receiver) {
    super(Label.OPEN, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    boolean save = false;
    String filename = "";
//        System.out.println("SPREAD::::" +  _receiver.getFilename());
    if(_receiver.getFilename().isEmpty() && _receiver.getSpreadsheet() != null){
      save = Form.requestString(Message.saveBeforeExit()).equals("s");
    }
    if(save){
      filename = Form.requestString(Message.newSaveAs());
    }

    filename = Form.requestString(Message.openFile());
    try {
      _receiver.load(filename);
    } catch (UnavailableFileException | ClassNotFoundException e) {
      throw new FileOpenFailedException(e);
    }
  }
}
