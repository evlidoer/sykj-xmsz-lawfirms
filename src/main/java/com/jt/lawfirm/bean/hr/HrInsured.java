package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//-- 参保情况表
public class HrInsured {
	@TableId(type=IdType.AUTO)
	private Integer id;// bigint primary key auto_increment,	#参保id
	private String insuredName;// varchar(20)				#参保名称
	private Integer hrEmpId;
	public HrInsured() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getHrEmpId() {
		return hrEmpId;
	}

	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}

	@Override
	public String toString() {
		return "HrInsured [id=" + id + ", insuredName=" + insuredName + ", hrEmpId=" + hrEmpId + "]";
	}

	public HrInsured(Integer id, String insuredName, Integer hrEmpId) {
		super();
		this.id = id;
		this.insuredName = insuredName;
		this.hrEmpId = hrEmpId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
}
