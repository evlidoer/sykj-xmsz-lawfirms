package com.jt.lawfirm.bean.finance.fuzzyQueryBean;


/**
 * 
 * @author theFlyingCat
 *
 */
//我的收支页面传参
public class MyBudget {
	
	private String hrEmpId; //案号
	private String caseId; //案号
	private String inType; //收支类型
	private String payment; //支付方式
	private String cType; //案件类型
	private String startTime; //起始时间
	private String endTime; //终止时间
	
	public MyBudget() {
		// TODO Auto-generated constructor stub
	}

	public MyBudget(String hrEmpId, String caseId, String inType, String payment, String cType, String startTime,
			String endTime) {
		super();
		this.hrEmpId = hrEmpId;
		this.caseId = caseId;
		this.inType = inType;
		this.payment = payment;
		this.cType = cType;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MyBudget [hrEmpId=" + hrEmpId + ", caseId=" + caseId + ", inType=" + inType + ", payment=" + payment
				+ ", cType=" + cType + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public String getHrEmpId() {
		return hrEmpId;
	}

	public void setHrEmpId(String hrEmpId) {
		this.hrEmpId = hrEmpId;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getInType() {
		return inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
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
