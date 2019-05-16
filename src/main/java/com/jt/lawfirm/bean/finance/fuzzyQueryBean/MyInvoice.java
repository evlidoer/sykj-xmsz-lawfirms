package com.jt.lawfirm.bean.finance.fuzzyQueryBean;

/**
 * 
 * @author theFlyingCat
 *
 */
public class MyInvoice {
	
	private String id;
	private String caseId;
	private String caseIdNum;
	private String kStatus;
	private String kType;
	private String kProject;
	private String cType;
	private String startTime;
	private String endTime;
	
	public MyInvoice() {
		// TODO Auto-generated constructor stub
	}

	public MyInvoice(String id, String caseId, String caseIdNum, String kStatus, String kType, String kProject,
			String cType, String startTime, String endTime) {
		super();
		this.id = id;
		this.caseId = caseId;
		this.caseIdNum = caseIdNum;
		this.kStatus = kStatus;
		this.kType = kType;
		this.kProject = kProject;
		this.cType = cType;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MyInvoice [id=" + id + ", caseId=" + caseId + ", caseIdNum=" + caseIdNum + ", kStatus=" + kStatus
				+ ", kType=" + kType + ", kProject=" + kProject + ", cType=" + cType + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseIdNum() {
		return caseIdNum;
	}

	public void setCaseIdNum(String caseIdNum) {
		this.caseIdNum = caseIdNum;
	}

	public String getkStatus() {
		return kStatus;
	}

	public void setkStatus(String kStatus) {
		this.kStatus = kStatus;
	}

	public String getkType() {
		return kType;
	}

	public void setkType(String kType) {
		this.kType = kType;
	}

	public String getkProject() {
		return kProject;
	}

	public void setkProject(String kProject) {
		this.kProject = kProject;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
