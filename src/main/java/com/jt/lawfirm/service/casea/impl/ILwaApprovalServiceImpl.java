package com.jt.lawfirm.service.casea.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.casea.CaseLawtype;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.mapper.casea.ILwaApprovalMapper;
import com.jt.lawfirm.service.casea.ILwaApprovalService;

@Service
public class ILwaApprovalServiceImpl implements ILwaApprovalService {
	
	@Autowired
	private ILwaApprovalMapper approvalMapper;

	@Override
	public List<Map<String,Object>> FindAll(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String,Object>> selectAll = approvalMapper.SelectAll(map);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : selectAll) {
			Date date = Date.valueOf(map2.get("case_subtime").toString()) ;
			map2.put("case_subtime",simp.format(date));
		}
		
		pb.setTotal(pg.getTotal());
		
		pb.setRows(selectAll);
		return selectAll;
	}

	@Override
	public List<Map<String,Object>> FindById(Integer id) {
		List<Map<String,Object>> selectById = approvalMapper.SelectById(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : selectById) {
			Date date = Date.valueOf(map2.get("case_subtime").toString()) ;
			map2.put("case_subtime",simp.format(date));
		}
		return selectById;
	}

	@Override
	public int modiflaw(Law law) {
		int updatelaw = approvalMapper.updatelaw(law);
		return updatelaw;
	}

	@Override
	public List<CaseLawtype> FindType() {
		List<CaseLawtype> selectLawtype = approvalMapper.SelectLawtype();
		return selectLawtype;
	}
}
