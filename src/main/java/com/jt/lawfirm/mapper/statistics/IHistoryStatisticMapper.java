package com.jt.lawfirm.mapper.statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.statistics.HistoryStatistic;
import com.jt.lawfirm.mapper.statistics.sqlProvider.HistoryStatisticSqlProvider;

public interface IHistoryStatisticMapper extends BaseMapper<HistoryStatistic> {
		
	@SelectProvider(type=HistoryStatisticSqlProvider.class, method="selectHistoryAndEmp")
	List<Map<String, String>> selectHistoryAndEmp(@Param("id") Integer id);
	
	@InsertProvider(type=HistoryStatisticSqlProvider.class, method="insertHistory")
	boolean insertHistory(Map<String, String> map);
	
}
