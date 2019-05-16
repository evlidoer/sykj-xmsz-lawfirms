package com.jt.lawfirm.bean.record;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.hr.HrEmp;

@TableName("record_archiveslibrary")
public class RecordArchiveslibrary {
	private int id;
	private int lawCaseid;//案件表外键
	private int recordId;//档案表外键
	private int systemUserId;//用户表外键
	private String  archiveslibraryBorrowdate;//借出时间
	private String archiveslibraryReturndate;//归还时间
	private String  archiveslibraryRemark;//备注说明
	private String archiveslibraryReturnStatus;
	
	
	private com.jt.lawfirm.bean.casea.Law law;//案件表
	private com.jt.lawfirm.bean.system.User user;//用户表
	private com.jt.lawfirm.bean.record.Record record;//档案表
	private HrEmp emp;
	
	public HrEmp getEmp() {
		return emp;
	}
	public void setEmp(HrEmp emp) {
		this.emp = emp;
	}
	public String getArchiveslibraryReturnStatus() {
		return archiveslibraryReturnStatus;
	}
	public void setArchiveslibraryReturnStatus(String archiveslibraryReturnStatus) {
		this.archiveslibraryReturnStatus = archiveslibraryReturnStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLawCaseid() {
		return lawCaseid;
	}
	public void setLawCaseid(int lawCaseid) {
		this.lawCaseid = lawCaseid;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getSystemUserId() {
		return systemUserId;
	}
	public void setSystemUserId(int systemUserId) {
		this.systemUserId = systemUserId;
	}
	public String getArchiveslibraryBorrowdate() {
		return archiveslibraryBorrowdate;
	}
	public void setArchiveslibraryBorrowdate(String archiveslibraryBorrowdate) {
		this.archiveslibraryBorrowdate = archiveslibraryBorrowdate;
	}
	public String getArchiveslibraryReturndate() {
		return archiveslibraryReturndate;
	}
	public void setArchiveslibraryReturndate(String archiveslibraryReturndate) {
		this.archiveslibraryReturndate = archiveslibraryReturndate;
	}
	public String getArchiveslibraryRemark() {
		return archiveslibraryRemark;
	}
	public void setArchiveslibraryRemark(String archiveslibraryRemark) {
		this.archiveslibraryRemark = archiveslibraryRemark;
	}
	public com.jt.lawfirm.bean.casea.Law getLaw() {
		return law;
	}
	public void setLaw(com.jt.lawfirm.bean.casea.Law law) {
		this.law = law;
	}
	public com.jt.lawfirm.bean.system.User getUser() {
		return user;
	}
	public void setUser(com.jt.lawfirm.bean.system.User user) {
		this.user = user;
	}
	public com.jt.lawfirm.bean.record.Record getRecord() {
		return record;
	}
	public void setRecord(com.jt.lawfirm.bean.record.Record record) {
		this.record = record;
	}
	public RecordArchiveslibrary() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RecordArchiveslibrary [id=" + id + ", lawCaseid=" + lawCaseid + ", recordId=" + recordId
				+ ", systemUserId=" + systemUserId + ", archiveslibraryBorrowdate=" + archiveslibraryBorrowdate
				+ ", archiveslibraryReturndate=" + archiveslibraryReturndate + ", archiveslibraryRemark="
				+ archiveslibraryRemark + ", archiveslibraryReturnStatus=" + archiveslibraryReturnStatus + ", law="
				+ law + ", user=" + user + ", record=" + record + ", emp=" + emp + "]";
	}
}
