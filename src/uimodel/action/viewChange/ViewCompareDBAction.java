package uimodel.action.viewChange;

import org.eclipse.ui.IWorkbenchWindow;

import uimodel.action.viewChange.base.ViewChange;
import uimodel.action.viewChange.base.ViewChangeAction;
import uimodel.editor.CmpEditor;

public class ViewCompareDBAction extends ViewChangeAction{

	public static final String ID = CmpEditor.ID;
	public ViewCompareDBAction(String text, IWorkbenchWindow window) {
		super(text, window);
	}

	@Override
	protected String getID() {
		return ID;
	}

	@Override
	public void run() {
		new ViewChange().changeView(window, this);
	}

}
