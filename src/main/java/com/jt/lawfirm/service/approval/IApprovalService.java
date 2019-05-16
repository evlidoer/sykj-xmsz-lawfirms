package com.jt.lawfirm.service.approval;

public interface IApprovalService {

	int userSel(String username,Integer lawId);

	int ApprovalLawone(String approvalStaus,Integer id, Integer law_id);
	
	String StatusSel(int i, Integer lawId);

	int ApprovalLawtwo(String approvalStaus,Integer id, Integer law_id);

	int approvallaw(String approvalStaus, Integer law_id);

	String StatusSelSeal(int i, Integer seal_id);

	int userSelSeal(String username, Integer seal_id);

	int approvalSeal(String applyfor_approval_status, Integer seal_id);

	int ApprovalSealone(String applyfor_approval_status, int id, Integer seal_id);

	int ApprovalSealtwo(String applyfor_approval_status, int id, Integer seal_id);

	int updateSealStatus(String string, Integer seal_id);


}
