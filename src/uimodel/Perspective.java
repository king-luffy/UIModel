package uimodel;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import uimodel.views.ConsoleView;
import uimodel.views.OutputExplorerView;


public class Perspective implements IPerspectiveFactory {

	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea =layout.getEditorArea();

		//editor area show
		layout.setEditorAreaVisible(true);

		//add left view, for file explorer
		layout.addView(OutputExplorerView.ID, IPageLayout.LEFT, 0.2f, editorArea);

		//add bottom view, for console
		layout.addView(ConsoleView.ID, IPageLayout.BOTTOM, 0.75f, editorArea);
		
	}

}
