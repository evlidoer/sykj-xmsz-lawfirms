package com.jt.lawfirm.service.anjian.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.anjian.ApproveMapper;
import com.jt.lawfirm.service.anjian.ApproveService;

@Service("ApproveServiceImpl")
public class ApproveServiceImpl implements ApproveService {
	
	@Resource
	private ApproveMapper approveMapper;
	@Override
	public List<Map<String, Object>> approveShow() {
		return approveMapper.approveShow();
    }

		
}
