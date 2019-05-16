package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.jt.lawfirm.mapper.finance.sqlProvider.FinanceKdmanagerSqlProvider;

public interface IFinanceKdmanagerMapper {
	
	@SelectProvider(type=FinanceKdmanagerSqlProvider.class, method="selectKdmanagerFAllByY")
	List<Map<String, String>> selectKdmanagerFAllByY();
	
	@SelectProvider(type=FinanceKdmanagerSqlProvider.class, method="selectKdmanagerKdAllByY")
	List<Map<String, String>> selectKdmanagerKdAllByY();
	
	@InsertProvider(type=FinanceKdmanagerSqlProvider.class, method="insertKdmanagerFInMap")
	boolean insertKdmanagerFInMap(Map<String, String> map);
	
}
