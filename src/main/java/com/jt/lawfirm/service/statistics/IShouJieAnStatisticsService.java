package com.jt.lawfirm.service.statistics;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.CaseType;

public interface IShouJieAnStatisticsService {
	
	List<CaseType> findInoutTypeAll();
	
	List<Map<String, String>> findLawAllOfSive(PageBean pb, Map<String, String> map);

	List<Map<String, String>> findLawAllOfSiveExport(Map<String, String> map);
	
}
