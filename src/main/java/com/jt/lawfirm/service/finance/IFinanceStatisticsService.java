package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;

public interface IFinanceStatisticsService {
	
	List<Map<String, String>> findFinanceStatistics(MyIncomeOfSive myOfSive);
	
}
