package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 	外部联系人
 */
@TableName(value = "adm_external")
public class External {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String externalCompanyname;//公司名称
	private String dept;//#部门
	private String jobtitle;//职位
	private String externalContacts;//联系人
	private String externalCellphonenumber;//#手机号
	private String externalTelephone;//座机号
	private String externalFax;//传真号码
	private String  externalFamily;//详细地址
	private String externalPostbox;//邮箱
	private String externalComment;//备注说明
	public External() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExternalCompanyname() {
		return externalCompanyname;
	}
	public void setExternalCompanyname(String externalCompanyname) {
		this.externalCompanyname = externalCompanyname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getExternalContacts() {
		return externalContacts;
	}
	public void setExternalContacts(String externalContacts) {
		this.externalContacts = externalContacts;
	}
	public String getExternalCellphonenumber() {
		return externalCellphonenumber;
	}
	public void setExternalCellphonenumber(String externalCellphonenumber) {
		this.externalCellphonenumber = externalCellphonenumber;
	}
	public String getExternalTelephone() {
		return externalTelephone;
	}
	public void setExternalTelephone(String externalTelephone) {
		this.externalTelephone = externalTelephone;
	}
	public String getExternalFax() {
		return externalFax;
	}
	public void setExternalFax(String externalFax) {
		this.externalFax = externalFax;
	}
	public String getExternalFamily() {
		return externalFamily;
	}
	public void setExternalFamily(String externalFamily) {
		this.externalFamily = externalFamily;
	}
	public String getExternalPostbox() {
		return externalPostbox;
	}
	public void setExternalPostbox(String externalPostbox) {
		this.externalPostbox = externalPostbox;
	}
	public String getExternalComment() {
		return externalComment;
	}
	public void setExternalComment(String externalComment) {
		this.externalComment = externalComment;
	}
	@Override
	public String toString() {
		return "External [id=" + id + ", externalCompanyname=" + externalCompanyname + ", dept=" + dept + ", jobtitle="
				+ jobtitle + ", externalContacts=" + externalContacts + ", externalCellphonenumber="
				+ externalCellphonenumber + ", externalTelephone=" + externalTelephone + ", externalFax=" + externalFax
				+ ", externalFamily=" + externalFamily + ", externalPostbox=" + externalPostbox + ", externalComment="
				+ externalComment + "]";
	}
}
