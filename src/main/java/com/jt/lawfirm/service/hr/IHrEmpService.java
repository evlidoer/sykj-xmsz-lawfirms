package com.jt.lawfirm.service.hr;
/*
 * 
 * @author代国繁
 * */
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.HrInsured;
import com.jt.lawfirm.bean.hr.HrPunishment;
import com.jt.lawfirm.bean.hr.HrReward;

public interface IHrEmpService {
	List<HrEmp> selectbyid(Map<String, Object> map);
	List<Map<String, String>> selectemp();
	List<Map<String, String>> selectdegree();
	List<Map<String, String>> selectwork();
	List<Map<String, String>> selectrew();
	List<Map<String, String>> selectpun();
	boolean updatebyid(HrEmp hremp);
	boolean deletebyid(int id,Map<String, Object> map);
	List<String> selectcase(String casetypename);
	boolean addemp(Map<String, String> map);
	boolean addident(HrIdent hrIdent,HrInsured hrInsured);
	List<String> selectempid();
	List<HrReward> selectrew(Map<String, Object> map);
	List<HrPunishment> selectpun(Map<String, Object> map);
	boolean addreward(HrReward hrReward);
	boolean addpun(HrPunishment punishment);
	boolean insert(Map<String, String> map,int id);
	boolean uprew(HrReward hrReward);
	boolean uppun(HrPunishment hrPunishment);
	boolean deleterew(int id);
	boolean deletepun(int id);
	List<HrInsured> selectins(String id);
	boolean updatecb(Map<String, Object>map);
	boolean insertcb(Map<String, Object> map);
}
