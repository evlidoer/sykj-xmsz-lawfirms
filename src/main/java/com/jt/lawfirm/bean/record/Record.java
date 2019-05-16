package com.jt.lawfirm.bean.record;

public class Record {
	private int id;
	private int  lawCaseId;
	private int  recordArchivedFile ;
	
	public Record(int lawCaseId, int recordArchivedFile) {
		this.lawCaseId = lawCaseId;
		this.recordArchivedFile = recordArchivedFile;
	}
	/**
	 * 外键
	 */
	
	private com.jt.lawfirm.bean.casea.Law law;
	private com.jt.lawfirm.bean.record.RecordFile recordFile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLawCaseId() {
		return lawCaseId;
	}
	public void setLawCaseId(int lawCaseId) {
		this.lawCaseId = lawCaseId;
	}
	public int getRecordArchivedFile() {
		return recordArchivedFile;
	}
	public void setRecordArchivedFile(int recordArchivedFile) {
		this.recordArchivedFile = recordArchivedFile;
	}
	public com.jt.lawfirm.bean.casea.Law getLaw() {
		return law;
	}
	public void setLaw(com.jt.lawfirm.bean.casea.Law law) {
		this.law = law;
	}
	public com.jt.lawfirm.bean.record.RecordFile getRecordFile() {
		return recordFile;
	}
	public void setRecordFile(com.jt.lawfirm.bean.record.RecordFile recordFile) {
		this.recordFile = recordFile;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", lawCaseId=" + lawCaseId + ", recordArchivedFile=" + recordArchivedFile + ", law="
				+ law + ", recordFile=" + recordFile + "]";
	}
	public Record() {
		// TODO Auto-generated constructor stub
	}
}
