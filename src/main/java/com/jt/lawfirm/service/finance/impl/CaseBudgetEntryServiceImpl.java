package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.InoutType;
import com.jt.lawfirm.mapper.finance.IFinanceEmpMapper;
import com.jt.lawfirm.mapper.finance.IFinanceLawMapper;
import com.jt.lawfirm.mapper.finance.IInoutMapper;
import com.jt.lawfirm.mapper.finance.IInoutTypeMapper;
import com.jt.lawfirm.service.finance.ICaseBudgetEntryService;

@Service("cbeService")
public class CaseBudgetEntryServiceImpl implements ICaseBudgetEntryService {
	
	@Resource(name="IFinanceLawMapper")
	private IFinanceLawMapper lawMapper;
	@Resource(name="IInoutTypeMapper")
	private IInoutTypeMapper inoutTypeMapper;
	@Resource(name="IInoutMapper")
	private IInoutMapper inoutMapper;
	@Resource(name="IFinanceEmpMapper")
	private IFinanceEmpMapper empMapper;
	
	
	@Override
	public List<Map<String, String>> findLawOfSive(PageBean pb, Map<String, String> map) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = lawMapper.selectLawOfSive(map);
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return list;
	}

	@Override
	public List<InoutType> findInoutTypeIncome() {
		QueryWrapper<InoutType> wrapper = new QueryWrapper<InoutType>();
		wrapper.eq("id", "1001").or().eq("cw_pid", "1001");
		return inoutTypeMapper.selectList(wrapper);
	}

	@Override
	public boolean addInoutOfSive(Map<String, String> map) {
		map.put("id", empMapper.selectNameByCaseId(map.get("lawId")));
		return inoutMapper.insertInout(map);
	}
	
	
	
}
