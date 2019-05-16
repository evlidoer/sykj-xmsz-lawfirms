package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.finance.IAllInoutMapper;
import com.jt.lawfirm.service.finance.IAllBudgetService;

@Service("allBudgetService")
public class AllBudgetServiceImpl implements IAllBudgetService {
	
	@Resource(name="IAllInoutMapper")
	private IAllInoutMapper inoutMapper;

	@Override
	public List<Map<String, String>> findAllBudgetOfSive(PageBean pb ,Map<String, String> map) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = inoutMapper.selectAllBudgetOfSive(map);
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return list;
	}

	@Override
	public List<Map<String, String>> findAllBudgetOfExport(Map<String, String> map) {
		return inoutMapper.selectAllBudgetOfSive(map);
	}

	@Override
	public boolean removeInoutById(int id) {
		return inoutMapper.deleteById(id) > 0;
	}
	
}
