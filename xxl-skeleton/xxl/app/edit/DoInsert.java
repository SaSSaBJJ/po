package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.app.exception.UnknownFunctionException;
import xxl.core.Cell;
import xxl.core.Range;
import xxl.core.Spreadsheet;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnrecognizedEntryException;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;

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
        try {
            Range range = _receiver.createRange(stringField("range"));
            String value = stringField("contents");
            for (Cell c: range.getCells()){
//                System.out.println("ERROR TESTS" + c);
                _receiver.insertContent(c.getRow(), c.getColumn(), value);
            }
        }   catch (UnrecognizedEntryException e) {
            throw new InvalidCellRangeException(stringField("range"));
        }

    }
}
