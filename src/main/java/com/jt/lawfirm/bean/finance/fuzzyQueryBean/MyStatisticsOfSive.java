package com.jt.lawfirm.bean.finance.fuzzyQueryBean;

/**
 * 
 * @author theFlyingCat
 *
 */
public class MyStatisticsOfSive {
	
	private Integer id; //员工ID
	
	private String startTime; //起始时间
	
	private String endTime; //终止时间
	
	public MyStatisticsOfSive() {
		// TODO Auto-generated constructor stub
	}

	public MyStatisticsOfSive(Integer id, String startTime, String endTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MyStatisticsOfSive [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
