package com.jt.lawfirm.service.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.mapper.log.IAddLogMapper;

@Service
public interface IAddLogService {

	public List<Job> queryAll();

	public int addlog(Job job);

}
