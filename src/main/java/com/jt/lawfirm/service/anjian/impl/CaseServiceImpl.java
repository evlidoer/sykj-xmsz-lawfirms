package com.jt.lawfirm.service.anjian.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.anjian.CaseCostRelief;
import com.jt.lawfirm.bean.anjian.CaseServiceLog;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;
import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.mapper.anjian.CaseMapper;
import com.jt.lawfirm.service.anjian.CaseService;

@Service("caseService")
public class CaseServiceImpl implements CaseService {
	@Resource
	private CaseMapper caseMapper;
	/**
	 *	 审查
	 */
	//显示案件
	@Override
	public List<Map<String, Object>> findCase(Map<String, Object> map) {
		return caseMapper.findCase(map);
	}
	//查询emp   的 id
		@Override
		public Integer findEmpById(Map<String, Object> map) {
			return caseMapper.findEmpById(map);
		}
	
	
	/**********************
	 * 		新增案件
	 */
	//新增案件 显示下面菜单
	@Override
	public List<CaseType> findCaseType(Integer cols) {
		//全部数据
		List<CaseType> findAllCaseType = caseMapper.findAllCaseTypeById(cols);
		//定义一个集合存放最后的结果
		List<CaseType> endCaseList = new ArrayList<>();
		for (CaseType caseType : findAllCaseType) {
			if (caseType.getTypeId() == null || "".equals(caseType.getTypeId())) {
				//先找到一级目录存在集合里面
				endCaseList.add(caseType);
			}
		}
		//为一级菜单设置子菜单
		for (CaseType caseType : endCaseList) {
			//设置子菜单递归
			caseType.setCaseType(getClientCaseType(caseType.getId(), findAllCaseType));
		}
			
		return endCaseList;
	}


	private List<CaseType> getClientCaseType(Integer typeId, List<CaseType> findAllCaseType) {
		//定义一个集合存放子菜单
		List<CaseType> ClientCaseType = new ArrayList<CaseType>();
		//查找子菜单
		List<CaseType> findCaseType = caseMapper.findCaseType(typeId);
		for (CaseType caseType : findCaseType) {
			//添加按typeId查询出子菜单并添加
			if (caseType.getId() != null) {
					ClientCaseType.add(caseType);
			}
		}
		
		//把子菜单在递归一遍找出子菜单的子菜单
		for (CaseType caseType : ClientCaseType) {
			//直接递归就行
			getClientCaseType(caseType.getId(), findAllCaseType);
		}
		//停止条件
		if (ClientCaseType.size() == 0) {
			return null;
		}
		return ClientCaseType;
	}
	
	//addCase4  添加 law
	@Override
	public Integer addCaseLaw(Law law) {
		
		return caseMapper.addCaseLaw(law);
	}
	//查询客户表id  
	@Override
	public Integer selClientByName(String clientname,Integer empid) {
		return caseMapper.selClientByName(clientname,empid);
	}
	//判断案号 
	@Override
	public Integer anjianHaoYN(String anjianHao) {
		return caseMapper.anjianHaoYN(anjianHao);
	}
	//查询案件号 id
	@Override
	public Integer anjianHaoSel(String anjianHao) {
		return caseMapper.anjianHaoSel(anjianHao);
	}
	//查询文书
	@Override
	public List<Map<String, Object>> ajaxCaseSealApplyfor(Map<String, Object> map) {
		return caseMapper.ajaxCaseSealApplyfor(map);
	}
	//添加文书
	@Override
	public boolean addCaseSealApplyfor(CaseSealApplyfor cs) {
		return caseMapper.addCaseSealApplyfor(cs);
	}
	
	

	/************************************
	 *	 我的案件
	 */
	//显示案件
	@Override
	public List<Map<String, Object>> myCasefindCase(Map<String, Object> map) {
		return caseMapper.myCasefindCase(map);
	}
		//我的案件修改查
	@Override
	public List<Map<String, Object>> myCaseById(Integer id) {
		return caseMapper.myCaseById(id);
	}

	//修改
	@Override
	public boolean myCaseUpdate(Law law) {
		return caseMapper.myCaseUpdate(law);
	}

	//3收款
	@Override
	public boolean myCaseOperate3Up(Integer id, double payPrice) {
		return caseMapper.myCaseOperate3Up(id,payPrice);
	}
	
	//4结案   提交
	@Override
	public boolean myCaseOperate4Up(Integer id, String case_settle_way, String case_settle_date) {
		return caseMapper.myCaseOperate4Up(id,case_settle_way,case_settle_date);
	}
	

	//减免申请 显示数据
	@Override
	public List<Map<String, Object>> myCaseEmpById(Integer id) {
		return caseMapper.myCaseEmpById(id);
	}

	//添加 案件费用减免记录 表case_cost_relief
	@Override
	public boolean addCaseCostRelief(CaseCostRelief ccr) {
		return caseMapper.addCaseCostRelief(ccr);
	}




	
	//修改案件状态
	@Override
	public boolean myCasejieanUpdate(Integer id) {
		return caseMapper.myCasejieanUpdate(id);
	}


	//	咨询与代书
	//--显示 服务记录
	@Override
	public List<Map<String, Object>> ConsultingGhostwritingShow(Map<String, Object> map) {
		return caseMapper.ConsultingGhostwritingShow(map);
	}


	//咨询与代书添加  开庭表添加
	@Override
	public boolean CaseServiceLogAdd(CaseServiceLog cs) {
		return caseMapper.CaseServiceLogAdd(cs);
	}
	@Override
	public List<Map<String, Object>> ConflictOfInterestReview(Map<String, Object> map) {
		return caseMapper.ConflictOfInterestReview(map);
	}


	
	
	
	
	


	






	


	
	
	
}
