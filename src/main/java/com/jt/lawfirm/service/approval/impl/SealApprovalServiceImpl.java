package com.jt.lawfirm.service.approval.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.casea.CaseApproval;
import com.jt.lawfirm.mapper.approval.ISealApprovalMapper;
import com.jt.lawfirm.service.approval.ISealApprovalService;

@Service
public class SealApprovalServiceImpl implements ISealApprovalService{
	@Autowired
	private ISealApprovalMapper sealApprovalmapper;

	@Override
	public List<Map<String, Object>> SelectAll(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String,Object>> SelectAll = sealApprovalmapper.FindAll(map);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : SelectAll) {
			Date date = Date.valueOf(map2.get("applyfor_receive").toString()) ;
			map2.put("applyfor_receive",simp.format(date));
		}
		
		System.out.println(SelectAll);
		pb.setTotal(pg.getTotal());
		pb.setRows(SelectAll);
		return SelectAll;
	}

	@Override
	public List<Map<String, Object>> SelectSeal(Integer id) {
		List<Map<String, Object>> seal = sealApprovalmapper.FindSeal(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : seal) {
			Date date = Date.valueOf(map2.get("applyfor_receive").toString()) ;
			map2.put("applyfor_receive",simp.format(date));
		}
		return seal;
	}

	@Override
	public List<Map<String, Object>> SelectLawById(Integer id) {
		List<Map<String, Object>> LawList =  sealApprovalmapper.FindLawById(id);
		return LawList;
	}

	@Override
	public List<Map<String, Object>> selectSealLawById(Integer id) {
		List<Map<String, Object>> Seal = sealApprovalmapper.FindSealLawById(id);
		return Seal;
	}

	@Override
	public List<Map<String, Object>> SelectEmp(Integer id) {
		List<Map<String, Object>> Selectemp = sealApprovalmapper.FindEmpById(id);
		return Selectemp;
	}

	@Override
	public int insertApprove_updateApprove(CaseApproval lawApproval) {
		int num =  sealApprovalmapper.AddApprove(lawApproval);
				   sealApprovalmapper.modifyLaw(lawApproval);
		return num;
	}

	@Override
	public int recordnum(Integer id) {
		int count =  sealApprovalmapper.recordnumber(id);
		return count;
	}

	@Override
	public int updatecaseseal(Map<String, Object> map) {
	 int  update =	sealApprovalmapper.modifSeal(map);
		return update;
	}

	@Override
	public List<Map<String, Object>> SelectSealFileById(Integer id) {
	List<Map<String,Object>> listmap =	sealApprovalmapper.FindSealFileById(id);

		return listmap;
	}

	
}
