package uimodel.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import uimodel.editor.cmp.InputModelCmp;
import uimodel.editor.layout.MaginLayout;

public class CmpEditor extends EditPartCmpBase{

	public final static String ID= CmpEditor.class.getName();
	
	@Override
	public String getPartName() {
		return "Compare DB";
	}

	@Override
	public void createPartControl(Composite parent) {
		InputModelCmp inputModel =(InputModelCmp)this.getEditorInput();

		
		//创建带margin的composite
		final Composite newParent = MaginLayout.createMarginComposite(parent, 20);

		//在上一级容器中再创建上中下三个容器
		final Composite[] childComposites =
				MaginLayout.createVerticalSplitComposite(newParent, new int[]{76,88});

		//在第一composite中创建左右两个容器，并填充两个文本框
		final Composite[] horizontalChildCompositesForFirstRow=
				MaginLayout.createHorizontalSplitComposite(childComposites[0], new int[]{50});
		FillLayout fillLayout = new FillLayout();
		horizontalChildCompositesForFirstRow[0].setLayout(fillLayout);
		Text textLeft = new Text(horizontalChildCompositesForFirstRow[0], 
				SWT.V_SCROLL | SWT.BORDER | SWT.WRAP | SWT.H_SCROLL);
		horizontalChildCompositesForFirstRow[1].setLayout(fillLayout);
		Text textRight = new Text(horizontalChildCompositesForFirstRow[1], 
				SWT.V_SCROLL | SWT.BORDER | SWT.WRAP | SWT.H_SCROLL);

		//在第二个composite中添加file dialog
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		childComposites[1].setLayout(gridLayout);

		Label label = new Label(childComposites[1], SWT.NONE);
		label.setText("Output Folder:");
		Text textBox = new Text(childComposites[1], SWT.BORDER);
		textBox.setText("Output Folder");
		GridData textBoxData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
		textBoxData.widthHint = 400;
		textBoxData.heightHint = 20;
		textBox.setLayoutData(textBoxData);
		Button fileDialogButton = new Button(childComposites[1], SWT.NONE);
		fileDialogButton.setText("...");
		GridData fileDialogButtonData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
		fileDialogButtonData.widthHint = 40;
		fileDialogButtonData.heightHint = 25;
		fileDialogButton.setLayoutData(fileDialogButtonData);

		//在第三个composite中添加run button
		Button runButton = new Button(childComposites[2], SWT.NONE);
		runButton.setText("Run");
		//runButton.setBounds(0, 0, 40, 20);
		childComposites[2].setLayout(new GridLayout());
		runButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
	}


}
