package uimodel.action.viewChange;

import org.eclipse.ui.IWorkbenchWindow;

import uimodel.action.viewChange.base.ViewChange;
import uimodel.action.viewChange.base.ViewChangeAction;
import uimodel.editor.LeuGenEditPart;

public class ViewLeuGenAction  extends ViewChangeAction{

	public static final String ID = LeuGenEditPart.ID;

    public ViewLeuGenAction(String text, IWorkbenchWindow window) {
        super(text,window);
    }

    public void run() {
        new ViewChange().changeView(window, this);
    }

	@Override
	protected String getID() {
		return ID;
	}
}
