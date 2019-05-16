package com.jt.lawfirm.mapper.statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.jt.lawfirm.mapper.statistics.sqlProvider.ComprehensiveSqlProvider;

public interface IComprehensiveMapper {
	
	@SelectProvider(type=ComprehensiveSqlProvider.class, method="selectSiveToMap")
	List<Map<String, String>> selectSiveToMap(Map<String, String> map);
	
	@SelectProvider(type=ComprehensiveSqlProvider.class, method="selectSiveToMapPlus")
	List<Map<String, String>> selectSiveToMapPlus(Map<String, String> map);
	
	@SelectProvider(type=ComprehensiveSqlProvider.class, method="selectPersonalBusiness")
	List<Map<String, String>> selectPersonalBusiness(Map<String, String> map);
	
	@SelectProvider(type=ComprehensiveSqlProvider.class, method="selectReceiveStatistical")
	List<Map<String, String>> selectReceiveStatistical(Map<String, String> map);
	
	@SelectProvider(type=ComprehensiveSqlProvider.class, method="selectClassInvoice")
	List<Map<String, String>> selectClassInvoice(Map<String, String> map);
	
}
