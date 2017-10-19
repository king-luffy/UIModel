package uimodel.editor.fileIOTable.base;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.TableItem;

import uimodel.input.InputManager;


public class FileTableCellModifier implements ICellModifier{

	TableViewer tv;



	public FileTableCellModifier(TableViewer tv) {
		super();
		this.tv = tv;
	}

	@Override
	public boolean canModify(Object element, String property) {
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {

		InputFile ele = (InputFile)element;
		if(property.equals(InputModel.Column1))
			return ele.getInputFileType().name();
		else if(property.equals(InputModel.Column2))
			return ele.getFilePath();
		else if(property.equals(InputModel.Column3))
			//return new RGB(0, 0, 0);
			return " Change File";
		throw new RuntimeException("error column name:"+property);
		//return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		TableItem item = (TableItem)element;
		InputFile ele = (InputFile)item.getData();

		if(property.equals(InputModel.Column1)){

		}
		else if(property.equals(InputModel.Column2)){
			//ele.setFilePath((String)value);
			updataLocalAndMemoryData(ele, (String)value);
		}
		else if(property.equals(InputModel.Column3)){
			if(!((String)value).trim().equals("Change File"))
			//ele.setFilePath((String)value);
				updataLocalAndMemoryData(ele, (String)value);
		}
		else {
			System.out.println("i sholdn't come here!");
		}

		tv.update(ele, null);
	}

	private void updataLocalAndMemoryData(InputFile ele,String filePath){
		ele.setFilePath(filePath);
		InputManager.updateLocalData();
	}

}
