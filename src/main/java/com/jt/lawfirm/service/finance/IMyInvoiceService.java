package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyInvoice;

public interface IMyInvoiceService {
	
	List<Map<String, String>> findInvoiceofSive(PageBean pb, MyInvoice invoice);
	
}
