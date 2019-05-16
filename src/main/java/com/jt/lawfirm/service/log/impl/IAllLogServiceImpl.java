package com.jt.lawfirm.service.log.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.mapper.log.IAllLogMapper;
import com.jt.lawfirm.mapper.log.MylogMapper;
import com.jt.lawfirm.service.log.IAllLogService;

@Service
public class IAllLogServiceImpl implements IAllLogService{

	@Autowired
	private IAllLogMapper alllogMapper; 
	

	@Override
	public List<HashMap<String, Object>> queryAll(Map<String, Object> map) {
	
		return alllogMapper.queryAll(map);
	}
	
	@Override
	public Map<String, Object> selInfoById(int id)  {
		return alllogMapper.selInfoById(id);
	} 
}
