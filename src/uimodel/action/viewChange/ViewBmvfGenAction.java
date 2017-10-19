package uimodel.action.viewChange;

import org.eclipse.ui.IWorkbenchWindow;

import uimodel.action.viewChange.base.ViewChange;
import uimodel.action.viewChange.base.ViewChangeAction;
import uimodel.editor.BmvfGenEditPart;

public class ViewBmvfGenAction extends ViewChangeAction{

	public static final String ID = BmvfGenEditPart.ID;

    public ViewBmvfGenAction(String text, IWorkbenchWindow window) {
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
