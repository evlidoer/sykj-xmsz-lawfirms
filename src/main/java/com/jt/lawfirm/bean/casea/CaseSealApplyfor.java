package com.jt.lawfirm.bean.casea;

import com.jt.lawfirm.bean.record.RecordFile;

//--文书表
public class CaseSealApplyfor {
	private int id ;
	private String sanum;  //#函号
	private int case_law_id;//-- 案件外键
	private String applyforRecipient;// -- 领用人
	private String applyforReceive;//  #领用日期
	private String applyforUsingTheItem ;//  -- 用印事项律师函
	private String applyforApprovalStatus ;//  #审批状态
	private int fileId;//文件表 外键
	private RecordFile file;
	private Law law;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSanum() {
		return sanum;
	}
	public void setSanum(String sanum) {
		this.sanum = sanum;
	}
	public int getCase_law_id() {
		return case_law_id;
	}
	public void setCase_law_id(int case_law_id) {
		this.case_law_id = case_law_id;
	}
	public String getApplyforRecipient() {
		return applyforRecipient;
	}
	public void setApplyforRecipient(String applyforRecipient) {
		this.applyforRecipient = applyforRecipient;
	}
	public String getApplyforReceive() {
		return applyforReceive;
	}
	public void setApplyforReceive(String applyforReceive) {
		this.applyforReceive = applyforReceive;
	}
	public String getApplyforUsingTheItem() {
		return applyforUsingTheItem;
	}
	public void setApplyforUsingTheItem(String applyforUsingTheItem) {
		this.applyforUsingTheItem = applyforUsingTheItem;
	}
	public String getApplyforApprovalStatus() {
		return applyforApprovalStatus;
	}
	public void setApplyforApprovalStatus(String applyforApprovalStatus) {
		this.applyforApprovalStatus = applyforApprovalStatus;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public RecordFile getFile() {
		return file;
	}
	public void setFile(RecordFile file) {
		this.file = file;
	}
	public Law getLaw() {
		return law;
	}
	public void setLaw(Law law) {
		this.law = law;
	}
	public CaseSealApplyfor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CaseSealApplyfor [id=" + id + ", sanum=" + sanum + ", case_law_id=" + case_law_id
				+ ", applyforRecipient=" + applyforRecipient + ", applyforReceive=" + applyforReceive
				+ ", applyforUsingTheItem=" + applyforUsingTheItem + ", applyforApprovalStatus="
				+ applyforApprovalStatus + ", fileId=" + fileId + ", file=" + file + ", law=" + law + "]";
	}

}
