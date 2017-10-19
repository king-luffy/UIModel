package uimodel.action.viewChange.base;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;



public abstract class ViewChangeAction extends Action{

	protected abstract String getID();

	protected final IWorkbenchWindow window;

    public ViewChangeAction(String text, IWorkbenchWindow window) {
        super(text);
        this.window = window;
        // The id is used to refer to the action in a menu or toolbar
        setId(getID());
        // Associate the action with a pre-defined command, to allow key bindings.
        //setActionDefinitionId(ICommandIds.CMD_OPEN_MESSAGE);
        //setImageDescriptor(bmgenui.Activator.getImageDescriptor("/icons/sample3.gif"));
    }

    public abstract void run();
}
