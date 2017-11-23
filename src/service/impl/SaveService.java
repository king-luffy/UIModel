package service.impl;

import service.po.ConfigInfo;
import service.po.DBPo;
import service.util.JsonUtil;
import service.util.SerializerUtil;


/**
 * Created by king_luffy on 2017/9/9.
 */
public class SaveService {

	public static final String CONFIG_FILE_NAME = "CmpConfig";
	
	public static void saveConfig(ConfigInfo configInfo){
		SerializerUtil.serialization(configInfo, CONFIG_FILE_NAME);
	}
	
	public static ConfigInfo loadConfig(){
		return SerializerUtil.deserialization(CONFIG_FILE_NAME);
	}
	
    public static void main(String[] args) {
        DBPo dbPo = new DBPo();
        dbPo.setDbId("001");
        dbPo.setDbName("ttt");
        String fileName = "logInfo.out";
        System.out.println(JsonUtil.getJsonString(dbPo,true));

        SerializerUtil.serialization(dbPo,fileName);

        DBPo dbPo1 = SerializerUtil.deserialization(fileName);

        System.out.println(JsonUtil.getJsonString(dbPo1,true));
    }
}
