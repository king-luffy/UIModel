package uimodel.views;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ConsoleView extends ViewPart {

	public static final String ID = "uimodel.views.ConsoleView";


	private static Text consoleText;

	@Override
	public void createPartControl(Composite parent) {

		parent.setLayout(new GridLayout());

		consoleText = new Text(parent, SWT.BORDER |
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		consoleText.setText("I am console!\n");
		consoleText.setEditable(false);

		consoleText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;

		consoleText.setLayoutData(gridData);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public static void append(String msg){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		consoleText.append(dateString+" : ");
		consoleText.append(msg);
		consoleText.append("\n");
	}
	
	public static void setText(String msg){
		consoleText.setText(msg);
	}
	
}
