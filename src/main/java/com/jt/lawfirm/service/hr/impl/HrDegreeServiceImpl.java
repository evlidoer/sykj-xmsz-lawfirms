package com.jt.lawfirm.service.hr.impl;
/*
 * 
 * @author代国繁
 * */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.hr.HrDegree;
import com.jt.lawfirm.mapper.hr.IHrDegreeMapper;
import com.jt.lawfirm.service.hr.IHrDegreeService;


@Service("degreeservice")
public class HrDegreeServiceImpl implements IHrDegreeService{
	
	@Resource(name="IHrDegreeMapper")
	private IHrDegreeMapper degreeMapper;


	@Override
	public List<HrDegree> selectdegreebyid(Map<String, Object> map) {
		return degreeMapper.selectdegreebyid(map);
	}
	
	@Override
	public boolean updatedegree(HrDegree degree) {
		return degreeMapper.updateById(degree) > 0;
	}

	@Override
	public boolean deletedegree(int id) {
		return degreeMapper.deleteById(id) > 0;
	}

	@Override
	public boolean adddegrree(HrDegree degree) {
		return degreeMapper.insert(degree)>0;
	}
}
