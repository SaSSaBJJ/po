package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.app.exception.UnknownFunctionException;
import xxl.core.Spreadsheet;
// FIXME import classes
import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class for inserting data.
 */
class DoInsert extends Command<Spreadsheet> {

    DoInsert(Spreadsheet receiver) {
        super(Label.INSERT, receiver);
        // FIXME add fields
        addStringField("range", Message.address());
        addStringField("contents", Message.contents());
    }
    
    @Override
    protected final void execute() throws CommandException {
    // FIXME implement command
       
    }
}
