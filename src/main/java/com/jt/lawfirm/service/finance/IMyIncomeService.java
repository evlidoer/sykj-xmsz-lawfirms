package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;

public interface IMyIncomeService {
	
	List<Inout> findIncomeOfSive(MyIncomeOfSive myIncome);
	
	List<Map<String, String>> findReservedOfSive(MyIncomeOfSive myIncome);
	
	List<Map<String, String>> findCommission(MyIncomeOfSive myIncome);
	
	List<Map<String, Object>> findIncomeOfSives(MyIncomeOfSive myIncome);
	
	List<Inout> findIncomeOfSivePlus(MyStatisticsOfSive my);

	List<Map<String, String>> findReservedOfSivePlus(MyStatisticsOfSive my);

	List<Map<String, String>> findCommissionPlus(MyStatisticsOfSive my);

	List<Map<String, Object>> findIncomeOfSivesPlus(MyStatisticsOfSive my);
	
}
