package com.jt.lawfirm.service.statistics;

import java.util.List;
import java.util.Map;

public interface IStatisticalCenterService {
	
	List<Map<String, String>> findSiveToMap(Map<String, String> map);
	
	List<Map<String, String>> findSiveToMapPlus(Map<String, String> map);
	
	List<Map<String, String>> findPersonalBusiness(Map<String, String> map);
	
	List<Map<String, String>> findReceiveStatistical(Map<String, String> map);
	
	List<Map<String, String>> findClassInvoice(Map<String, String> map);
	
}
