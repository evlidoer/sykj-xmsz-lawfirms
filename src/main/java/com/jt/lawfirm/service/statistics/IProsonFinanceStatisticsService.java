package com.jt.lawfirm.service.statistics;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;

public interface IProsonFinanceStatisticsService {
	
	List<Inout> findIncomeOfSive(MyStatisticsOfSive my);
	
	List<Map<String, String>> findReservedOfSive(MyStatisticsOfSive my);
	
	List<Map<String, String>> findCommission(MyStatisticsOfSive my);
	
	List<Map<String, Object>> findIncomeOfSives(MyStatisticsOfSive my);
	
	List<Map<String, String>> findHistoryAndEmp(PageBean pb,Integer id);
	
	boolean addHistory(Map<String, String> map);
	
	boolean removeHistory(Integer id);
	
}
