package com.jt.lawfirm.bean.record;

public class RecordFolder {
	 private int id;
	 private String folderName;
	public RecordFolder() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	@Override
	public String toString() {
		return "RecordFolder [id=" + id + ", folderName=" + folderName + "]";
	}
}
