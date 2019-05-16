package com.jt.lawfirm.mapper.statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.mapper.statistics.sqlProvider.StatisticsLawSqlProvider;

public interface IStatistiscsLawMapper extends BaseMapper<Law> {
	
	@SelectProvider(type=StatisticsLawSqlProvider.class, method="selectLawAll")
	List<Map<String, String>> selectLawAll(Map<String, String> map);
	
}	
