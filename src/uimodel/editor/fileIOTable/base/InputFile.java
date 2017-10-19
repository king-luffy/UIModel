package uimodel.editor.fileIOTable.base;

import java.io.Serializable;

public class InputFile implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private InputFileType inputFileType;
	private String filePath;

	public InputFileType getInputFileType() {
		return inputFileType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public InputFile(InputFileType inputFileType, String filePath) {
		super();
		this.inputFileType = inputFileType;
		this.filePath = filePath;
	}



}
