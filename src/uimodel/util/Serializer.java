package uimodel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serializer {


	private File file = null;

	public Serializer(String filePath){
		file = new File(filePath);
	}
	public Serializer(File file){
		this.file = file;
	}


	public boolean writeObj2File(Object obj){

		//when file not exist, create a new one, when create failed, return false
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!file.exists())
				return false;
		}

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));

			out.writeObject(obj);

			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	return true;
	}

	public Object readObjFromFile(){
		if(!file.exists())
			return null;
		ObjectInputStream in = null;
		Object object = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));

			object = in.readObject();

			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}
}
