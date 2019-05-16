package com.jt.lawfirm.bean.anjian;

public class CaseServiceLog {
	private Integer id;
	private Integer clientid;//-- 客户外键
	private Integer caselawid;//-- 案件外键
	private String logservicetime;// -- 服务时间
	private String logconsultservicetype;// -- 咨询服务类型
	private Integer logservicecount;// -- 服务人次
	private Double logserviceprice;// -- 服务费用
	private String logregistertime;//-- 等级时间
//	private Integer id;
//	private Integer client_id;//-- 客户外键
//	private Integer caselawid;// -- 律师外键
//	private Integer log_service_time;// -- 服务时间
//	private String log_consult_service_type;// -- 咨询服务类型
//	private Integer log_service_count;// -- 服务人次
//	private Integer log_service_price;// -- 服务费用
//	private Integer log_register_time ;//-- 等级时间
	public CaseServiceLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaseServiceLog(Integer id, Integer clientid, Integer caselawid, String logservicetime,
			String logconsultservicetype, Integer logservicecount, Double logserviceprice, String logregistertime) {
		super();
		this.id = id;
		this.clientid = clientid;
		this.caselawid = caselawid;
		this.logservicetime = logservicetime;
		this.logconsultservicetype = logconsultservicetype;
		this.logservicecount = logservicecount;
		this.logserviceprice = logserviceprice;
		this.logregistertime = logregistertime;
	}
	@Override
	public String toString() {
		return "CaseServiceLog [id=" + id + ", clientid=" + clientid + ", caselawid=" + caselawid + ", logservicetime="
				+ logservicetime + ", logconsultservicetype=" + logconsultservicetype + ", logservicecount="
				+ logservicecount + ", logserviceprice=" + logserviceprice + ", logregistertime=" + logregistertime
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public Integer getCaselawid() {
		return caselawid;
	}
	public void setCaselawid(Integer caselawid) {
		this.caselawid = caselawid;
	}
	public String getLogservicetime() {
		return logservicetime;
	}
	public void setLogservicetime(String logservicetime) {
		this.logservicetime = logservicetime;
	}
	public String getLogconsultservicetype() {
		return logconsultservicetype;
	}
	public void setLogconsultservicetype(String logconsultservicetype) {
		this.logconsultservicetype = logconsultservicetype;
	}
	public Integer getLogservicecount() {
		return logservicecount;
	}
	public void setLogservicecount(Integer logservicecount) {
		this.logservicecount = logservicecount;
	}
	public Double getLogserviceprice() {
		return logserviceprice;
	}
	public void setLogserviceprice(Double logserviceprice) {
		this.logserviceprice = logserviceprice;
	}
	public String getLogregistertime() {
		return logregistertime;
	}
	public void setLogregistertime(String logregistertime) {
		this.logregistertime = logregistertime;
	}

	
}
