package service.impl;

import service.po.DBPo;
import service.util.JsonUtil;
import service.util.SerializerUtil;


/**
 * Created by king_luffy on 2017/9/9.
 */
public class SaveService {

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
