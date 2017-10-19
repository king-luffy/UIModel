package uimodel.editor.fileIOTable.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class InputModel  implements IEditorInput,Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final String Column1 = "Input File Type";
	public static final String Column2 = "File Path";
	public static final String Column3 = "Change File";

	protected List<InputFile> inputs = new ArrayList<>();

	public List<InputFile> getInputs(){
		return inputs;
	}

	public InputModel add(InputFile inputFile){
		inputs.add(inputFile);
		return this;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

}
