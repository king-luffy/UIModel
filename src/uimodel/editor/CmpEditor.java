package uimodel.editor;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import controller.CompareController;
import service.po.ConfigInfo;
import service.po.DBConfig;
import service.po.PosPo;
import service.po.dbcompare.PosPoCmp;
import service.util.SerializerUtil;
import uimodel.editor.cmp.InputModelCmp;
import uimodel.editor.layout.MaginLayout;

public class CmpEditor extends EditPartCmpBase{

	public final static String ID= CmpEditor.class.getName();
	private static Logger logger = Logger.getLogger(CmpEditor.class);
	private final static String LOCAL_RECORD_FILE_NAME = "ConfigInfo";
	
	public final static String IP1="172.16.7.132";
	public final static String IP2="172.16.7.132";
	public final static String DB_NAME1="dinning";
	public final static String DB_NAME2="dinning_test";
	public final static String USER_NAME="sa";
	public final static String PSW="kingking";
	
	public static PosPo basePo = null;
	public static PosPo cmpPo = null;
	
	@Override
	public String getPartName() {
		return "Compare DB";
	}

	private Text textBox;
	private Text textBox2;
	private Text textBox3;
	private Text textBox4;
	private StyledText textLeft;
	private Button leftReadDBButton;
	
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
			final Label label = new Label(vh1stRowLeftRow1, SWT.NONE);
			
			label.setText("IP  :");
			final Text textBox = new Text(vh1stRowLeftRow1, SWT.BORDER);
			textBox.setText(IP1);
			GridData textBoxData = new GridData(SWT.LEFT, SWT.BOTTOM, true, false);
			textBoxData.widthHint = 400;
			textBoxData.heightHint = 20;
			textBox.setLayoutData(textBoxData);
			
			//第一行db name
			final Label label2 = new Label(vh1stRowLeftRow1, SWT.NONE);
			label2.setText("DBName  :");
			final Text textBox2 = new Text(vh1stRowLeftRow1, SWT.BORDER);
			textBox2.setText(DB_NAME1);
			textBox2.setLayoutData(textBoxData);
			
			//第二行user name
			final Label label3 = new Label(vh1stRowLeftRow2, SWT.NONE);
			label3.setText("User:");
			final Text textBox3 = new Text(vh1stRowLeftRow2, SWT.BORDER);
			textBox3.setText(USER_NAME);
			textBox3.setLayoutData(textBoxData);
			
			//第二行password
			Label label4 = new Label(vh1stRowLeftRow2, SWT.NONE);
			label4.setText("Password:");
			final Text textBox4 = new Text(vh1stRowLeftRow2, SWT.BORDER);
			textBox4.setText(PSW);
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
			final Text textBox5 = new Text(vh1stRowRightRow1, SWT.BORDER);
			textBox5.setText(IP2);
			textBox5.setLayoutData(textBoxData);
			
			//第一行db name
			Label label6 = new Label(vh1stRowRightRow1, SWT.NONE);
			label6.setText("DBName  :");
			final Text textBox6 = new Text(vh1stRowRightRow1, SWT.BORDER);
			textBox6.setText(DB_NAME2);
			textBox6.setLayoutData(textBoxData);
			
			//第二行user name
			Label label7 = new Label(vh1stRowRightRow2, SWT.NONE);
			label7.setText("User:");
			final Text textBox7 = new Text(vh1stRowRightRow2, SWT.BORDER);
			textBox7.setText(USER_NAME);
			textBox7.setLayoutData(textBoxData);
			
			//第二行password
			Label label8 = new Label(vh1stRowRightRow2, SWT.NONE);
			label8.setText("Password:");
			final Text textBox8 = new Text(vh1stRowRightRow2, SWT.BORDER);
			textBox8.setText(PSW);
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
		final StyledText textLeft = new StyledText(hChildCompositesFor3rdRow[0], 
				SWT.V_SCROLL | SWT.BORDER | SWT.WRAP | SWT.H_SCROLL);
		hChildCompositesFor3rdRow[1].setLayout(fillLayout);
		final StyledText textRight = new StyledText(hChildCompositesFor3rdRow[1], 
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
		final Button runButton = new Button(childComposites[4], SWT.NONE);
		runButton.setText("Run");
		//runButton.setBounds(0, 0, 40, 20);
		childComposites[4].setLayout(new GridLayout());
		runButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		//组件成员变量记录
		this.textBox = textBox;
		this.textBox2 = textBox2;
		this.textBox3 = textBox3;
		this.textBox4 = textBox4;
		this.leftReadDBButton = leftReadDBButton;
		this.textLeft = textLeft;
		
		{
			//组件初始化,从本地读取配置文件并填写空间数据
			ConfigInfo configInfo = SerializerUtil.deserialization(LOCAL_RECORD_FILE_NAME);
			if(configInfo!=null){
				DBConfig baseDBConfig = configInfo.getBaseConfig();
				if(baseDBConfig!=null){
					textBox.setText(baseDBConfig.getDbIp());
					textBox2.setText(baseDBConfig.getDbName());
					textBox3.setText(baseDBConfig.getUserName());
					textBox4.setText(baseDBConfig.getUserPwd());
				}
				DBConfig cmpDBConfig = configInfo.getCmpConfig();
				if(cmpDBConfig!=null){
					textBox5.setText(cmpDBConfig.getDbIp());
					textBox6.setText(cmpDBConfig.getDbName());
					textBox7.setText(cmpDBConfig.getUserName());
					textBox8.setText(cmpDBConfig.getUserPwd());
				}
			}
		}
		
		{
			//添加读取事件
			addLeftTextReadEvent();
			
			rightReadDBButton.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					DBConfig dbConfig = getDBConfig(textBox5.getText(),textBox6.getText(), 
							textBox7.getText(),textBox8.getText());
					cmpPo = CompareController.fetchDBInfo(dbConfig);
					textRight.setText(CompareController.toJSONString(cmpPo));
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			//比较按钮
			runButton.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
//					if(basePo==null || cmpPo==null){
//						logger.error("No compare date!");
//						return;
//					}
//					PosPoCmp posPoCmp=CompareController.cmpDB(basePo, cmpPo);
					
					textLeft.append("Test ");
					textLeft.setForeground(new Color(Display.getCurrent(), new RGB(150,50,50)));
					textLeft.append("WaHAHA ");
					//textLeft.setForeground(new Color(Display.getCurrent(), new RGB(50,50,50)));
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	}
	private DBConfig getDBConfig(String ip,String dbName,String userName,String psw){
		DBConfig dbConfig = new DBConfig();
		dbConfig.setDbIp(ip);
		dbConfig.setDbName(dbName);
		dbConfig.setUserName(userName);
		dbConfig.setUserPwd(psw);
		return dbConfig;
	}
	private void addLeftTextReadEvent(){
		leftReadDBButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				DBConfig dbConfig = getDBConfig(textBox.getText(),textBox2.getText(), 
								textBox3.getText(),textBox4.getText());
				basePo = CompareController.fetchDBInfo(dbConfig);
				textLeft.setText(CompareController.toJSONString(basePo));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
