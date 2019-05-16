package com.jt.lawfirm.bean.anjian;

import com.jt.lawfirm.bean.casea.Law;

/**
 * 		-- 检察机关 表
 * @author ly
 *
 */
public class CaseProcuratorialWork {
	
//		id bigint unsigned primary key auto_increment,
//			case_law_id varchar(50),-- 案件id
//	work_office varchar(50),-- 办案机关
//		work_dept varchar(50),-- 部门
//	work_undertaker varchar(50),-- 承办人
//		work_tel varchar(20),-- 联系电话
//		work_investigate_prosecute_time date -- 审查起诉时间
	
	private Integer id ;
	private Integer caseLawId ;//-- 案件id
	private String workOffice ;//-- 办案机关
	private String workDept ;//-- 部门
	private String workUndertaker ;//-- 承办人
	private String workTel ;//-- 联系电话
	private String workInvestigateProsecuteime;//-- 审查起诉时间
	
	private Law law;

	public CaseProcuratorialWork() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseProcuratorialWork(Integer id, Integer caseLawId, String workOffice, String workDept,
			String workUndertaker, String workTel, String workInvestigateProsecuteime, Law law) {
		super();
		this.id = id;
		this.caseLawId = caseLawId;
		this.workOffice = workOffice;
		this.workDept = workDept;
		this.workUndertaker = workUndertaker;
		this.workTel = workTel;
		this.workInvestigateProsecuteime = workInvestigateProsecuteime;
		this.law = law;
	}

	@Override
	public String toString() {
		return "caseProcuratorialWork [id=" + id + ", caseLawId=" + caseLawId + ", workOffice=" + workOffice
				+ ", workDept=" + workDept + ", workUndertaker=" + workUndertaker + ", workTel=" + workTel
				+ ", workInvestigateProsecuteime=" + workInvestigateProsecuteime + ", law=" + law + "]";
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

	public String getWorkOffice() {
		return workOffice;
	}

	public void setWorkOffice(String workOffice) {
		this.workOffice = workOffice;
	}

	public String getWorkDept() {
		return workDept;
	}

	public void setWorkDept(String workDept) {
		this.workDept = workDept;
	}

	public String getWorkUndertaker() {
		return workUndertaker;
	}

	public void setWorkUndertaker(String workUndertaker) {
		this.workUndertaker = workUndertaker;
	}

	public String getWorkTel() {
		return workTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

	public String getWorkInvestigateProsecuteime() {
		return workInvestigateProsecuteime;
	}

	public void setWorkInvestigateProsecuteime(String workInvestigateProsecuteime) {
		this.workInvestigateProsecuteime = workInvestigateProsecuteime;
	}

	public Law getLaw() {
		return law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}
	
}
