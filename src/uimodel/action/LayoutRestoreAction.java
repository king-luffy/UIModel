package uimodel.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;

public class LayoutRestoreAction extends Action {
	public static final String LayoutRestoreActionId = "LayoutRestore";

	private final IWorkbenchWindow window;

    public LayoutRestoreAction(String text, IWorkbenchWindow window) {
        super(text);
        this.window = window;
        // The id is used to refer to the action in a menu or toolbar
        setId(LayoutRestoreActionId);
    }

    public void run() {
        MessageDialog.openInformation(window.getShell(), "Layout Restore", "Restore the Views Layout to Default!");
    }
}
