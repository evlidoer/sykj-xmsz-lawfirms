package com.jt.lawfirm.service.finance;

import java.util.List;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.InoutType;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyBudget;

public interface IMyBudgetService {
	
	List<InoutType> findInoutTypeAll();
	
	List<CaseType> findCaseTypeAll();
	
	List<Inout> findInoutOfSive(PageBean page, MyBudget myBudget);
	
}
