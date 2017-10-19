package uimodel.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ConsoleView extends ViewPart {

	public static final String ID = "uimodel.views.ConsoleView";


	private Text consoleText;

	@Override
	public void createPartControl(Composite parent) {

		parent.setLayout(new GridLayout());

		consoleText = new Text(parent, SWT.BORDER |
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		consoleText.setText("I am console!");
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

}
