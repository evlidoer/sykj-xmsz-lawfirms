package com.jt.lawfirm.bean.record;


//文件表
public class RecordFile {
	 private int  id;
	 private String  fileName;//,#文件名称
	 private String  filePath;//#路径
	 private String  fileUploadDate;//#上传时间
	 private String  fileUploadPerson;//#上传人
	public RecordFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecordFile(int id, String fileName, String filePath, String fileUploadDate, String fileUploadPerson) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileUploadDate = fileUploadDate;
		this.fileUploadPerson = fileUploadPerson;
	}
	@Override
	public String toString() {
		return "RecordFile [id=" + id + ", fileName=" + fileName + ", filePath=" + filePath + ", fileUploadDate="
				+ fileUploadDate + ", fileUploadPerson=" + fileUploadPerson + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((fileUploadDate == null) ? 0 : fileUploadDate.hashCode());
		result = prime * result + ((fileUploadPerson == null) ? 0 : fileUploadPerson.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordFile other = (RecordFile) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileUploadDate == null) {
			if (other.fileUploadDate != null)
				return false;
		} else if (!fileUploadDate.equals(other.fileUploadDate))
			return false;
		if (fileUploadPerson == null) {
			if (other.fileUploadPerson != null)
				return false;
		} else if (!fileUploadPerson.equals(other.fileUploadPerson))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	public String getFileUploadPerson() {
		return fileUploadPerson;
	}
	public void setFileUploadPerson(String fileUploadPerson) {
		this.fileUploadPerson = fileUploadPerson;
	}
	
}
