package com.jt.lawfirm.service.anjian.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.anjian.ManageCaseMapper;
import com.jt.lawfirm.service.anjian.ManageCaseService;

@Service("ManageCaseServiceImpl")
public class ManageCaseServiceImpl implements ManageCaseService{
	@Resource
	private ManageCaseMapper manageCaseMapper;
	
	@Override
	public Integer upAnjianHao(Map<String, Object> map) {
		return manageCaseMapper.upAnjianHao(map);
	}
	//判断案号重复
	@Override
	public String selCasePropernum(String CasePropernum) {
		return manageCaseMapper.selCasePropernum(CasePropernum);
	}
	//设置档案号
	@Override
	public Integer setCaseFilenumber(Map<String, Object> map) {
		return manageCaseMapper.setCaseFilenumber(map);
	}
	
	
	@Override
	public Integer addLawHistroy_DelLaw(String id) {
		Integer addLawHistroy= manageCaseMapper.addLawHistroy(id);
		Integer DelLaw = manageCaseMapper.DelLaw(id);
		return addLawHistroy;
	}
	
	//回收
	@Override
	public List<Map<String, Object>> lawHistroy(String title) {
		return manageCaseMapper.lawHistroy(title);
	}
}
