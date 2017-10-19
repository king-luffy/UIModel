package uimodel.views.fileTree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FileTreeContentProvider implements ITreeContentProvider,IStructuredContentProvider{

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getChildren(Object parentElement) {

		//获取文件夹的孩子，排除隐藏文件
		File file = (File) parentElement;

		List<File> files = new ArrayList<File>();
		for(File childFile : file.listFiles())
			if(!childFile.isHidden())
				files.add(childFile);

		return files.toArray();
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return (File[])inputElement;
	}

	@Override
	public Object getParent(Object element) {
		return ((File)element).getParentFile();
	}

	@Override
	public boolean hasChildren(Object element) {
		File file = (File)element;
		if(file.isDirectory())
			return true;
		return false;
	}

}
