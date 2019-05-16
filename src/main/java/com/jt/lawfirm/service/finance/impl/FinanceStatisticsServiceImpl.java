package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.mapper.statistics.IInoutAndTypeMapper;
import com.jt.lawfirm.service.finance.IFinanceStatisticsService;

@Service("financeStatisticsService")
public class FinanceStatisticsServiceImpl implements IFinanceStatisticsService {
	
	@Resource(name="IInoutAndTypeMapper")
	private IInoutAndTypeMapper iAndtMapper;

	@Override
	public List<Map<String, String>> findFinanceStatistics(MyIncomeOfSive myOfSive) {
		return iAndtMapper.selectFinanceStatistics(myOfSive);
	}

}
