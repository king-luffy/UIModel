package uimodel.util;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class ImageHelper {
	public static Image getImage(String path,int height){
		//获取流并缩放到height*（height*原始比例)的特定大小
		InputStream inputStream = ImageHelper.class.getResourceAsStream(path);

		Image image1 = new Image(Display.getCurrent(), inputStream);

		ImageData imageData = image1.getImageData();

		int scale = imageData.height/imageData.width;

		image1 = new Image(Display.getCurrent(), image1.getImageData().scaledTo(height,height*scale));

		return image1;
	}

	public static Image getImage(String path){

		InputStream inputStream = ImageHelper.class.getResourceAsStream(path);

		Image image1 = new Image(Display.getCurrent(), inputStream);


		return image1;
	}
}
