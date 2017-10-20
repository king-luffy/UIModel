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
		final Composite newParent = MaginLayout.createMarginComposite(parent, 10);

		//在上一级容器中再创建五个上下排列的容器
		final Composite[] childComposites =
				MaginLayout.createVerticalSplitComposite(newParent, new int[]{15,23,84,92});

		//在第一个20%的容器中写ip,dbname,username,password
		final Composite[] hChildCompositesFor1stRow=
				MaginLayout.createHorizontalSplitComposite(childComposites[0], new int[]{50});
		//{
			//容器left进一步分成上下两个小容器
			final Composite[] vh1stRowLeft=
					MaginLayout.createVerticalSplitComposite(hChildCompositesFor1stRow[0], new int[]{50});
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 4;
			Composite vh1stRowLeftRow1 = vh1stRowLeft[0];
			Composite vh1stRowLeftRow2 = vh1stRowLeft[1];
			vh1stRowLeftRow1.setLayout(gridLayout);
			vh1stRowLeftRow2.setLayout(gridLayout);

			//第一行ip
			Label label = new Label(vh1stRowLeftRow1, SWT.NONE);
			label.setText("IP  :");
			Text textBox = new Text(vh1stRowLeftRow1, SWT.BORDER);
			textBox.setText("172.16.7.100");
			GridData textBoxData = new GridData(SWT.LEFT, SWT.BOTTOM, true, false);
			textBoxData.widthHint = 400;
			textBoxData.heightHint = 20;
			textBox.setLayoutData(textBoxData);
			
			//第一行db name
			Label label2 = new Label(vh1stRowLeftRow1, SWT.NONE);
			label2.setText("DBName  :");
			Text textBox2 = new Text(vh1stRowLeftRow1, SWT.BORDER);
			textBox2.setLayoutData(textBoxData);
			
			//第二行user name
			Label label3 = new Label(vh1stRowLeftRow2, SWT.NONE);
			label3.setText("User:");
			Text textBox3 = new Text(vh1stRowLeftRow2, SWT.BORDER);
			textBox3.setLayoutData(textBoxData);
			
			//第二行password
			Label label4 = new Label(vh1stRowLeftRow2, SWT.NONE);
			label4.setText("Password:");
			Text textBox4 = new Text(vh1stRowLeftRow2, SWT.BORDER);
			textBox4.setLayoutData(textBoxData);
		//}
		//{
			//容器right进一步分成上下两个小容器
			final Composite[] vh1stRowRight=
					MaginLayout.createVerticalSplitComposite(hChildCompositesFor1stRow[1], new int[]{50});
			Composite vh1stRowRightRow1 = vh1stRowRight[0];
			Composite vh1stRowRightRow2 = vh1stRowRight[1];
			vh1stRowRightRow1.setLayout(gridLayout);
			vh1stRowRightRow2.setLayout(gridLayout);

			//第一行ip
			Label label5 = new Label(vh1stRowRightRow1, SWT.NONE);
			label5.setText("IP  :");
			Text textBox5 = new Text(vh1stRowRightRow1, SWT.BORDER);
			textBox5.setText("172.16.7.100");
			textBox5.setLayoutData(textBoxData);
			
			//第一行db name
			Label label6 = new Label(vh1stRowRightRow1, SWT.NONE);
			label6.setText("DBName  :");
			Text textBox6 = new Text(vh1stRowRightRow1, SWT.BORDER);
			textBox6.setLayoutData(textBoxData);
			
			//第二行user name
			Label label7 = new Label(vh1stRowRightRow2, SWT.NONE);
			label7.setText("User:");
			Text textBox7 = new Text(vh1stRowRightRow2, SWT.BORDER);
			textBox7.setLayoutData(textBoxData);
			
			//第二行password
			Label label8 = new Label(vh1stRowRightRow2, SWT.NONE);
			label8.setText("Password:");
			Text textBox8 = new Text(vh1stRowRightRow2, SWT.BORDER);
			textBox8.setLayoutData(textBoxData);
		//}
		
		//在第二个10%的容器中写连接数据库button
		final Composite[] hChildCompositesFor2ndRow = 
				MaginLayout.createHorizontalSplitComposite(childComposites[1], new int[]{50});
		FillLayout fillLayout = new FillLayout();
		Button leftReadDBButton = new Button(hChildCompositesFor2ndRow[0], SWT.NONE);
		leftReadDBButton.setText("Read DB");
		hChildCompositesFor2ndRow[0].setLayout(new GridLayout());
		leftReadDBButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
		Button rightReadDBButton = new Button(hChildCompositesFor2ndRow[1], SWT.NONE);
		rightReadDBButton.setText("Read DB");
		hChildCompositesFor2ndRow[1].setLayout(new GridLayout());
		rightReadDBButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		//在第三composite中创建左右两个容器，并填充两个文本框
		final Composite[] hChildCompositesFor3rdRow=
				MaginLayout.createHorizontalSplitComposite(childComposites[2], new int[]{50});
		hChildCompositesFor3rdRow[0].setLayout(fillLayout);
		Text textLeft = new Text(hChildCompositesFor3rdRow[0], 
				SWT.V_SCROLL | SWT.BORDER | SWT.WRAP | SWT.H_SCROLL);
		hChildCompositesFor3rdRow[1].setLayout(fillLayout);
		Text textRight = new Text(hChildCompositesFor3rdRow[1], 
				SWT.V_SCROLL | SWT.BORDER | SWT.WRAP | SWT.H_SCROLL);

		//在第四个composite中添加file dialog
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 3;
		childComposites[3].setLayout(gridLayout2);

		Label label10 = new Label(childComposites[3], SWT.NONE);
		label10.setText("Output Folder:");
		Text textBox10 = new Text(childComposites[3], SWT.BORDER);
		textBox10.setText("Output Folder");
		GridData textBoxData2 = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
		textBoxData2.widthHint = 400;
		textBoxData2.heightHint = 20;
		textBox10.setLayoutData(textBoxData2);
		Button fileDialogButton = new Button(childComposites[3], SWT.NONE);
		fileDialogButton.setText("...");
		GridData fileDialogButtonData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
		fileDialogButtonData.widthHint = 40;
		fileDialogButtonData.heightHint = 25;
		fileDialogButton.setLayoutData(fileDialogButtonData);

		//在第五个composite中添加run button
		Button runButton = new Button(childComposites[4], SWT.NONE);
		runButton.setText("Run");
		//runButton.setBounds(0, 0, 40, 20);
		childComposites[4].setLayout(new GridLayout());
		runButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
	}


}
