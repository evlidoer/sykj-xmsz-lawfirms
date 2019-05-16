package com.jt.lawfirm.service.anjian.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.anjian.FeiyongMapper;
import com.jt.lawfirm.service.anjian.FeiyongService;

@Service("feiyongService")
public class FeiyongServiceImpl implements FeiyongService {
	
	@Resource
	private FeiyongMapper feiyongMapper;
	
	
	//案件费用减免记录  biao
	@Override
	public List<Map<String, Object>> feiyongShow(Map<String, Object> map) {
		return feiyongMapper.feiyongShow(map);
	}


	@Override
	public boolean delfeiyong(Integer id) {
		return feiyongMapper.delfeiyong(id);
	}
	
	
	
}
