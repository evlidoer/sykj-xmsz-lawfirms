package com.jt.lawfirm.service.log.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.mapper.log.MylogMapper;
import com.jt.lawfirm.service.log.MylogService;


@Service
public class MylogServiceImpl implements MylogService{
	@Autowired
	private MylogMapper mylogMapper;

	//查询全部
	@Override
	public List<HashMap<String, Object>> queryAll(Map<String, Object> map) {
		return mylogMapper.queryAll(map);
	}

	//查看
	@Override
	public List<Map<String, Object>> selInfoById(Integer id)  {
		return mylogMapper.selInfoById(id);
	} 
	
	
	//删除
	@Override
	public void remove_logshowById(int id) {
		mylogMapper.dellogshow(id);
	}

	@Override
	public List<Map<String, Object>>  log_typeSel() {
		return mylogMapper.log_typeSel();
	}
	
	//修改
	@Override
	public boolean uplog(Job job) {
		return mylogMapper.uplog(job);
	}

	
}
