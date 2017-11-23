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
	private PosPo basePo;
	private PosPo cmpPo;
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
	public PosPo getBasePo() {
		return basePo;
	}
	public void setBasePo(PosPo basePo) {
		this.basePo = basePo;
	}
	public PosPo getCmpPo() {
		return cmpPo;
	}
	public void setCmpPo(PosPo cmpPo) {
		this.cmpPo = cmpPo;
	}
	
	
}
