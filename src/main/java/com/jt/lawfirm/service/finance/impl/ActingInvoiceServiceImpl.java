package com.jt.lawfirm.service.finance.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jt.lawfirm.bean.record.RecordFile;
import com.jt.lawfirm.exception.InsertErrorException;
import com.jt.lawfirm.mapper.finance.IFinanceFileMapper;
import com.jt.lawfirm.mapper.finance.IFinanceKdmanagerMapper;
import com.jt.lawfirm.mapper.finance.IInvoiceMapper;
import com.jt.lawfirm.service.finance.IActingInvoiceService;
import com.jt.lawfirm.util.AutoConversion;

@Service("actingInvoiceService")
public class ActingInvoiceServiceImpl implements IActingInvoiceService {
	
	@Resource(name="IInvoiceMapper")
	private IInvoiceMapper invoiceMapper;
	@Resource(name="IFinanceFileMapper")
	private IFinanceFileMapper fileMapper;
	@Resource(name="IFinanceKdmanagerMapper")
	private IFinanceKdmanagerMapper kdmanagerMapper;

	@Override
	public List<Map<String, String>> findInvoiceByIdOfNumber(int id) {
		return invoiceMapper.selectInvoiceByIdOfNumber(AutoConversion.conversionToMap("" + id));
	}
	
	@Override
	public boolean addCollectionAll(Map<String, String> map) {
		boolean bool = true;
		if(map.get("file_type") != null && map.get("file_name")  != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			RecordFile file = new RecordFile();
			file.setFileName(map.get("file_name"));
			file.setFilePath(map.get("file_type"));
			file.setFileUploadDate(sdf.format(new Date()));
			file.setFileUploadPerson("");
			if(fileMapper.insertFileOfInvoice(file)) bool = false;
			map.put("fileId", file.getId() + "");
		}
		if(!invoiceMapper.insertInvoiceAll(map)) bool = false;
		if(!bool) {
			try {
				throw new InsertErrorException("插入失败");
			}catch (Exception e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return bool;
	}
	
	@Override
	public List<Map<String, String>> findKdmanagerFAllByY() {
		return kdmanagerMapper.selectKdmanagerFAllByY();
	}

	@Override
	public List<Map<String, String>> findKdmanagerKdAllByY() {
		return kdmanagerMapper.selectKdmanagerKdAllByY();
	}
	
}
