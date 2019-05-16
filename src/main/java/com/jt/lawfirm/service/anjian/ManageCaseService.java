package com.jt.lawfirm.service.anjian;

import java.util.List;
import java.util.Map;

public interface ManageCaseService {
	//修改案号
	Integer upAnjianHao(Map<String, Object> map);
	//判断案号
	String selCasePropernum(String CasePropernum);
	//添加档案号
	Integer setCaseFilenumber(Map<String, Object> map);
	//回收 + //删除
	Integer addLawHistroy_DelLaw(String id);
	//显示回收
	List<Map<String, Object>> lawHistroy(String title);
	
}
