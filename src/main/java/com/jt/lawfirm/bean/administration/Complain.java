package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.client.Client;

@TableName(value = "adm_complain")
public class Complain {
	private int id;
	private String  complainContent;//建议/投诉内容
	private int  lawCaseId;//关联案件表
	private int  clientId;//关联客户表
	private String    complain_submit_time;//提交时间
	private int complain_reply_numbe;//回复数
	private String	complain_status;
	private Law law;//案件表
	private Client client;
	public Complain(int id, String complainContent, int lawCaseId, int clientId, String complain_submit_time,
			int complain_reply_numbe, String complain_status, Law law, Client client) {
		super();
		this.id = id;
		this.complainContent = complainContent;
		this.lawCaseId = lawCaseId;
		this.clientId = clientId;
		this.complain_submit_time = complain_submit_time;
		this.complain_reply_numbe = complain_reply_numbe;
		this.complain_status = complain_status;
		this.law = law;
		this.client = client;
	}
	
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComplainContent() {
		return complainContent;
	}


	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}


	public int getLawCaseId() {
		return lawCaseId;
	}


	public void setLawCaseId(int lawCaseId) {
		this.lawCaseId = lawCaseId;
	}


	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getComplain_submit_time() {
		return complain_submit_time;
	}


	public void setComplain_submit_time(String complain_submit_time) {
		this.complain_submit_time = complain_submit_time;
	}


	public int getComplain_reply_numbe() {
		return complain_reply_numbe;
	}


	public void setComplain_reply_numbe(int complain_reply_numbe) {
		this.complain_reply_numbe = complain_reply_numbe;
	}


	public String getComplain_status() {
		return complain_status;
	}


	public void setComplain_status(String complain_status) {
		this.complain_status = complain_status;
	}


	public Law getLaw() {
		return law;
	}


	public void setLaw(Law law) {
		this.law = law;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Complain [id=" + id + ", complainContent=" + complainContent + ", lawCaseId=" + lawCaseId
				+ ", clientId=" + clientId + ", complain_submit_time=" + complain_submit_time
				+ ", complain_reply_numbe=" + complain_reply_numbe + ", complain_status=" + complain_status + ", law="
				+ law + ", client=" + client + "]";
	}
}
