package com.jt.lawfirm.bean.log;

import java.util.Date;

/**
 * 
 * 日志表
 * */
public class Job {
	private int id;//主键
	private int whatisPerson;//归属人外键
	private int logtypeId;//外键
	private String law_id;//外键 案号ID
	private int cliendId;//客户ID 外键
	private String joblogStartTime;//开始时间
	private String joblogEnddTime;//结束时间
	private String joblogReportedTime;//自报时长
	private String  joblogUpdatetime;//更新时间
	private String addresslistState;
	private String joblogFile;//相关附件地址
	private String joblogText;//备注
	private String log_type_logname; // 日志类型
	private String client; // 客户名称


	private String detail;//类型详细


	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Job(int id, int whatisPerson, int logtypeId, String law_id, int cliendId, String joblogStartTime,
			String joblogEnddTime, String joblogReportedTime, String joblogUpdatetime, String addresslistState,
			String joblogFile, String joblogText, String log_type_logname, String client, String detail) {
		super();
		this.id = id;
		this.whatisPerson = whatisPerson;
		this.logtypeId = logtypeId;
		this.law_id = law_id;
		this.cliendId = cliendId;
		this.joblogStartTime = joblogStartTime;
		this.joblogEnddTime = joblogEnddTime;
		this.joblogReportedTime = joblogReportedTime;
		this.joblogUpdatetime = joblogUpdatetime;
		this.addresslistState = addresslistState;
		this.joblogFile = joblogFile;
		this.joblogText = joblogText;
		this.log_type_logname = log_type_logname;
		this.client = client;
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "Job [id=" + id + ", whatisPerson=" + whatisPerson + ", logtypeId=" + logtypeId + ", law_id=" + law_id
				+ ", cliendId=" + cliendId + ", joblogStartTime=" + joblogStartTime + ", joblogEnddTime="
				+ joblogEnddTime + ", joblogReportedTime=" + joblogReportedTime + ", joblogUpdatetime="
				+ joblogUpdatetime + ", addresslistState=" + addresslistState + ", joblogFile=" + joblogFile
				+ ", joblogText=" + joblogText + ", log_type_logname=" + log_type_logname + ", client=" + client
				+ ", detail=" + detail + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getWhatisPerson() {
		return whatisPerson;
	}


	public void setWhatisPerson(int whatisPerson) {
		this.whatisPerson = whatisPerson;
	}


	public int getLogtypeId() {
		return logtypeId;
	}


	public void setLogtypeId(int logtypeId) {
		this.logtypeId = logtypeId;
	}


	public String getLaw_id() {
		return law_id;
	}


	public void setLaw_id(String law_id) {
		this.law_id = law_id;
	}


	public int getCliendId() {
		return cliendId;
	}


	public void setCliendId(int cliendId) {
		this.cliendId = cliendId;
	}


	public String getJoblogStartTime() {
		return joblogStartTime;
	}


	public void setJoblogStartTime(String joblogStartTime) {
		this.joblogStartTime = joblogStartTime;
	}


	public String getJoblogEnddTime() {
		return joblogEnddTime;
	}


	public void setJoblogEnddTime(String joblogEnddTime) {
		this.joblogEnddTime = joblogEnddTime;
	}


	public String getJoblogReportedTime() {
		return joblogReportedTime;
	}


	public void setJoblogReportedTime(String joblogReportedTime) {
		this.joblogReportedTime = joblogReportedTime;
	}


	public String getJoblogUpdatetime() {
		return joblogUpdatetime;
	}


	public void setJoblogUpdatetime(String joblogUpdatetime) {
		this.joblogUpdatetime = joblogUpdatetime;
	}


	public String getAddresslistState() {
		return addresslistState;
	}


	public void setAddresslistState(String addresslistState) {
		this.addresslistState = addresslistState;
	}


	public String getJoblogFile() {
		return joblogFile;
	}


	public void setJoblogFile(String joblogFile) {
		this.joblogFile = joblogFile;
	}


	public String getJoblogText() {
		return joblogText;
	}


	public void setJoblogText(String joblogText) {
		this.joblogText = joblogText;
	}


	public String getLog_type_logname() {
		return log_type_logname;
	}


	public void setLog_type_logname(String log_type_logname) {
		this.log_type_logname = log_type_logname;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}



}
