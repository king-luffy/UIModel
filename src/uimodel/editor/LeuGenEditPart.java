package uimodel.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;


public class LeuGenEditPart extends EditPartBase {

	public final static String ID= "uimodel.editor.LeuGenEditPart";

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
		setPartName("Gen Leu");
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

	@Override
	public void createPartControl(Composite parent) {
		createTab(parent);
	}

//	private void createTab(Composite parent){
//
//		//创建带margin的composite
//		final Composite newParent = MaginLayout.createMarginComposite(parent, 20);
//
//		//在上一级容器中再创建上中下三个容器
//		final Composite[] childComposites =
//				MaginLayout.createVerticalSplitComposite(newParent, new int[]{80,90});
//
//		//在第一composite中填充table
//		FileIOTable.createTable(childComposites[0],(InputModel)this.getEditorInput());
//
//		//在第二个composite中添加file dialog
//		GridLayout gridLayout = new GridLayout();
//		gridLayout.numColumns = 3;
//		childComposites[1].setLayout(gridLayout);
//		Label label = new Label(childComposites[1], SWT.NONE);
//		label.setText("Output Folder:");
//		Text textBox = new Text(childComposites[1], SWT.BORDER);
//		textBox.setText("Here will set the output folder!");
//		GridData textBoxData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
//		textBoxData.widthHint = 400;
//		textBoxData.heightHint = 20;
//		textBox.setLayoutData(textBoxData);
//		Button fileDialogButton = new Button(childComposites[1], SWT.NONE);
//		fileDialogButton.setText("...");
//		GridData fileDialogButtonData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
//		fileDialogButtonData.widthHint = 40;
//		fileDialogButtonData.heightHint = 25;
//		fileDialogButton.setLayoutData(fileDialogButtonData);
//
//		//在第三个composite中添加run button
//		Button runButton = new Button(childComposites[2], SWT.NONE);
//		runButton.setText("Run");
//		//runButton.setBounds(0, 0, 40, 20);
//		childComposites[2].setLayout(new GridLayout());
//		runButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//
//
//	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
