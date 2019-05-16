package com.jt.lawfirm.mapper.statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.jt.lawfirm.mapper.statistics.sqlProvider.CaseSealApplyforSqlProvider;

public interface ICaseSealApplyforMapper {
	
	@SelectProvider(type=CaseSealApplyforSqlProvider.class, method="selectApplyforOfSive")
	List<Map<String, String>> selectApplyforOfSive(Map<String, String> map);
	
}
