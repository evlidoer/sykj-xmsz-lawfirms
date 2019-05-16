package com.jt.lawfirm.bean.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("system_user")
public class Log {
	@TableId(type=IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String systemTypeId;
	private String systemLogLogexplain;
	private String systemLogIp;
	private String systemLogRecordTime;
	@TableField(exist=false)
	private String userName;
	public Log() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public void setSystemTypeId(String systemTypeId) {
		if (systemTypeId.trim().equals("")) {
			systemTypeId = null;
		}
		this.systemTypeId = systemTypeId;
	}

	public String getSystemLogLogexplain() {
		return systemLogLogexplain;
	}

	public void setSystemLogLogexplain(String systemLogLogexplain) {
		if (systemLogLogexplain.trim().equals("")) {
			systemLogLogexplain = null;
		}
		this.systemLogLogexplain = systemLogLogexplain;
	}

	public String getSystemLogIp() {
		return systemLogIp;
	}

	public void setSystemLogIp(String systemLogIp) {
		if (systemLogIp.trim().equals("")) {
			systemLogIp = null;
		}
		this.systemLogIp = systemLogIp;
	}

	public String getSystemLogRecordTime() {
		return systemLogRecordTime;
	}

	public void setSystemLogRecordTime(String systemLogRecordTime) {
		if (systemLogRecordTime.trim().equals("")) {
			systemLogRecordTime = null;
		}
		this.systemLogRecordTime = systemLogRecordTime;
	}

	public String getSystemTypeId() {
		return systemTypeId;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", userId=" + userId + ", systemTypeId=" + systemTypeId + ", systemLogLogexplain="
				+ systemLogLogexplain + ", systemLogIp=" + systemLogIp + ", systemLogRecordTime=" + systemLogRecordTime
				+ ", userName=" + userName + "]";
	}

	public Log(Integer id, Integer userId, String systemTypeId, String systemLogLogexplain, String systemLogIp,
			String systemLogRecordTime, String userName) {
		super();
		this.id = id;
		this.userId = userId;
		this.systemTypeId = systemTypeId;
		this.systemLogLogexplain = systemLogLogexplain;
		this.systemLogIp = systemLogIp;
		this.systemLogRecordTime = systemLogRecordTime;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
