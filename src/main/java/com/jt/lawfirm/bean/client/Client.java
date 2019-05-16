package com.jt.lawfirm.bean.client;

import com.jt.lawfirm.bean.hr.HrEmp;

public class Client {
	private Integer id;
	private String client;
	private String tel;
	private String status;
	private String postscript ;
	private Integer lawnum;
	private Detail detail;
	private Typemsg typemsg;
	private Integer empid;
	
	private HrEmp hremp;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Integer id, String client, String tel, String status, String postscript, Integer lawnum,
			Detail detail, Typemsg typemsg, Integer empid, HrEmp hremp) {
		super();
		this.id = id;
		this.client = client;
		this.tel = tel;
		this.status = status;
		this.postscript = postscript;
		this.lawnum = lawnum;
		this.detail = detail;
		this.typemsg = typemsg;
		this.empid = empid;
		this.hremp = hremp;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", client=" + client + ", tel=" + tel + ", status=" + status + ", postscript="
				+ postscript + ", lawnum=" + lawnum + ", detail=" + detail + ", typemsg=" + typemsg + ", empid=" + empid
				+ ", hremp=" + hremp + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPostscript() {
		return postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	public Integer getLawnum() {
		return lawnum;
	}

	public void setLawnum(Integer lawnum) {
		this.lawnum = lawnum;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Typemsg getTypemsg() {
		return typemsg;
	}

	public void setTypemsg(Typemsg typemsg) {
		this.typemsg = typemsg;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public HrEmp getHremp() {
		return hremp;
	}

	public void setHremp(HrEmp hremp) {
		this.hremp = hremp;
	}

}
