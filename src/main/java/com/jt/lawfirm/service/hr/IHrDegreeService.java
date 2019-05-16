package com.jt.lawfirm.service.hr;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.hr.HrDegree;
/*
 * 
 * @author代国繁
 * */
public interface IHrDegreeService {
	List<HrDegree> selectdegreebyid(Map<String, Object> map);
	boolean updatedegree(HrDegree degree);
	boolean deletedegree(int id);
	boolean adddegrree(HrDegree degree);
}
