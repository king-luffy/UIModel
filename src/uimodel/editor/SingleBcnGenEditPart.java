package uimodel.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class SingleBcnGenEditPart extends EditPartBase {

	public final static String ID="uimodel.editor.SingleBcnGenEditPart";

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName("Gen Single Beacon");
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	Label label;

	@Override
	public void createPartControl(Composite parent) {
		createTab(parent);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

//	private void create(Composite parent){
//
//		Composite container = new Composite(parent, SWT.NONE);
//
//
//
//
//
//		final GridLayout gridLayout = new GridLayout();
//
//
//
//		gridLayout.numColumns = 1;
//		container.setLayout(gridLayout);
//
//
//		final Label userNameLabel = new Label(container, SWT.NONE);
//		userNameLabel.setText("User Name:");
//
//		final Text userNameText = new Text(container, SWT.BORDER);
//		userNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//
//		final Label addressLabel = new Label(container, SWT.NONE);
//		addressLabel.setText("Address:");
//
//		final Text addressText = new Text(container, SWT.BORDER);
//		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//
//		final Button okButton = new Button(container, SWT.NONE);
//		final GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1);
//		gridData.widthHint = 80;
//		gridData.heightHint = 25;
//		//gridData.exclude = true;
//		okButton.setLayoutData(gridData);
//		okButton.setText("OK");
//	}


}
