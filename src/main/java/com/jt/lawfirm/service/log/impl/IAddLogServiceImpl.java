package com.jt.lawfirm.service.log.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.mapper.log.IAddLogMapper;
import com.jt.lawfirm.service.log.IAddLogService;

@Service
public class IAddLogServiceImpl implements IAddLogService {

	@Autowired 
	private IAddLogMapper addlogMapper;
	
	@Override
	public List<Job> queryAll(){
		return addlogMapper.queryAll();
	}

	@Override
	public int addlog(Job job) {
		int number =  addlogMapper.insert(job);
		return number;
	}
}
