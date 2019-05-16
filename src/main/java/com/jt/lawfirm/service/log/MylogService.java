package com.jt.lawfirm.service.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.log.Job;

public interface MylogService {
	//查询所有
	public List<HashMap<String, Object>> queryAll(Map<String, Object> map);

	//查看
	public List<Map<String, Object>> selInfoById(Integer id);
	
	//修改
	public boolean uplog(Job job);
	
	//删除
	void remove_logshowById(int id);

	public List<Map<String, Object>>  log_typeSel();

	

}
