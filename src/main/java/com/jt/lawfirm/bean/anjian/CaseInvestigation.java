package com.jt.lawfirm.bean.anjian;

import com.jt.lawfirm.bean.casea.Law;

/**
 * 	 侦查表
 * @author ly
 */
public class CaseInvestigation {
	
//	id bigint unsigned primary key auto_increment,
//	case_law_id varchar(50),-- 案件id
//	investigation_office varchar(50),-- 办案机关
//	investigation_no varchar(50),-- 侦查案号
//	investigation_dept varchar(50),-- 部门
//	investigation_undertaker varchar(50),-- 承办人
//	investigation_criminal_time date,-- 刑拘时间
//	investigation_arrest_time date,-- 逮捕时间
//	investigation_tel varchar(20),-- 联系电话
//	investigation_deadline 	int unsigned,-- 侦查期限
//	investigation_supplement_deadline  varchar(300),-- 侦查期限补充
//	investigation_secondary_supplementary varchar(300),-- 二次补充侦查
//	investigation_remark varchar(500) -- 备注
	
	private Integer id;
	private Integer caseLawId;//-- 案件id
	private String investigationOffice;//-- 办案机关
	private String investigationNo;//-- 侦查案号
	private String investigationDept;//- 部门
	private String investigationUndertaker;//-- 承办人
	private String investigationCriminalTime;//-- 刑拘时间
	private String investigationArrestTime;//-- 逮捕时间
	private String investigationTel;//-- 联系电话
	private String investigationDeadline;//-- 侦查期限
	private String investigationSupplementDeadline;//-- 侦查期限补充
	private String investigationSecondarySupplementary;//-- 二次补充侦查
	private String investigationRemark;// -- 备注
	
	private Law law;

	public CaseInvestigation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseInvestigation(Integer id, Integer caseLawId, String investigationOffice, String investigationNo,
			String investigationDept, String investigationUndertaker, String investigationCriminalTime,
			String investigationArrestTime, String investigationTel, String investigationDeadline,
			String investigationSupplementDeadline, String investigationSecondarySupplementary,
			String investigationRemark, Law law) {
		super();
		this.id = id;
		this.caseLawId = caseLawId;
		this.investigationOffice = investigationOffice;
		this.investigationNo = investigationNo;
		this.investigationDept = investigationDept;
		this.investigationUndertaker = investigationUndertaker;
		this.investigationCriminalTime = investigationCriminalTime;
		this.investigationArrestTime = investigationArrestTime;
		this.investigationTel = investigationTel;
		this.investigationDeadline = investigationDeadline;
		this.investigationSupplementDeadline = investigationSupplementDeadline;
		this.investigationSecondarySupplementary = investigationSecondarySupplementary;
		this.investigationRemark = investigationRemark;
		this.law = law;
	}

	@Override
	public String toString() {
		return "CaseInvestigation [id=" + id + ", caseLawId=" + caseLawId + ", investigationOffice="
				+ investigationOffice + ", investigationNo=" + investigationNo + ", investigationDept="
				+ investigationDept + ", investigationUndertaker=" + investigationUndertaker
				+ ", investigationCriminalTime=" + investigationCriminalTime + ", investigationArrestTime="
				+ investigationArrestTime + ", investigationTel=" + investigationTel + ", investigationDeadline="
				+ investigationDeadline + ", investigationSupplementDeadline=" + investigationSupplementDeadline
				+ ", investigationSecondarySupplementary=" + investigationSecondarySupplementary
				+ ", investigationRemark=" + investigationRemark + ", law=" + law + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaseLawId() {
		return caseLawId;
	}

	public void setCaseLawId(Integer caseLawId) {
		this.caseLawId = caseLawId;
	}

	public String getInvestigationOffice() {
		return investigationOffice;
	}

	public void setInvestigationOffice(String investigationOffice) {
		this.investigationOffice = investigationOffice;
	}

	public String getInvestigationNo() {
		return investigationNo;
	}

	public void setInvestigationNo(String investigationNo) {
		this.investigationNo = investigationNo;
	}

	public String getInvestigationDept() {
		return investigationDept;
	}

	public void setInvestigationDept(String investigationDept) {
		this.investigationDept = investigationDept;
	}

	public String getInvestigationUndertaker() {
		return investigationUndertaker;
	}

	public void setInvestigationUndertaker(String investigationUndertaker) {
		this.investigationUndertaker = investigationUndertaker;
	}

	public String getInvestigationCriminalTime() {
		return investigationCriminalTime;
	}

	public void setInvestigationCriminalTime(String investigationCriminalTime) {
		this.investigationCriminalTime = investigationCriminalTime;
	}

	public String getInvestigationArrestTime() {
		return investigationArrestTime;
	}

	public void setInvestigationArrestTime(String investigationArrestTime) {
		this.investigationArrestTime = investigationArrestTime;
	}

	public String getInvestigationTel() {
		return investigationTel;
	}

	public void setInvestigationTel(String investigationTel) {
		this.investigationTel = investigationTel;
	}

	public String getInvestigationDeadline() {
		return investigationDeadline;
	}

	public void setInvestigationDeadline(String investigationDeadline) {
		this.investigationDeadline = investigationDeadline;
	}

	public String getInvestigationSupplementDeadline() {
		return investigationSupplementDeadline;
	}

	public void setInvestigationSupplementDeadline(String investigationSupplementDeadline) {
		this.investigationSupplementDeadline = investigationSupplementDeadline;
	}

	public String getInvestigationSecondarySupplementary() {
		return investigationSecondarySupplementary;
	}

	public void setInvestigationSecondarySupplementary(String investigationSecondarySupplementary) {
		this.investigationSecondarySupplementary = investigationSecondarySupplementary;
	}

	public String getInvestigationRemark() {
		return investigationRemark;
	}

	public void setInvestigationRemark(String investigationRemark) {
		this.investigationRemark = investigationRemark;
	}

	public Law getLaw() {
		return law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}
}
