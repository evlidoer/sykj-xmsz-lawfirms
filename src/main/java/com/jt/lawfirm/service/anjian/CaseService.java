package com.jt.lawfirm.service.anjian;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.anjian.CaseCostRelief;
import com.jt.lawfirm.bean.anjian.CaseServiceLog;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;
import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.finance.CaseType;

public interface CaseService {
	/**
	 * 	审查
	 * @param map
	 * @return
	 */
	////显示案件
	List<Map<String, Object>> findCase(Map<String, Object> map);
	//查询emp   的 id
	Integer findEmpById(Map<String, Object> map);

	
	/**
	 *	 新增案件
	 * @param cols
	 * @return
	 */
	//新增案件递归查
	List<CaseType> findCaseType(Integer cols);
		//addCase4  添加 law
		Integer addCaseLaw(Law law);
		//查客户id
		Integer selClientByName(String clientname,Integer empId);
		//判断案号
		Integer anjianHaoYN(String anjianHao);
		//查询案号
		Integer anjianHaoSel(String anjianHao);
	//	查询文书
	List<Map<String, Object>> ajaxCaseSealApplyfor(Map<String, Object> map);
//	添加文书
	boolean addCaseSealApplyfor(CaseSealApplyfor cs);
	
	
	/**
	 * 	我的案件
	 * @param map
	 * @return
	 */
	////显示案件
	List<Map<String, Object>> myCasefindCase(Map<String, Object> map);
	//修改查
	List<Map<String, Object>> myCaseById(Integer id);
	//修改
	boolean myCaseUpdate(Law law);
	
	///3收款
	//修改
	boolean myCaseOperate3Up(Integer id, double payPrice);
	
	//4 结案 
	boolean myCaseOperate4Up(Integer id, String case_settle_way, String case_settle_date);
	
	
//***********
	//减免申请显示数据
	List<Map<String, Object>> myCaseEmpById(Integer id);
	//添加 案件费用减免记录 表case_cost_relief
	boolean addCaseCostRelief(CaseCostRelief ccr);
	

	//修改案件 状态
	boolean myCasejieanUpdate(Integer id);

	
	
	
	
	//显示 服务记录 
	List<Map<String, Object>> ConsultingGhostwritingShow(Map<String, Object> map);

	
	
	
	
	//咨询与代书添加
	boolean CaseServiceLogAdd(CaseServiceLog cs);
	
	//审查
	List<Map<String, Object>> ConflictOfInterestReview(Map<String, Object> map);
	
	
	

	
	
	
	


	
	
}
