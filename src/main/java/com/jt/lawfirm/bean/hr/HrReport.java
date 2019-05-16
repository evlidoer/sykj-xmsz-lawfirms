package com.jt.lawfirm.bean.hr;
//-- 上报表
public class HrReport {
	private Integer id;// bigint primary key auto_increment,		#上报id
	private Integer reportCaseid;// bigint not null,				#外键，案件id
	private String reportDate;// date 	
	public HrReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrReport(Integer id, Integer reportCaseid, String reportDate) {
		super();
		this.id = id;
		this.reportCaseid = reportCaseid;
		this.reportDate = reportDate;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", reportCaseid=" + reportCaseid + ", reportDate=" + reportDate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReportCaseid() {
		return reportCaseid;
	}
	public void setReportCaseid(Integer reportCaseid) {
		this.reportCaseid = reportCaseid;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	
}
