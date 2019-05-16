package com.jt.lawfirm.service.statistics.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;
import com.jt.lawfirm.mapper.finance.IInoutMapper;
import com.jt.lawfirm.mapper.statistics.IHistoryStatisticMapper;
import com.jt.lawfirm.service.statistics.IProsonFinanceStatisticsService;
import com.jt.lawfirm.util.DateTime;

@Service("prosonFinanceStatisticsService")
public class ProsonFinanceStatisticsServiceImpl implements IProsonFinanceStatisticsService {
	
	@Resource(name="IInoutMapper")
	private IInoutMapper inoutMapper;
	@Resource(name="IHistoryStatisticMapper")
	private IHistoryStatisticMapper hisMapper;

	@Override
	public List<Inout> findIncomeOfSive(MyStatisticsOfSive my) {
		return inoutMapper.selectIncomeOfSivePlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, String>> findReservedOfSive(MyStatisticsOfSive my) {
		return inoutMapper.selectReservedOfSivePlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, String>> findCommission(MyStatisticsOfSive my) {
		return inoutMapper.selectCommissionPlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, Object>> findIncomeOfSives(MyStatisticsOfSive my) {
		return inoutMapper.selectIncomeOfSivesPlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, String>> findHistoryAndEmp(PageBean pb,Integer id) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = hisMapper.selectHistoryAndEmp(id);
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return null;
	}

	@Override
	public boolean addHistory(Map<String, String> map) {
		return hisMapper.insertHistory(map);
	}

	@Override
	public boolean removeHistory(Integer id) {
		return hisMapper.deleteById(id) > 0;
	}
	
	
	
}
