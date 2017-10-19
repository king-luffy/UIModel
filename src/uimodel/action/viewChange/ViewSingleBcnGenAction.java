package uimodel.action.viewChange;

import org.eclipse.ui.IWorkbenchWindow;

import uimodel.action.viewChange.base.ViewChange;
import uimodel.action.viewChange.base.ViewChangeAction;
import uimodel.editor.SingleBcnGenEditPart;

public class ViewSingleBcnGenAction extends ViewChangeAction {
	public static final String ID = SingleBcnGenEditPart.ID;

    public ViewSingleBcnGenAction(String text, IWorkbenchWindow window) {
        super(text,window);
    }

    public void run() {

    	//�۽���Single Beacon Generation View
    	new ViewChange().changeView(window, this);

    }

	@Override
	protected String getID() {
		return ID;
	}
}
