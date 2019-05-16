package com.jt.lawfirm.bean.finance.fuzzyQueryBean;

public class MyIncomeOfSive {
	
	private String startTime; //起始时间
	
	private String endTime; //终止时间
	
	public MyIncomeOfSive() {
		// TODO Auto-generated constructor stub
	}
	
	public MyIncomeOfSive(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MyIncomeOfSive [startTime=" + startTime + ", endTime=" + endTime + "]";
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
