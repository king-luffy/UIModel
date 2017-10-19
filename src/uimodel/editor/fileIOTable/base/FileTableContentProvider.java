package uimodel.editor.fileIOTable.base;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FileTableContentProvider implements IStructuredContentProvider{

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		//get rid of the output folder ele
		List<InputFile> eles = ((InputModel)inputElement).inputs;
		List<InputFile> eleWithoutOutputFloder = new ArrayList<InputFile>();
		for (InputFile inputFile : eles) {
			if(inputFile.getInputFileType().equals(InputFileType.outputFloder))
				continue;
			eleWithoutOutputFloder.add(inputFile);
		}
		return eleWithoutOutputFloder.toArray();
	}

}
