package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;

public interface IKpListService {
	
	List<Map<String, String>> findInvoiceOfSiveAll(PageBean pb, Map<String, String> map);
	
	List<Map<String, String>> findInvoiceOfSiveAllExprot(Map<String, String> map);
	
	boolean removeInvoiceOfId(int id);
	
}
