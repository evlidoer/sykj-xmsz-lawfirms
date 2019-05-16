package com.jt.lawfirm.bean.log;

import java.sql.Date;

/**
 * 
 * @author 二乐
 *system_log(#模板系统日志)
 * 关键字原因改了bean层名字为template
 */

public class Template {
	private int id;//主键
	private int  clientId;//外键 客户ID
	private int  systemTypeId;//外键
	private String systemLogLogexplain;//日志说明
	private String systemLogIp;//操作ip
	private Date systemLogRecordTime;//记录时间
	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Template(int id, int clientId, int systemTypeId, String systemLogLogexplain, String systemLogIp,
			Date systemLogRecordTime) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.systemTypeId = systemTypeId;
		this.systemLogLogexplain = systemLogLogexplain;
		this.systemLogIp = systemLogIp;
		this.systemLogRecordTime = systemLogRecordTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getSystemTypeId() {
		return systemTypeId;
	}
	public void setSystemTypeId(int systemTypeId) {
		this.systemTypeId = systemTypeId;
	}
	public String getSystemLogLogexplain() {
		return systemLogLogexplain;
	}
	public void setSystemLogLogexplain(String systemLogLogexplain) {
		this.systemLogLogexplain = systemLogLogexplain;
	}
	public String getSystemLogIp() {
		return systemLogIp;
	}
	public void setSystemLogIp(String systemLogIp) {
		this.systemLogIp = systemLogIp;
	}
	public Date getSystemLogRecordTime() {
		return systemLogRecordTime;
	}
	public void setSystemLogRecordTime(Date systemLogRecordTime) {
		this.systemLogRecordTime = systemLogRecordTime;
	}
	@Override
	public String toString() {
		return "Template [id=" + id + ", clientId=" + clientId + ", systemTypeId=" + systemTypeId
				+ ", systemLogLogexplain=" + systemLogLogexplain + ", systemLogIp=" + systemLogIp
				+ ", systemLogRecordTime=" + systemLogRecordTime + "]";
	}

	
	
}
