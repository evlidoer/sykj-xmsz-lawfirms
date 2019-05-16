package com.jt.lawfirm.mapper.finance.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.record.RecordFile;

public class FinanceFileSqlProvider {
	
	public String insertFileOfInvoice(RecordFile rf) {
		return new SQL() {
			{
				INSERT_INTO("record_file");
				if(!rf.getFileName().equals("") && rf.getFileName() != null)
					VALUES("file_name","'" + rf.getFileName() + "'");
				if(!rf.getFilePath().equals("") && rf.getFilePath() != null)
					VALUES("file_path","#{filePath}");
				if(!rf.getFileUploadDate().equals("") && rf.getFileUploadDate() != null) 
					VALUES("file_upload_date","'" + rf.getFileUploadDate() + "'");
				if(!rf.getFileUploadPerson().equals("") && rf.getFileUploadPerson() != null)
					VALUES("file_upload_person","'" + rf.getFileUploadPerson() + "'");
			}
		}.toString();
	}
	
}
