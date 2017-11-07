package controller;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import service.impl.DBInfoFetch;
import service.po.DBConfig;
import service.po.PosPo;

public class CompareController {

	public static String fetchDBInfo(DBConfig dbConfig){
		
		DBInfoFetch fetcher = new DBInfoFetch();
		Properties properties = new Properties();
		dbConfig.setUrl(DBConfig.formateUrl(dbConfig));
		properties.setProperty("db.url", dbConfig.getUrl());
		properties.setProperty("db.username", dbConfig.getUserName());
		properties.setProperty("db.password", dbConfig.getUserPwd());
		properties.setProperty("db.driver", dbConfig.getDriver());
		
		PosPo posPo = fetcher.fetchDBInfo(properties);
		
		return JSON.toJSONString(posPo,true);
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
