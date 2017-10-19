package uimodel.views.fileTree;

import java.io.File;
import java.io.InputStream;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class FileTreeLabelProvider implements ILabelProvider{

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	public static final String FolderIcoPath="/icons/folder.png";
	public static final String DefalutIcoPath="/icons/Default.ico";
	public static final String TextIcoPath="/icons/TXT.ico";
	public static final String DiskIcoPath="/icons/disk.png";

	@Override
	public Image getImage(Object element) {


		File file = (File)element;

		Image image = null;

		//盘符
		if (file.getParent()==null)
			image = getImage(DiskIcoPath);

		//文件�?
		else if(file.isDirectory())
			image = getImage(FolderIcoPath);

		//文件
		else
			image = getImage(DefalutIcoPath);


		return image;
	}

	private Image getImage(String path){
		//获取流并缩放到18*（18*原始比例)的特定大小
		InputStream inputStream = getClass().getResourceAsStream(path);

		Image image1 = new Image(Display.getCurrent(), inputStream);

		ImageData imageData = image1.getImageData();

		int scale = imageData.height/imageData.width;

		image1 = new Image(Display.getCurrent(), image1.getImageData().scaledTo(18,18*scale));

		return image1;
	}

	@Override
	public String getText(Object element) {
		File file = (File)element;
		String name = file.getName();
		if(name.length()>0)
			return name;
		return file.getPath();
	}

}
