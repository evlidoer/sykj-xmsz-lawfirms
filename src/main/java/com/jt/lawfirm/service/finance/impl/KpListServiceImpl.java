package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.finance.IInvoiceMapper;
import com.jt.lawfirm.service.finance.IKpListService;

@Service("kpListService")
public class KpListServiceImpl implements IKpListService {
	
	@Resource(name="IInvoiceMapper")
	private IInvoiceMapper invoiceMapper;
	
	@Override
	public List<Map<String, String>> findInvoiceOfSiveAll(PageBean pb, Map<String, String> map) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = invoiceMapper.selectInvoiceOfSiveAll(map);
		pb.setRows(list);
		pb.setTotal(page.getTotal());
		return null;
	}

	@Override
	public List<Map<String, String>> findInvoiceOfSiveAllExprot(Map<String, String> map) {
		return invoiceMapper.selectInvoiceOfSiveAllExprot(map);
	}

	@Override
	public boolean removeInvoiceOfId(int id) {
		return invoiceMapper.deleteById(id) > 0;
	}

}
