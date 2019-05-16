package com.jt.lawfirm.bean.finance;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author theFlyingCat
 *
 */

//收支类型
@TableName("cw_inout_type")
public class InoutType {

	private Integer id; // 类型ID
	private String cwName; // 类别名称
	private Integer cwPid; // 类型上级ID

	public InoutType() {
		// TODO Auto-generated constructor stub
	}

	public InoutType(Integer id, String cwName, Integer cwPid) {
		this.id = id;
		this.cwName = cwName;
		this.cwPid = cwPid;
	}

	@Override
	public String toString() {
		return "InoutType [id=" + id + ", cwName=" + cwName + ", cwPid=" + cwPid + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCwName() {
		return cwName;
	}

	public void setCwName(String cwName) {
		this.cwName = cwName;
	}

	public Integer getCwPid() {
		return cwPid;
	}

	public void setCwPid(Integer cwPid) {
		this.cwPid = cwPid;
	}

}
