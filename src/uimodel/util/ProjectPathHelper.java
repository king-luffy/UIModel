package uimodel.util;

import java.io.File;

public class ProjectPathHelper {


	public static String getProjectRootFloderPath(){
		return System.getProperty("user.dir");
	}

	public static String addSepratorAtEnd(String floderPath){
		//File file = new File(floderPath);
		if((!floderPath.endsWith("\\") || !floderPath.endsWith("/"))){
			floderPath+=File.separatorChar;
		}
		return floderPath;
	}


	class Test{

		public void testGetProjectRootFloder(){
			String result =ProjectPathHelper.getProjectRootFloderPath();
			System.out.println(result);
		}

		public void testAddSepratorAtEnd(String path){
			System.out.println(ProjectPathHelper.addSepratorAtEnd(path));
		}
	}


	public static void main(String[] args) {


	}
}
