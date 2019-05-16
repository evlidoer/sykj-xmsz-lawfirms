package com.jt.lawfirm.service.approval.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.approval.IApprovalMapper;
import com.jt.lawfirm.service.approval.IApprovalService;
@Service
public class IApprovalServiceimpl implements IApprovalService{
	
	@Autowired
	private IApprovalMapper approvalmapper;

	@Override
	public int userSel(String username,Integer lawId) {
		int id =  approvalmapper.username(username,lawId);
		return id;
	}

	@Override
	public int ApprovalLawone(String approvalStaus,Integer id, Integer law_id) {
		int update =  approvalmapper.approvallawone(approvalStaus,id,law_id);
		return update;
	}
	
	@Override
	public String StatusSel(int i, Integer lawId) {
		String status =  approvalmapper.statusSel(i,lawId);
		return status;
	}

	@Override
	public int ApprovalLawtwo(String approvalStaus,Integer id, Integer law_id) {
		int update  = approvalmapper.approvalLawtwo(approvalStaus,id,law_id);
		return update;
	}

	@Override
	public int approvallaw(String approvalStaus, Integer law_id) {
		int updatelaw = approvalmapper.approvallaw(approvalStaus,law_id);
		return updatelaw;
	}

	@Override
	public String StatusSelSeal(int i, Integer seal_id) {
		String sealstatusSel = approvalmapper.sealstatusSel(i, seal_id);
		return sealstatusSel;
	}

	@Override
	public int userSelSeal(String username, Integer seal_id) {
		int usernameseal = approvalmapper.usernameseal(username, seal_id);
		return usernameseal;
	}

	@Override
	public int approvalSeal(String applyfor_approval_status, Integer seal_id) {
		int approvalseal = approvalmapper.approvalseal(applyfor_approval_status, seal_id);
		return approvalseal;
	}

	@Override
	public int ApprovalSealone(String applyfor_approval_status, int id, Integer seal_id) {
		int approvalsealone = approvalmapper.approvalsealone(applyfor_approval_status, id, seal_id);
		return approvalsealone;
	}

	@Override
	public int ApprovalSealtwo(String applyfor_approval_status, int id, Integer seal_id) {
		int approvalsealtwo = approvalmapper.approvalsealtwo(applyfor_approval_status, id, seal_id);
		return approvalsealtwo;
	}

	@Override
	public int updateSealStatus(String string, Integer seal_id) {
	int update = 	approvalmapper.updateSeal(string,seal_id);
		return update;
	}

	
}
