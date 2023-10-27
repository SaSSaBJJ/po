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
	addStringField("filename", Message.newSaveAs());
  }
  
  @Override
  protected final void execute() {
    // FIXME implement command and create a local For
	  if(_receiver.getFilename().isEmpty()){
		  try {
			  String filename = stringField("filename");
			  _receiver.saveAs(filename);
		  } catch (MissingFileAssociationException e) {
			  throw new RuntimeException(e);
		  } catch (IOException e) {
			  throw new RuntimeException(e);
		  }
	  }else{
		  try {
			  _receiver.save();
		  } catch (MissingFileAssociationException e) {
			  throw new RuntimeException(e);
		  } catch (IOException e) {
			  throw new RuntimeException(e);
		  }
	  }
  }
}
