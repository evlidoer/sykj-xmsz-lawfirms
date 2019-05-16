package com.jt.lawfirm.service.assess.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.assess.IDataReportMapper;
import com.jt.lawfirm.service.assess.IDataReportService;
@Service
public class DataReportServiceImpl implements IDataReportService {
	@Autowired
	private IDataReportMapper dataReportMapper;

	@Override
	public List<Map<String, Object>> FindAll(Map<String, Object> finMap) {
		PageBean pb = (PageBean) finMap.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String,Object>> selectAll = dataReportMapper.SelectAll(finMap);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : selectAll) {
			Date date = Date.valueOf(map2.get("case_subtime").toString());
			map2.put("case_subtime",simp.format(date));
		}
		
		pb.setTotal(pg.getTotal());
		
		pb.setRows(selectAll);
		return null;
	}
	
}
