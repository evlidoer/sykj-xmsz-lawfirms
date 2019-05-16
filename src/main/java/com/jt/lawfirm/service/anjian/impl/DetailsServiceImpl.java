package com.jt.lawfirm.service.anjian.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.anjian.DetailsMapper;
import com.jt.lawfirm.service.anjian.DetailsService;

@Service("DetailsServiceImpl")
public class DetailsServiceImpl implements DetailsService{
	@Resource
	private DetailsMapper detailsMapper;
	
	@Override
	public List<Map<String, Object>> findDetailsLaw(Map<String,Object> map) {
		return detailsMapper.findDetailsLaw(map);
	}
	
}
