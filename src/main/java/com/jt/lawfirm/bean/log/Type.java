package com.jt.lawfirm.bean.log;

/**
 * 
 * @author 二乐
 *日志类型表
 */
public class Type {
	private int id;//主键
	private String logTypeLogname;//日志类型
	private int logTypePid;//自关联id（详细类别）
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int id, String logTypeLogname, int logTypePid) {
		super();
		this.id = id;
		this.logTypeLogname = logTypeLogname;
		this.logTypePid = logTypePid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogTypeLogname() {
		return logTypeLogname;
	}
	public void setLogTypeLogname(String logTypeLogname) {
		this.logTypeLogname = logTypeLogname;
	}
	public int getLogTypePid() {
		return logTypePid;
	}
	public void setLogTypePid(int logTypePid) {
		this.logTypePid = logTypePid;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", logTypeLogname=" + logTypeLogname + ", logTypePid=" + logTypePid + "]";
	}
	
	
	
}