package xxl.app.main;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;

/**
 * Open menu.
 */
class DoOpenEditMenu extends Command<Calculator> {

  DoOpenEditMenu(Calculator receiver) {
    super(Label.MENU_CALC, receiver, r -> r.getSpreadsheet() != null);
    System.out.println(receiver.getSpreadsheet());
  }
  
  @Override
  protected final void execute() throws CommandException {
    System.out.println(_receiver.getSpreadsheet());
    (new xxl.app.edit.Menu(_receiver.getSpreadsheet())).open();
  }
}
