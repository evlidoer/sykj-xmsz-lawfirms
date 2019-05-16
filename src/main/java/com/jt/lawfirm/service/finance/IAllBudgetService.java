package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;

public interface IAllBudgetService {
	
	List<Map<String, String>> findAllBudgetOfSive(PageBean pb ,Map<String, String> map);
	
	List<Map<String, String>> findAllBudgetOfExport(Map<String, String> map);
	
	boolean removeInoutById(int id);
	
}
