package com.jt.lawfirm.bean.client;

import java.util.Date;

//dto,client 添加字段 冬哥
public class AddclientBean {
	private Integer id;//客户id
	private String client;//客户
	private String tel;//电话
	private String clientType;//客户类型
	private Integer clientTypeId;//客户类型
	private String idnumber;//证件号
	private String type;//类型
	private String companyNature;//公司性质
	private String companyScale;//公司规模
	private String industry;//产业
	private String idtype;//身份特点
	private String clientPrincipal;//主要负责人
	private String clientContacts;//业务联系人
	private String clientEmail;//邮箱
	private String clientDuty;//职务
	private String clientInfluence;//地区影响力
	private String clientPhone;//固定电话
	private String clientRegion;//所属地区
	private String clientStuatus;//客户状态
	private String clientBehalf;//法定代表人
	private String clientLegalphone;//法人联系方式
	private String clientFile;//相关文件
	private String clientIdcard;//身份证
	private String clientNation;//民族
	private String clientSex;//性别
	private String clientSite;//详细
	private String clientBirth;//出生日期
	private String clientRemark;//备注
	private Date clientAddtime;//入库时间
	private Integer empId;//律师
	private Integer lawnum;//案件数量
	
	public Integer getLawnum() {
		return lawnum;
	}
	public void setLawnum(Integer lawnum) {
		this.lawnum = lawnum;
	}
	public Date getClientAddtime() {
		return clientAddtime;
	}
	public void setClientAddtime(Date clientAddtime) {
		this.clientAddtime = clientAddtime;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getClient() {
		return client;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public Integer getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompanyNature() {
		return companyNature;
	}
	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
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
	public String getClientNation() {
		return clientNation;
	}
	public void setClientNation(String clientNation) {
		this.clientNation = clientNation;
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
	public String getClientBirth() {
		return clientBirth;
	}
	public void setClientBirth(String clientBirth) {
		this.clientBirth = clientBirth;
	}
	public String getClientRemark() {
		return clientRemark;
	}
	public void setClientRemark(String clientRemark) {
		this.clientRemark = clientRemark;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public AddclientBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AddclientBean [id=" + id + ", client=" + client + ", tel=" + tel + ", clientType=" + clientType
				+ ", clientTypeId=" + clientTypeId + ", idnumber=" + idnumber + ", type=" + type + ", companyNature="
				+ companyNature + ", companyScale=" + companyScale + ", industry=" + industry + ", idtype=" + idtype
				+ ", clientPrincipal=" + clientPrincipal + ", clientContacts=" + clientContacts + ", clientEmail="
				+ clientEmail + ", clientDuty=" + clientDuty + ", clientInfluence=" + clientInfluence + ", clientPhone="
				+ clientPhone + ", clientRegion=" + clientRegion + ", clientStuatus=" + clientStuatus
				+ ", clientBehalf=" + clientBehalf + ", clientLegalphone=" + clientLegalphone + ", clientFile="
				+ clientFile + ", clientIdcard=" + clientIdcard + ", clientNation=" + clientNation + ", clientSex="
				+ clientSex + ", clientSite=" + clientSite + ", clientBirth=" + clientBirth + ", clientRemark="
				+ clientRemark + ", clientAddtime=" + clientAddtime + ", empId=" + empId + "]";
	}

	
}
