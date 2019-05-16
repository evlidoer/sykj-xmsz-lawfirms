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
import com.jt.lawfirm.mapper.approval.IApprovalMapper;
import com.jt.lawfirm.mapper.approval.IBuniApprovalMapper;
import com.jt.lawfirm.mapper.approval.ISealApprovalMapper;
import com.jt.lawfirm.service.approval.IApprovalService;
import com.jt.lawfirm.service.approval.IBuniApprovalService;
@Service
public class BuniApprovalServiceImpl implements IBuniApprovalService {
	
	@Autowired
	private IBuniApprovalMapper buniApprovalMapper;
	
	@Autowired
	private IApprovalMapper ApprovalMapper;
	
	@Override
	public List<Map<String, Object>> SelectBuni(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String, Object>>  listmap = buniApprovalMapper.FindBuni(map);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("relief_application_date").toString());
			map2.put("relief_application_date",simp.format(date));
		}
		pb.setTotal(pg.getTotal());
		pb.setRows(listmap);
		return listmap;
	}

	@Override
	public List<Map<String, Object>> SelectSettle(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String, Object>>  listmap = buniApprovalMapper.FindSettle(map);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("settletime").toString());
			map2.put("settletime",simp.format(date));
		}
		pb.setTotal(pg.getTotal());
		pb.setRows(listmap);
		return listmap;
	}

	@Override
	public List<Map<String, Object>> SelectRefund(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Map<String, Object>>  listmap = buniApprovalMapper.FindRefund(map);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("case_refundtime").toString());
			map2.put("case_refundtime",simp.format(date));
		}
		pb.setTotal(pg.getTotal());
		pb.setRows(listmap);
		return listmap;
	}

	@Override
	public List<Map<String, Object>> reliefSelById(Integer id) {
		List<Map<String, Object>> listmap =	buniApprovalMapper.FinreliefSelById(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("relief_application_date").toString());
			map2.put("relief_application_date",simp.format(date));
		}
		return listmap;
	}

	@Override
	public List<Map<String, Object>> SettleSelById(Integer id) {
		List<Map<String, Object>> listmap =	buniApprovalMapper.FindSettleById(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("settletime").toString());
			Date time = Date.valueOf(map2.get("settle_application_date").toString());
			map2.put("settle_application_date",simp.format(time));
			map2.put("settletime",simp.format(date));
		}
		return listmap;
	}

	@Override
	public List<Map<String, Object>> RefundSelById(Integer id) {
		List<Map<String, Object>> listmap =	buniApprovalMapper.FindRefundById(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("case_refundtime").toString());
			map2.put("case_refundtime",simp.format(date));
		}
		return listmap;
	}

	@Override
	public String record(Integer id) {
		String count =  buniApprovalMapper.record(id);
		return count;
	}

	@Override
	public String StatusSelsettle(int i, Integer settle_id) {
		String settlestatusSel = ApprovalMapper.settlestatusSel(i, settle_id);
		return settlestatusSel;
	}

	@Override
	public int userSelsettle(String username, Integer settle_id) {
			int usernamesettle = ApprovalMapper.usernamesettle(username, settle_id);
		return usernamesettle;
	}

	@Override
	public int approvalsettle(String applyfor_approval_status, Integer settle_id) {
		int approvalsettle = ApprovalMapper.approvalsettle(applyfor_approval_status, settle_id);
		return approvalsettle;
	}

	@Override
	public int Approvalsettleone(String applyfor_approval_status, int id, Integer settle_id) {
		int approvalsettleone = ApprovalMapper.approvalsettleone(applyfor_approval_status, id, settle_id);
		return approvalsettleone;
	}

	@Override
	public int Approvalsettletwo(String applyfor_approval_status, int id, Integer settle_id) {
		int approvalsettletwo = ApprovalMapper.approvalsettletwo(applyfor_approval_status, id, settle_id);
		return approvalsettletwo;
	}

	@Override
	public String StatusSelrelief(int i, Integer relief_id) {
		String reliefstatusSel = ApprovalMapper.reliefstatusSel(i, relief_id);
		return reliefstatusSel;
	}

	@Override
	public int userSelrelief(String username, Integer relief_id) {
		int usernamerelief = ApprovalMapper.usernamerelief(username, relief_id);
		return usernamerelief;
	}

	@Override
	public int approvalrelief(String applyfor_approval_status, Integer relief_id) {
		int approvalrelief = ApprovalMapper.approvalrelief(applyfor_approval_status, relief_id);
		return approvalrelief;
	}

	@Override
	public int Approvalreliefone(String applyfor_approval_status, int id, Integer relief_id) {
		int approvalreliefone = ApprovalMapper.approvalreliefone(applyfor_approval_status, id, relief_id);
		return approvalreliefone;
	}

	@Override
	public int Approvalrelieftwo(String applyfor_approval_status, int id, Integer relief_id) {
		int approvalrelieftwo = ApprovalMapper.approvalrelieftwo(applyfor_approval_status, id, relief_id);
		return approvalrelieftwo;
	}

	@Override
	public String StatusSelrefund(int i, Integer refund_id) {
		String refundstatusSel = ApprovalMapper.refundstatusSel(i, refund_id);
		return refundstatusSel;
	}

	@Override
	public int userSelrefund(String username, Integer refund_id) {
		int usernamerefund = ApprovalMapper.usernamerefund(username, refund_id);
		return usernamerefund;
	}

	@Override
	public int approvalrefund(String applyfor_approval_status, Integer refund_id) {
		int approvalrefund = ApprovalMapper.approvalrefund(applyfor_approval_status, refund_id);
		return approvalrefund;
	}

	@Override
	public int Approvalrefundone(String applyfor_approval_status, int id, Integer refund_id) {
		int approvalrefundone = ApprovalMapper.approvalrefundone(applyfor_approval_status, id, refund_id);
		return approvalrefundone;
	}

	@Override
	public int Approvalrefundtwo(String applyfor_approval_status, int id, Integer refund_id) {
		int approvalrefundtwo = ApprovalMapper.approvalrefundtwo(applyfor_approval_status, id, refund_id);
		return approvalrefundtwo;
	}

}
