package uimodel.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.EditorPart;

import uimodel.editor.fileIOTable.FileIOTable;
import uimodel.editor.fileIOTable.base.InputFile;
import uimodel.editor.fileIOTable.base.InputFileType;
import uimodel.editor.fileIOTable.base.InputModel;
import uimodel.editor.layout.MaginLayout;



public abstract class EditPartBase extends EditorPart{

	protected void createTab(Composite parent){

		InputModel inputModel =(InputModel)this.getEditorInput();
		String outputFloder = "";
		for (InputFile inputFile : inputModel.getInputs()) {
			if(inputFile.getInputFileType().equals(InputFileType.outputFloder))
			{
				outputFloder = inputFile.getFilePath();
				break;
			}
		}

		//创建带margin的composite
		final Composite newParent = MaginLayout.createMarginComposite(parent, 20);

		//在上一级容器中再创建上中下三个容器
		final Composite[] childComposites =
				MaginLayout.createVerticalSplitComposite(newParent, new int[]{76,88});

		//在第一composite中填充table
		FileIOTable.createTable(childComposites[0],inputModel);

		//在第二个composite中添加file dialog
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		childComposites[1].setLayout(gridLayout);

		Label label = new Label(childComposites[1], SWT.NONE);
		label.setText("Output Folder:");
		Text textBox = new Text(childComposites[1], SWT.BORDER);
		textBox.setText(outputFloder);
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
