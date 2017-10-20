package uimodel;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import uimodel.action.showBottomView.ShowConsoleView;
import uimodel.action.showLeftView.ShowWindowsExplrorView;
import uimodel.action.viewChange.ViewBmvfGenAction;
import uimodel.action.viewChange.ViewCompareDBAction;
import uimodel.action.viewChange.ViewLeuGenAction;
import uimodel.action.viewChange.ViewSingleBcnGenAction;



/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.

	private IWorkbenchAction exitAction;
//	private ViewSingleBcnGenAction viewSingleBcnGenAction;
//	private ViewBmvfGenAction viewBmvfGenAction;
//	private ViewLeuGenAction viewLeuGenAction;
	private ViewCompareDBAction viewCompareDBAction;
	private ShowWindowsExplrorView showWindowsExplrorView;
	private ShowConsoleView showConsoleView;
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	protected void makeActions(IWorkbenchWindow window) {

    	exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);


//        viewSingleBcnGenAction = new ViewSingleBcnGenAction("Single Beacon Gen View", window);
//        register(viewSingleBcnGenAction);
//
//        viewBmvfGenAction= new ViewBmvfGenAction("Bmvf Gen View", window);
//        register(viewBmvfGenAction);
//
//        viewLeuGenAction = new  ViewLeuGenAction("Leu Gen View", window);
//        register(viewLeuGenAction);
        
        viewCompareDBAction = new ViewCompareDBAction("Comare DB View", window);
        register(viewCompareDBAction);

        showWindowsExplrorView = new ShowWindowsExplrorView("Show Window View", window);
        register(showWindowsExplrorView);

        showConsoleView = new ShowConsoleView("Show Console View",window);
        register(showConsoleView);

    }

    protected void fillMenuBar(IMenuManager menuBar) {

    	MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
        MenuManager viewMenu = new MenuManager("&View", "View");
    	MenuManager layoutMenu = new MenuManager("&Layout", "Layout");

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        // Add a group marker indicating where action set menus will appear.
        //menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuBar.add(layoutMenu);

        fileMenu.add(exitAction);
//        viewMenu.add(viewSingleBcnGenAction);
//        viewMenu.add(viewBmvfGenAction);
//        viewMenu.add(viewLeuGenAction);
        viewMenu.add(viewCompareDBAction);
        viewMenu.add(new Separator());
        viewMenu.add(showWindowsExplrorView);
        viewMenu.add(showConsoleView);

    }
}
