package com.jt.lawfirm.service.finance.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.InoutType;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyBudget;
import com.jt.lawfirm.mapper.finance.ICaseTypeMapper;
import com.jt.lawfirm.mapper.finance.IInoutMapper;
import com.jt.lawfirm.mapper.finance.IInoutTypeMapper;
import com.jt.lawfirm.service.finance.IMyBudgetService;
import com.jt.lawfirm.util.DateTime;

@Service("myBudgetService")
public class MyBudgetServiceImpl implements IMyBudgetService {
	
	@Resource(name="IInoutTypeMapper")
	private IInoutTypeMapper inoutTypeMapper;
	@Resource(name="ICaseTypeMapper")
	private ICaseTypeMapper caseTypeMapper;
	@Resource(name="IInoutMapper")
	private IInoutMapper inoutMapper;
	
	@Override
	public List<InoutType> findInoutTypeAll() {
		return inoutTypeMapper.selectList(null);
	}

	@Override
	public List<CaseType> findCaseTypeAll() {
		return caseTypeMapper.selectList(null);
	}

	@Override
	public List<Inout> findInoutOfSive(PageBean page, MyBudget myBudget) {
		Page<Object> offsetPage = PageHelper.offsetPage(page.getOffset(), page.getLimit());
		List<Inout> list = inoutMapper.selectInoutOfSive(DateTime.exchangeDate(myBudget, "startTime", "endTime"));
		page.setTotal(offsetPage.getTotal());
		page.setRows(list);
		return list;
	}
	
}
