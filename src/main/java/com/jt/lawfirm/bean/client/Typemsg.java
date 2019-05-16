package com.jt.lawfirm.bean.client;

public class Typemsg {
	private Integer id;
	private Integer clientId;
	private Integer clientTypeId;
	private String idtype;
	private String idnumber;
	private String companyNature;
	private String companyScale;
	private String Type;
	private String industry;
	private Ctype ctype;
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
	public Integer getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Ctype getCtype() {
		return ctype;
	}
	public void setCtype(Ctype ctype) {
		this.ctype = ctype;
	}
	@Override
	public String toString() {
		return "Typemsg [id=" + id + ", clientId=" + clientId + ", clientTypeId=" + clientTypeId + ", idtype=" + idtype
				+ ", idnumber=" + idnumber + ", companyNature=" + companyNature + ", companyScale=" + companyScale
				+ ", Type=" + Type + ", industry=" + industry + ", ctype=" + ctype + "]";
	}
}
