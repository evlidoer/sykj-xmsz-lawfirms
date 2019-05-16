package com.jt.lawfirm.service.anjian.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.mapper.anjian.CaseMapper;
import com.jt.lawfirm.mapper.anjian.YongYinMapper;
import com.jt.lawfirm.service.anjian.YongYinService;

@Service("YongyinServiceImpl")
public class YongYinServiceImpl implements YongYinService {
	
	@Resource
	private CaseMapper caseMapper;
	@Resource
	private YongYinMapper yongyinMapper;
	@Override
	public boolean addCaseSealApplyfor(CaseSealApplyfor cs) {
		return caseMapper.addCaseSealApplyfor(cs);
	}
	//删除
	@Override
	public boolean delCaseSealApplyfor(Integer id) {
		return yongyinMapper.delCaseSealApplyfor(id);
	}

}
