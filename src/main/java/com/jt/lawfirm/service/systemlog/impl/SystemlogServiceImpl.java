package com.jt.lawfirm.service.systemlog.impl;
import java.util.List;
import java.util.Map;

/**
 * @author 代
 * */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.system.Log;
import com.jt.lawfirm.bean.system.mysystembean.MySysTemSelect;
import com.jt.lawfirm.mapper.login.LoginMapper;
import com.jt.lawfirm.mapper.systemlog.ISystemlogMapper;
import com.jt.lawfirm.service.systemlog.ISystemlogService;

@Service("systemlogservice")
public class SystemlogServiceImpl implements ISystemlogService {
	
	@Resource(name="ISystemlogMapper")
	private ISystemlogMapper systemlogMapper;
	@Resource
	private LoginMapper loginMapper;
	
	
	@Override
	public List<Log> selectlog(PageBean pageBean, MySysTemSelect sysTemSelect) {
		Page<Object> page = PageHelper.offsetPage(pageBean.getOffset(), pageBean.getLimit());
		List<Log> selectsyslog = systemlogMapper.selectsyslog(sysTemSelect);
		pageBean.setTotal(page.getTotal());
		pageBean.setRows(selectsyslog);
		return selectsyslog;
	}

	@Override
	public boolean insertlog(Log log) {
		return systemlogMapper.insertlog(log);
	}

	@Override
	public Map<String, Object> selectuserid(String username) {
		return loginMapper.selUserByName(username);
	}

	
}
