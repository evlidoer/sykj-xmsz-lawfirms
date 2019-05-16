package com.jt.lawfirm.service.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.log.Job;

public interface IAllLogService{
	public List<HashMap<String ,Object>> queryAll(Map<String,Object>map);	
	
	public Map<String, Object> selInfoById(int id);


}
