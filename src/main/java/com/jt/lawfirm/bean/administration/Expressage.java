package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "adm_expressage")
public class Expressage {
	private int id;
	private String systemUserAddresser;//发件人
	private String systemUserRecipients;//收件人
	private String expressageSendaunit;//发件单位
	private String expressageAddressee;//收件单位
	private String expressageSendadate;//发件日期
	private String expressageDateofreceipt;//收件日期
	private String expressageBringDate;//领件日期
	private String expressageCourierServicesCompany;//快递公司 
	private int expressageSendWaay;//发件方式 (1,快递     2,人工派送   3,上门取货)
	private String expressageExpressType;//快件类型
	private int expressageCourierNumber;//快件单号
	private String expressageRelevantdocument;//相关文件
	private String expressageCollarnote;//领件说明
	private String expressageRemark;//备注说明
	private String expressageStatus;//
	
	public Expressage() {
	}

	public Expressage(int id, String systemUserAddresser, String systemUserRecipients, String expressageSendaunit,
			String expressageAddressee, String expressageSendadate, String expressageDateofreceipt,
			String expressageBringDate, String expressageCourierServicesCompany, int expressageSendWaay,
			String expressageExpressType, int expressageCourierNumber, String expressageRelevantdocument,
			String expressageCollarnote, String expressageRemark, String expressageStatus) {
		super();
		this.id = id;
		this.systemUserAddresser = systemUserAddresser;
		this.systemUserRecipients = systemUserRecipients;
		this.expressageSendaunit = expressageSendaunit;
		this.expressageAddressee = expressageAddressee;
		this.expressageSendadate = expressageSendadate;
		this.expressageDateofreceipt = expressageDateofreceipt;
		this.expressageBringDate = expressageBringDate;
		this.expressageCourierServicesCompany = expressageCourierServicesCompany;
		this.expressageSendWaay = expressageSendWaay;
		this.expressageExpressType = expressageExpressType;
		this.expressageCourierNumber = expressageCourierNumber;
		this.expressageRelevantdocument = expressageRelevantdocument;
		this.expressageCollarnote = expressageCollarnote;
		this.expressageRemark = expressageRemark;
		this.expressageStatus = expressageStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSystemUserAddresser() {
		return systemUserAddresser;
	}

	public void setSystemUserAddresser(String systemUserAddresser) {
		this.systemUserAddresser = systemUserAddresser;
	}

	public String getSystemUserRecipients() {
		return systemUserRecipients;
	}

	public void setSystemUserRecipients(String systemUserRecipients) {
		this.systemUserRecipients = systemUserRecipients;
	}

	public String getExpressageSendaunit() {
		return expressageSendaunit;
	}

	public void setExpressageSendaunit(String expressageSendaunit) {
		this.expressageSendaunit = expressageSendaunit;
	}

	public String getExpressageAddressee() {
		return expressageAddressee;
	}

	public void setExpressageAddressee(String expressageAddressee) {
		this.expressageAddressee = expressageAddressee;
	}

	public String getExpressageSendadate() {
		return expressageSendadate;
	}

	public void setExpressageSendadate(String expressageSendadate) {
		this.expressageSendadate = expressageSendadate;
	}

	public String getExpressageDateofreceipt() {
		return expressageDateofreceipt;
	}

	public void setExpressageDateofreceipt(String expressageDateofreceipt) {
		this.expressageDateofreceipt = expressageDateofreceipt;
	}

	public String getExpressageBringDate() {
		return expressageBringDate;
	}

	public void setExpressageBringDate(String expressageBringDate) {
		this.expressageBringDate = expressageBringDate;
	}

	public String getExpressageCourierServicesCompany() {
		return expressageCourierServicesCompany;
	}

	public void setExpressageCourierServicesCompany(String expressageCourierServicesCompany) {
		this.expressageCourierServicesCompany = expressageCourierServicesCompany;
	}

	public int getExpressageSendWaay() {
		return expressageSendWaay;
	}

	public void setExpressageSendWaay(int expressageSendWaay) {
		this.expressageSendWaay = expressageSendWaay;
	}

	public String getExpressageExpressType() {
		return expressageExpressType;
	}

	public void setExpressageExpressType(String expressageExpressType) {
		this.expressageExpressType = expressageExpressType;
	}

	public int getExpressageCourierNumber() {
		return expressageCourierNumber;
	}

	public void setExpressageCourierNumber(int expressageCourierNumber) {
		this.expressageCourierNumber = expressageCourierNumber;
	}

	public String getExpressageRelevantdocument() {
		return expressageRelevantdocument;
	}

	public void setExpressageRelevantdocument(String expressageRelevantdocument) {
		this.expressageRelevantdocument = expressageRelevantdocument;
	}

	public String getExpressageCollarnote() {
		return expressageCollarnote;
	}

	public void setExpressageCollarnote(String expressageCollarnote) {
		this.expressageCollarnote = expressageCollarnote;
	}

	public String getExpressageRemark() {
		return expressageRemark;
	}

	public void setExpressageRemark(String expressageRemark) {
		this.expressageRemark = expressageRemark;
	}

	public String getExpressageStatus() {
		return expressageStatus;
	}

	public void setExpressageStatus(String expressageStatus) {
		this.expressageStatus = expressageStatus;
	}

	@Override
	public String toString() {
		return "Expressage [id=" + id + ", systemUserAddresser=" + systemUserAddresser + ", systemUserRecipients="
				+ systemUserRecipients + ", expressageSendaunit=" + expressageSendaunit + ", expressageAddressee="
				+ expressageAddressee + ", expressageSendadate=" + expressageSendadate + ", expressageDateofreceipt="
				+ expressageDateofreceipt + ", expressageBringDate=" + expressageBringDate
				+ ", expressageCourierServicesCompany=" + expressageCourierServicesCompany + ", expressageSendWaay="
				+ expressageSendWaay + ", expressageExpressType=" + expressageExpressType + ", expressageCourierNumber="
				+ expressageCourierNumber + ", expressageRelevantdocument=" + expressageRelevantdocument
				+ ", expressageCollarnote=" + expressageCollarnote + ", expressageRemark=" + expressageRemark
				+ ", expressageStatus=" + expressageStatus + "]";
	}
}
