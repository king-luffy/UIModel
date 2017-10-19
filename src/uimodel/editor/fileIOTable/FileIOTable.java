package uimodel.editor.fileIOTable;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import uimodel.editor.fileIOTable.base.FileTableCellModifier;
import uimodel.editor.fileIOTable.base.FileTableContentProvider;
import uimodel.editor.fileIOTable.base.FileTableLabelProvider;
import uimodel.editor.fileIOTable.base.InputModel;
import uimodel.editor.fileIOTable.cellEditor.FileDialogEditor;



public class FileIOTable {

	public static TableViewer createTable(Composite parent,InputModel input){

		parent.setLayout(new FillLayout());

		Table table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION );
		//table.setLinesVisible(true);
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText(InputModel.Column1);
		column1.setWidth(100);
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(300);
		column2.setText(InputModel.Column2);
		TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setWidth(100);
		column3.setText(InputModel.Column3);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);



		TableViewer viewer = new TableViewer(table);

		viewer.setColumnProperties(new String[]{InputModel.Column1,InputModel.Column2,InputModel.Column3});
		CellEditor[] cellEditors = new CellEditor[3];
		cellEditors[0] = null;
		cellEditors[1] = new TextCellEditor(viewer.getTable());
		cellEditors[2] = new FileDialogEditor(table);
		//cellEditors[2] = new MyColorEditor(table);
		//cellEditors[2] = new ColorCellEditor(table);

		viewer.setCellEditors(cellEditors);

		viewer.setContentProvider(new FileTableContentProvider());
		viewer.setLabelProvider(new FileTableLabelProvider());
		viewer.setCellModifier(new FileTableCellModifier(viewer));


//		InputModel input = new InputModel()
//				.add(new InputFile(InputFileType.SyDB, "/input/inputTest.txt"))
//				.add(new InputFile(InputFileType.BeaconLayout, "/input/inputTest.txt"))
//				.add(new InputFile(InputFileType.ProjectConfig, "/input/inputTest.txt"));
		viewer.setInput(input);

		//设置隔行交替背景色
//		TableItem[] items = viewer.getTable().getItems();
//		for(int rowId=0;rowId<items.length;rowId++){
//			if(rowId%2==0)
//				items[rowId].setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
//		}

		return viewer;
	}
}
