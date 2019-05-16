package com.jt.lawfirm.service.statistics.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.statistics.ICaseSealApplyforMapper;
import com.jt.lawfirm.service.statistics.IUsingStatisticsService;
import com.jt.lawfirm.util.DateTime;

@Service("usingStatisticsService")
public class UsingStatisticsServiceImpl implements IUsingStatisticsService {
	
	@Resource(name="ICaseSealApplyforMapper")
	private ICaseSealApplyforMapper applyforMapper;

	@Override
	public List<Map<String, String>> findApplyforOfSive(PageBean pb, Map<String, String> map) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		System.err.println(map);
		List<Map<String, String>> list = applyforMapper.selectApplyforOfSive(DateTime.exchangeDate(map, "startTime", "endTime"));
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return null;
	}

	@Override
	public List<Map<String, String>> findApplyforOfSiveOnExprot(Map<String, String> map) {
		return applyforMapper.selectApplyforOfSive(DateTime.exchangeDate(map, "startTime", "endTime"));
	}

}
