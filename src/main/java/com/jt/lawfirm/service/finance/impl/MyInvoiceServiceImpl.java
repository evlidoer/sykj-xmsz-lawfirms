package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyInvoice;
import com.jt.lawfirm.mapper.finance.IInvoiceMapper;
import com.jt.lawfirm.service.finance.IMyInvoiceService;
import com.jt.lawfirm.util.DateTime;

@Service("invoiceService")
public class MyInvoiceServiceImpl implements IMyInvoiceService {
	
	@Resource(name = "IInvoiceMapper")
	private IInvoiceMapper invoiceMapper;

	@Override
	public List<Map<String, String>> findInvoiceofSive(PageBean pb, MyInvoice invoice) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = invoiceMapper.selectInvoiceofSive(DateTime.exchangeDate(invoice, "startTime", "endTime"));
		System.err.println(list);
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return list;
	}

}
