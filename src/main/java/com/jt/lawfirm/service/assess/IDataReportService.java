package com.jt.lawfirm.service.assess;

import java.util.List;
import java.util.Map;

public interface IDataReportService {

	List<Map<String, Object>> FindAll(Map<String, Object> finMap);
	
}
