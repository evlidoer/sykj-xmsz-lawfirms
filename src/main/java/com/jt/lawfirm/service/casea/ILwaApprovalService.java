package com.jt.lawfirm.service.casea;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.casea.CaseLawtype;
import com.jt.lawfirm.bean.casea.Law;

public interface ILwaApprovalService {
	List<Map<String,Object>> FindAll(Map<String,Object> map);
	List<Map<String,Object>> FindById(Integer id);
	int modiflaw(Law law);
	List<CaseLawtype> FindType();
}
