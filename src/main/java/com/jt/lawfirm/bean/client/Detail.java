package com.jt.lawfirm.bean.client;

public class Detail {
	private Integer id;
	private Integer clientId;
	private String clientAssign;
	private String clientPrincipal;
	private String clientContacts;
	private String clientEmail;
	private String clientDuty;
	private String clientInfluence;
	private String clientPhone;
	private String clientRegion;
	private String clientStuatus;
	private String clientBehalf;
	private String clientLegalphone;
	private String clientFile;
	private String clientIdcard;
	private Integer clientNationid;
	private String clientSex;
	private String clientSite;
	private String clientRemark;
	private String clientAddtime;
	private Integer empId;
	
	
	public String getClientAddtime() {
		return clientAddtime;
	}
	public void setClientAddtime(String clientAddtime) {
		this.clientAddtime = clientAddtime;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientPrincipal() {
		return clientPrincipal;
	}
	public void setClientPrincipal(String clientPrincipal) {
		this.clientPrincipal = clientPrincipal;
	}
	public String getClientContacts() {
		return clientContacts;
	}
	public void setClientContacts(String clientContacts) {
		this.clientContacts = clientContacts;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientDuty() {
		return clientDuty;
	}
	public void setClientDuty(String clientDuty) {
		this.clientDuty = clientDuty;
	}
	public String getClientInfluence() {
		return clientInfluence;
	}
	public void setClientInfluence(String clientInfluence) {
		this.clientInfluence = clientInfluence;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getClientRegion() {
		return clientRegion;
	}
	public void setClientRegion(String clientRegion) {
		this.clientRegion = clientRegion;
	}
	public String getClientStuatus() {
		return clientStuatus;
	}
	public void setClientStuatus(String clientStuatus) {
		this.clientStuatus = clientStuatus;
	}
	public String getClientBehalf() {
		return clientBehalf;
	}
	public void setClientBehalf(String clientBehalf) {
		this.clientBehalf = clientBehalf;
	}
	public String getClientLegalphone() {
		return clientLegalphone;
	}
	public void setClientLegalphone(String clientLegalphone) {
		this.clientLegalphone = clientLegalphone;
	}
	public String getClientFile() {
		return clientFile;
	}
	public void setClientFile(String clientFile) {
		this.clientFile = clientFile;
	}
	public String getClientIdcard() {
		return clientIdcard;
	}
	public void setClientIdcard(String clientIdcard) {
		this.clientIdcard = clientIdcard;
	}
	public Integer getClientNationid() {
		return clientNationid;
	}
	public void setClientNationid(Integer clientNationid) {
		this.clientNationid = clientNationid;
	}
	public String getClientSex() {
		return clientSex;
	}
	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}
	public String getClientSite() {
		return clientSite;
	}
	public void setClientSite(String clientSite) {
		this.clientSite = clientSite;
	}
	public String getClientRemark() {
		return clientRemark;
	}
	public void setClientRemark(String clientRemark) {
		this.clientRemark = clientRemark;
	}
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClientAssign() {
		return clientAssign;
	}
	public void setClientAssign(String clientAssign) {
		this.clientAssign = clientAssign;
	}
	@Override
	public String toString() {
		return "Detail [id=" + id + ", clientId=" + clientId + ", clientAssign=" + clientAssign + ", clientPrincipal="
				+ clientPrincipal + ", clientContacts=" + clientContacts + ", clientEmail=" + clientEmail
				+ ", clientDuty=" + clientDuty + ", clientInfluence=" + clientInfluence + ", clientPhone=" + clientPhone
				+ ", clientRegion=" + clientRegion + ", clientStuatus=" + clientStuatus + ", clientBehalf="
				+ clientBehalf + ", clientLegalphone=" + clientLegalphone + ", clientFile=" + clientFile
				+ ", clientIdcard=" + clientIdcard + ", clientNationid=" + clientNationid + ", clientSex=" + clientSex
				+ ", clientSite=" + clientSite + ", clientRemark=" + clientRemark + ", clientAddtime=" + clientAddtime
				+ ", empId=" + empId + "]";
	}
}
