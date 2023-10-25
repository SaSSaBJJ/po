package xxl.app.main;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Calculator;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSave extends Command<Calculator> {

  DoSave(Calculator receiver) {
    super(Label.SAVE, receiver, xxl -> xxl.getSpreadsheet() != null);
  }
  
  @Override
  protected final void execute() {
    // FIXME implement command and create a local For
	  String filename = Form.requestString(Message.newSaveAs());

	  try {
			_receiver.saveAs(filename);
		} catch (MissingFileAssociationException | IOException e1) {
		  filename = Form.requestString(Message.newSaveAs());
			_receiver.setFilename(filename);
			try {
				_receiver.saveAs(filename);
			} catch (MissingFileAssociationException | IOException e2) {
				return;
			}
		}
  }
}
