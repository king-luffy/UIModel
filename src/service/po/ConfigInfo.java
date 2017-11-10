package service.po;

import java.io.Serializable;

import service.po.dbcompare.PosPoCmp;

public class ConfigInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2070064543193544126L;
	private DBConfig baseConfig;
	private DBConfig cmpConfig;
	private PosPoCmp poCmp;
	public DBConfig getBaseConfig() {
		return baseConfig;
	}
	public void setBaseConfig(DBConfig baseConfig) {
		this.baseConfig = baseConfig;
	}
	public DBConfig getCmpConfig() {
		return cmpConfig;
	}
	public void setCmpConfig(DBConfig cmpConfig) {
		this.cmpConfig = cmpConfig;
	}
	public PosPoCmp getPoCmp() {
		return poCmp;
	}
	public void setPoCmp(PosPoCmp poCmp) {
		this.poCmp = poCmp;
	}
	
	
}
