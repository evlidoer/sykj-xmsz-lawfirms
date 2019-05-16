package com.jt.lawfirm.bean.casea;

import java.util.Date;

import com.jt.lawfirm.bean.system.User;

public class CaseApproval {
	private Integer id;//
	private Date approvalDate;//审批时间
	private String approvalStaus;//审批状态
	private Integer systemRoleId;//外键 user 审批人
	private Integer lawId;//审批案件 外键
	private String approvalText;//审批说明
	private Law law;
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getApprovalStaus() {
		return approvalStaus;
	}
	public void setApprovalStaus(String approvalStaus) {
		this.approvalStaus = approvalStaus;
	}
	public Integer getSystemRoleId() {
		return systemRoleId;
	}
	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}
	public Integer getLawId() {
		return lawId;
	}
	public void setLawId(Integer lawId) {
		this.lawId = lawId;
	}
	public String getApprovalText() {
		return approvalText;
	}
	public void setApprovalText(String approvalText) {
		this.approvalText = approvalText;
	}
	public Law getLaw() {
		return law;
	}
	public void setLaw(Law law) {
		this.law = law;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CaseApproval [id=" + id + ", approvalDate=" + approvalDate + ", approvalStaus=" + approvalStaus
				+ ", systemRoleId=" + systemRoleId + ", lawId=" + lawId + ", approvalText=" + approvalText + ", law="
				+ law + ", user=" + user + "]";
	}
	public CaseApproval() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
