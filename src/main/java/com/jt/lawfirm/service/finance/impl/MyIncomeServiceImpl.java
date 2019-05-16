package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;
import com.jt.lawfirm.mapper.finance.IInoutMapper;
import com.jt.lawfirm.service.finance.IMyIncomeService;
import com.jt.lawfirm.util.DateTime;

@Service("myIncomeService")
public class MyIncomeServiceImpl implements IMyIncomeService {
	
	@Resource(name="IInoutMapper")
	private IInoutMapper inoutMapper;

	@Override
	public List<Inout> findIncomeOfSive(MyIncomeOfSive myIncome) {
		System.err.println(myIncome);
		return inoutMapper.selectIncomeOfSive(DateTime.exchangeDate(myIncome, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, String>> findReservedOfSive(MyIncomeOfSive myIncome) {
		System.err.println(myIncome);
		return inoutMapper.selectReservedOfSive(DateTime.exchangeDate(myIncome, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, String>> findCommission(MyIncomeOfSive myIncome) {
		System.err.println(myIncome);
		return inoutMapper.selectCommission(DateTime.exchangeDate(myIncome, "startTime", "endTime"));
	}

	@Override
	public List<Map<String, Object>> findIncomeOfSives(MyIncomeOfSive myIncome) {
		System.err.println(myIncome);
		return inoutMapper.selectIncomeOfSives(DateTime.exchangeDate(myIncome, "startTime", "endTime"));
	}

	@Override
	public List<Inout> findIncomeOfSivePlus(MyStatisticsOfSive my) {
		System.err.println(my);
		return inoutMapper.selectIncomeOfSivePlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}
	
	@Override
	public List<Map<String, String>> findReservedOfSivePlus(MyStatisticsOfSive my) {
		System.err.println(my);
		return inoutMapper.selectReservedOfSivePlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}
	
	@Override
	public List<Map<String, String>> findCommissionPlus(MyStatisticsOfSive my) {
		System.err.println(my);
		return inoutMapper.selectCommissionPlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}
	
	@Override
	public List<Map<String, Object>> findIncomeOfSivesPlus(MyStatisticsOfSive my) {
		System.err.println(my);
		return inoutMapper.selectIncomeOfSivesPlus(DateTime.exchangeDate(my, "startTime", "endTime"));
	}
	
}
