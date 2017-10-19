package uimodel.input;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import uimodel.editor.BmvfGenEditPart;
import uimodel.editor.LeuGenEditPart;
import uimodel.editor.SingleBcnGenEditPart;
import uimodel.editor.cmp.InputModelCmp;
import uimodel.editor.fileIOTable.base.InputFile;
import uimodel.editor.fileIOTable.base.InputFileType;
import uimodel.editor.fileIOTable.base.InputModel;
import uimodel.util.ProjectPathHelper;
import uimodel.util.Serializer;

//import com.casco.uiLogging.Logging;



public class InputManager {

	public static final String LocalRecordFileName = "localRocord";

	private static Map<String, InputModel> inputRecord;

	public static InputModelCmp getCmpInputModel(){
		return new InputModelCmp();
	}
	
	public static InputModel getInputModel(String inputEditorId){

		//use serializer helper to get object
		Serializer serializer = new Serializer(getInputLocalFile());

		//not exist, then new an input model, and write to local
		Map<String, InputModel> inputRecord =
				(Map<String, InputModel>)serializer.readObjFromFile();
		if(inputRecord==null){
			inputRecord = createDefaultInputRecord();
			updateLocalAndMemory(inputRecord);
		}
		//get input model from local file
		InputModel inputModel = null;
		if(inputRecord.containsKey(inputEditorId))
			inputModel = inputRecord.get(inputEditorId);
		else {
//			Logging.error("Input Editor is illegal, can only be "+
//					SingleBcnGenEditPart.ID+" "+
//					BmvfGenEditPart.ID +" "+
//					LeuGenEditPart.ID
//					);
		}


		return inputModel;
	}
	private static void updateLocalAndMemory(Map<String, InputModel> inputRecord){
		Serializer serializer = new Serializer(getInputLocalFile());
		InputManager.inputRecord = inputRecord;
		serializer.writeObj2File(inputRecord);
	}
	public static void updateLocalData(){
		Serializer serializer = new Serializer(getInputLocalFile());
		serializer.writeObj2File(inputRecord);
	}

	private static Map<String, InputModel> createDefaultInputRecord(){
		Map<String, InputModel> inputRecord = new HashMap<String, InputModel>();

		//input file for single beacon generation
		InputModel imSingle = new InputModel();
		imSingle.add(new InputFile(InputFileType.SyDB, ""));
		imSingle.add(new InputFile(InputFileType.BeaconLayout, ""));
		imSingle.add(new InputFile(InputFileType.ProjectConfig, ""));
		imSingle.add(new InputFile(InputFileType.outputFloder, ""));
		inputRecord.put(SingleBcnGenEditPart.ID, imSingle);

		//input file for bmvf
		InputModel imBmvf = new InputModel();
		imBmvf.add(new InputFile(InputFileType.SyDB, ""));
		imBmvf.add(new InputFile(InputFileType.BeaconLayout, ""));
		imBmvf.add(new InputFile(InputFileType.ProjectConfig, ""));
		imBmvf.add(new InputFile(InputFileType.outputFloder, ""));
		inputRecord.put(BmvfGenEditPart.ID, imBmvf);

		//input file for leu generation
		InputModel imLeu = new InputModel();
		imLeu.add(new InputFile(InputFileType.Bmvf,""));
		imLeu.add(new InputFile(InputFileType.outputFloder, ""));
		inputRecord.put(LeuGenEditPart.ID, imLeu);

		return inputRecord;
	}

	private static File getInputLocalFile(){

		String localAddr = ProjectPathHelper.getProjectRootFloderPath();
		localAddr = ProjectPathHelper.addSepratorAtEnd(localAddr);
		localAddr += LocalRecordFileName;
		return new File(localAddr);
	}
}
