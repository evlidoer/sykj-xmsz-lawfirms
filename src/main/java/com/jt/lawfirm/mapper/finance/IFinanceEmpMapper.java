package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.mapper.finance.sqlProvider.FinanceEmpSqlProvider;

public interface IFinanceEmpMapper extends BaseMapper<HrEmp> {
	
	@SelectProvider(type=FinanceEmpSqlProvider.class, method="selectNameByCaseId")
	String selectNameByCaseId(String id);
	
	@SelectProvider(type=FinanceEmpSqlProvider.class, method="selectEmpToIdAndName")
	List<Map<String, String>> selectEmpToIdAndName(String name);
	
}
