package com.jt.lawfirm.service.statistics;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;

public interface IUsingStatisticsService {
	
	List<Map<String, String>> findApplyforOfSive(PageBean pb, Map<String, String> map);
	
	List<Map<String, String>> findApplyforOfSiveOnExprot(Map<String, String> map);
	
}
