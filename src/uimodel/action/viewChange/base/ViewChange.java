package uimodel.action.viewChange.base;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import uimodel.editor.fileIOTable.base.InputModel;
import uimodel.input.InputManager;

public class ViewChange {

	public boolean changeView(IWorkbenchWindow window,ViewChangeAction viewChangeAction){
		//存在，则关掉再打开，不存在，则打开

    	boolean isExistFlag = false;
    	IWorkbenchPage[] pages = window.getPages();
    	for (IWorkbenchPage iWorkbenchPage : pages) {

			IEditorReference[] references = iWorkbenchPage.getEditorReferences();
			for (IEditorReference reference : references) {


				String editorViewID = viewChangeAction.getId();
				if(reference.getId().equals(editorViewID)){

					iWorkbenchPage.closeEditor(reference.getEditor(false), true);

					try {
						iWorkbenchPage.openEditor(
								InputManager.getInputModel(editorViewID),
								editorViewID);
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
					isExistFlag = true;
					break;
				}
			}
		}
    	try {
    		if(!isExistFlag)
			window.getActivePage().openEditor(new InputModel(), viewChangeAction.getId());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

    	return true;
	}
}
