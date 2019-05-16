package com.jt.lawfirm.service.statistics.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.mapper.finance.ICaseTypeMapper;
import com.jt.lawfirm.mapper.statistics.IStatistiscsLawMapper;
import com.jt.lawfirm.service.statistics.IShouJieAnStatisticsService;
import com.jt.lawfirm.util.DateTime;

@Service("sjaStatisticsService")
public class ShouJieAnStatisticsServiceImpl implements IShouJieAnStatisticsService {
	
	@Resource(name="ICaseTypeMapper")
	private ICaseTypeMapper caseTypeMapper;
	@Resource(name="IStatistiscsLawMapper")
	private IStatistiscsLawMapper lawMapper;
	
	@Override
	public List<CaseType> findInoutTypeAll() {
		return caseTypeMapper.selectList(null);
	}

	@Override
	public List<Map<String, String>> findLawAllOfSive(PageBean pb, Map<String, String> map) {
		Page<Object> page = PageHelper.startPage(pb.getOffset(), pb.getLimit());
		List<Map<String, String>> list = lawMapper.selectLawAll(DateTime.exchangeDate(map, "startTime", "endTime"));
		pb.setTotal(page.getTotal());
		pb.setRows(list);
		return null;
	}

	@Override
	public List<Map<String, String>> findLawAllOfSiveExport(Map<String, String> map) {
		return lawMapper.selectLawAll(DateTime.exchangeDate(map, "startTime", "endTime"));
	}

}
