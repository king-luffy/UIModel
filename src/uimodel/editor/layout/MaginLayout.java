package uimodel.editor.layout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MaginLayout {
	public static void main(String[] args) {
		Display display = Display.getDefault();

		Shell shell = new Shell();
		shell.setText("Hello SWT");
		shell.setSize(400, 400);
		shell.open();

		new MaginLayout();
		Composite composite = MaginLayout.createMarginComposite(shell,30);

		composite.setBackground(new Color(Display.getCurrent(), new RGB(150,150,150)));
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	/**
	 *
	 * @author 61658
	 * @Date 2016年11月3日上午10:24:00
	 * @Description 创建带有margin的composite,边带长为margin,返回创建的composite
	 * @param parent
	 * @param margin
	 * @return
	 */
	public static Composite createMarginComposite(Composite parent,int margin){
		parent.setLayout(new FillLayout());

		Composite container = new Composite(parent, SWT.FILL);

		//container.setBackground(new Color(Display.getCurrent(), new RGB(150,150,150)));

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);


		final Label upLabel = new Label(container, SWT.NONE);
		//upLabel.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		final GridData gridDataUpDn = new GridData(SWT.FILL,SWT.CENTER,true,false,3,1);
		gridDataUpDn.widthHint =margin;
		gridDataUpDn.heightHint =margin;
		upLabel.setLayoutData(gridDataUpDn);

		final Label centerLabel1 = new Label(container, SWT.NONE);
		//centerLabel1.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		final GridData gridDataLR = new GridData(SWT.CENTER, SWT.FILL, false, true, 1, 1);
		gridDataLR.widthHint =margin;

		final GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		centerLabel1.setLayoutData(gridDataLR);

		final Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(gridData2);

		final Label centerLabel3 = new Label(container, SWT.NONE);
		//centerLabel3.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		centerLabel3.setLayoutData(gridDataLR);


		final Label bottomLabel = new Label(container, SWT.NONE);
		//bottomLabel.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		bottomLabel.setLayoutData(gridDataUpDn);

		return composite;
	}

	/**
	 *
	 * @author 61658
	 * @Date 2016年11月3日上午10:27:06
	 * @Description 创建一组被垂直分割的容器，
	 * 输入n个分割位，以百分比输入，返回n+1个被分割的composite区域;
	 * 若有重复的分割位则会被剔除
	 * @param parent
	 * @param splitPos(0,100)
	 * @return
	 */
	public static Composite[] createVerticalSplitComposite(Composite parent,int[] splitPos){

		//防护，去重，检查范围
		if(splitPos==null)
			return null;
		Arrays.sort(splitPos);
		List<Integer> workSplitPosi = new ArrayList<>();
		int curSplitPos = 0;
		for (int i : splitPos) {
			if(i==0 || i==100 || i==curSplitPos)
				continue;
			curSplitPos = i;
			workSplitPosi.add(curSplitPos);
		}
		if(workSplitPosi.size()<=0)
			return null;

		workSplitPosi.add(100);

		//分割composite
		parent.setLayout(new FormLayout());
		List<Composite> composites = new ArrayList<>();
		curSplitPos = 0;
		for (int splitP : workSplitPosi) {
			Composite composite = new Composite(parent, SWT.NONE);
			FormData formData = new FormData();
			formData.left = new FormAttachment(0);
			formData.right = new FormAttachment(100);
			formData.top = new FormAttachment(curSplitPos);
			formData.bottom = new FormAttachment(splitP);
			composite.setLayoutData(formData);
			composites.add(composite);
			curSplitPos = splitP;
		}

		return composites.toArray(new Composite[]{});
	}
	
	/**
	 * 创建一组被水平分割的容器，
	 * 输入n个分割位，以百分比输入，返回n+1个被分割的composite区域;
	 * 若有重复的分割位则会被剔除
	 * @param parent
	 * @param splitPos
	 * @return
	 */
	public static Composite[] createHorizontalSplitComposite(Composite parent,int[] splitPos){
		//防护，去重，检查范围
		if(splitPos==null)
			return null;
		Arrays.sort(splitPos);
		List<Integer> workSplitPosi = new ArrayList<>();
		int curSplitPos = 0;
		for (int i : splitPos) {
			if(i==0 || i==100 || i==curSplitPos)
				continue;
			curSplitPos = i;
			workSplitPosi.add(curSplitPos);
		}
		if(workSplitPosi.size()<=0)
			return null;

		workSplitPosi.add(100);

		//分割composite
		parent.setLayout(new FormLayout());
		List<Composite> composites = new ArrayList<>();
		curSplitPos = 0;
		for (int splitP : workSplitPosi) {
			Composite composite = new Composite(parent, SWT.NONE);
			FormData formData = new FormData();
			formData.left = new FormAttachment(curSplitPos);
			formData.right = new FormAttachment(splitP);
			formData.top = new FormAttachment(0);
			formData.bottom = new FormAttachment(100);
			composite.setLayoutData(formData);
			composites.add(composite);
			curSplitPos = splitP;
		}

		return composites.toArray(new Composite[]{});
	}
}
