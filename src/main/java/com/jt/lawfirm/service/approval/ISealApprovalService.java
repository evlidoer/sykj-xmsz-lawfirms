package com.jt.lawfirm.service.approval;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.casea.CaseApproval;

public interface ISealApprovalService {
	List<Map<String,Object>> SelectAll(Map<String,Object> map);

	List<Map<String, Object>> SelectSeal(Integer id);

	List<Map<String, Object>> SelectLawById(Integer id);

	List<Map<String, Object>> selectSealLawById(Integer id);

	List<Map<String, Object>> SelectEmp(Integer id);

	int insertApprove_updateApprove(CaseApproval lawApproval);

	int recordnum(Integer id);

	int updatecaseseal(Map<String, Object> map);

	List<Map<String, Object>> SelectSealFileById(Integer id);

	
}
