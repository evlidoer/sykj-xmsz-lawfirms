package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.InoutType;

public interface ICaseBudgetEntryService {
	
	List<Map<String, String>> findLawOfSive(PageBean pb, Map<String, String> map);
	
	List<InoutType> findInoutTypeIncome();
	
	boolean addInoutOfSive(Map<String, String> map);
}
