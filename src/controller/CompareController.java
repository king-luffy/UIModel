package controller;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import service.ex.DBCompareException;
import service.impl.DBComparer;
import service.impl.DBInfoFetch;
import service.po.DBConfig;
import service.po.PosPo;
import service.po.dbcompare.PosPoCmp;

public class CompareController {
	private static Logger logger = Logger.getLogger(CompareController.class);
	public static PosPo fetchDBInfo(DBConfig dbConfig){
		
		DBInfoFetch fetcher = new DBInfoFetch();
		Properties properties = new Properties();
		dbConfig.setUrl(DBConfig.formateUrl(dbConfig));
		properties.setProperty("db.url", dbConfig.getUrl());
		properties.setProperty("db.username", dbConfig.getUserName());
		properties.setProperty("db.password", dbConfig.getUserPwd());
		properties.setProperty("db.driver", dbConfig.getDriver());
		
		PosPo posPo = fetcher.fetchDBInfo(properties);
		
		return posPo;
	}
	
	public static String toJSONString(Object obj){
		return JSON.toJSONString(obj,true);
	}
	
	public static PosPoCmp cmpDB(PosPo basePos,PosPo cmpPos){
		DBComparer dbComparer = new DBComparer();
		try {
			return dbComparer.dbCompare(basePos, cmpPos);
		} catch (DBCompareException e) {
			logger.error(e);
		}
		return null;
	}
	
	public static void main(String[] args) {
//		DBConfig dbConfig = new DBConfig();
//		dbConfig.setDbIp("172.16.7.132");
//		dbConfig.setDbName("dinning");
//		dbConfig.setUserName("sa");
//		dbConfig.setUserPwd("kingking");
//		fetchDBInfo(dbConfig);
		
		Logger logger = Logger.getLogger(CompareController.class);
		logger.info("test log");
		
	}
}
