package uimodel.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import uimodel.views.fileTree.FileTreeViewer;

public class OutputExplorerView extends ViewPart{

	public static final String ID = "uimodel.views.OutputExplorerView";

	@Override
	public void createPartControl(Composite parent) {

		new FileTreeViewer().getTreeViewer(parent);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
