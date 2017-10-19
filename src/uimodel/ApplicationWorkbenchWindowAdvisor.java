package uimodel;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import uimodel.editor.BmvfGenEditPart;
import uimodel.editor.CmpEditor;
import uimodel.editor.LeuGenEditPart;
import uimodel.editor.SingleBcnGenEditPart;
import uimodel.input.InputManager;
import uimodel.views.ConsoleView;
import uimodel.views.OutputExplorerView;


public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(400, 300));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowStatusLine(true);
		configurer.setTitle("UIModel");
	}
	
	public void postWindowOpen() {
		//拿到上下文配置
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
    	//设置为全屏
		configurer.getWindow().getShell().setMaximized(true);
		IWorkbenchPage curIWorkbenchPage = configurer.getWindow().getActivePage();
		//显示输出的view
    	try {
			curIWorkbenchPage.showView(OutputExplorerView.ID);
			curIWorkbenchPage.showView(ConsoleView.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//显示editor
    	try {

    		curIWorkbenchPage.openEditor(
    				InputManager.getInputModel(SingleBcnGenEditPart.ID),
    				SingleBcnGenEditPart.ID);
			curIWorkbenchPage.openEditor(
					InputManager.getInputModel(BmvfGenEditPart.ID),
					BmvfGenEditPart.ID);
			curIWorkbenchPage.openEditor(
					InputManager.getInputModel(LeuGenEditPart.ID),
					LeuGenEditPart.ID);
			curIWorkbenchPage.openEditor(
					InputManager.getCmpInputModel(), 
					CmpEditor.ID);

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	super.postWindowOpen();
	}
}
