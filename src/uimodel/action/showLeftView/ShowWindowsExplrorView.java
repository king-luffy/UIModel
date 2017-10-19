package uimodel.action.showLeftView;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import uimodel.views.OutputExplorerView;


public class ShowWindowsExplrorView extends Action{

	public static String ID = ShowWindowsExplrorView.class.getName();

	protected final IWorkbenchWindow window;

    public ShowWindowsExplrorView(String text, IWorkbenchWindow window) {
        super(text);
        this.window = window;
        // The id is used to refer to the action in a menu or toolbar
        setId(ID);
    }

    public void run(){
    	try {
			window.getActivePage().showView(OutputExplorerView.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
