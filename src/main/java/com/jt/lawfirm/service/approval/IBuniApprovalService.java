package com.jt.lawfirm.service.approval;

import java.util.List;
import java.util.Map;

public interface IBuniApprovalService {
	List<Map<String,Object>> SelectBuni(Map<String, Object> map);

	List<Map<String, Object>> SelectSettle(Map<String, Object> map);

	List<Map<String, Object>> SelectRefund(Map<String, Object> map);

	List<Map<String, Object>> reliefSelById(Integer id);

	List<Map<String, Object>> SettleSelById(Integer id);

	List<Map<String, Object>> RefundSelById(Integer id);

	String record(Integer id);

	String StatusSelsettle(int i, Integer settle_id);

	int userSelsettle(String username, Integer settle_id);

	int approvalsettle(String applyfor_approval_status, Integer settle_id);

	int Approvalsettleone(String applyfor_approval_status, int id, Integer settle_id);

	int Approvalsettletwo(String applyfor_approval_status, int id, Integer settle_id);

	String StatusSelrelief(int i, Integer relief_id);

	int userSelrelief(String username, Integer relief_id);

	int approvalrelief(String applyfor_approval_status, Integer relief_id);

	int Approvalreliefone(String applyfor_approval_status, int id, Integer relief_id);

	int Approvalrelieftwo(String applyfor_approval_status, int id, Integer relief_id);

	String StatusSelrefund(int i, Integer refund_id);

	int userSelrefund(String username, Integer refund_id);

	int approvalrefund(String applyfor_approval_status, Integer refund_id);

	int Approvalrefundone(String applyfor_approval_status, int id, Integer refund_id);

	int Approvalrefundtwo(String applyfor_approval_status, int id, Integer refund_id);
}
