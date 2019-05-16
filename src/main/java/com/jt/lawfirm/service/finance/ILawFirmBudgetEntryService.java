package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.finance.InoutType;

public interface ILawFirmBudgetEntryService {
	
	List<Map<String, String>> findEmpToIdAndName(String name);
	
	List<InoutType> findInoutTypeAll();
	
	boolean addInoutOneRow(Map<String, String> map);
	
}
