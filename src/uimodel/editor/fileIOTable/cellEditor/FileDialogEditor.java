package uimodel.editor.fileIOTable.cellEditor;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class FileDialogEditor extends DialogCellEditor {

	public FileDialogEditor(Composite parent) {
		super(parent,SWT.NONE);
	}


	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		return open(cellEditorWindow.getShell());
	}

	public Object open(Shell shell){

		FileDialog fileDialog = new FileDialog(shell);

		Object value = getValue();


		return fileDialog.open();
	}

}
