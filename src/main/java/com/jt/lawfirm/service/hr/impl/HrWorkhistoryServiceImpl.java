package com.jt.lawfirm.service.hr.impl;
/*
 * 
 * @author代国繁
 * */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.hr.HrWorkhistory;
import com.jt.lawfirm.mapper.hr.IHrWorkhistoryMapper;
import com.jt.lawfirm.service.hr.IHrWorkhistoryService;

@Service("workservice")
public class HrWorkhistoryServiceImpl implements IHrWorkhistoryService {
	
	@Resource(name="IHrWorkhistoryMapper")
	private IHrWorkhistoryMapper hrWorkhistoryMapper;

	@Override
	public List<HrWorkhistory> selectworkby(Map<String, Object> map) {
		return hrWorkhistoryMapper.selectByMap(map);
	}

	@Override
	public boolean updatework(HrWorkhistory hrWorkhistory) {
		return hrWorkhistoryMapper.updateById(hrWorkhistory)>0;
	}

	@Override
	public boolean deletework(int id) {
		return hrWorkhistoryMapper.deleteById(id)>0;
	}

	@Override
	public boolean insertwork(HrWorkhistory hrWorkhistory) {
		return hrWorkhistoryMapper.insert(hrWorkhistory)>0;
	}
}
