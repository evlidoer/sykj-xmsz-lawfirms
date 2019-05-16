package com.jt.lawfirm.bean.system;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Role {
	@TableId(type = IdType.AUTO)
	private	Integer id;
	private	String rname;
	private String remark;
	private List<?> permission;
	
	public List<?> getPermission() {
		return permission;
	}
	public void setPermission(List<?> permission) {
		this.permission = permission;
	}
	public Role() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rname=" + rname + ", remark=" + remark + ", permission=" + permission + "]";
	}
}
