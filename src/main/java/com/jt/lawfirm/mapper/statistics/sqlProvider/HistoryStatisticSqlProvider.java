package com.jt.lawfirm.mapper.statistics.sqlProvider;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class HistoryStatisticSqlProvider {
	
	public String selectHistoryAndEmp(@Param("id") Integer id) {
		return new SQL() {
			{
				SELECT("chs.*, he.emp_name");
				FROM("cw_history_statistic chs");
				INNER_JOIN("hr_emp he on he.id = chs.hr_emp_id");
				if (id != null && id != 0) WHERE("he.id = #{id}");
				ORDER_BY("chs.id desc");	
			}
		}.toString();
	}
	
	public String insertHistory(Map<String, String> map) {
		return new SQL() {
			{
				INSERT_INTO("cw_history_statistic");
				if(map.get("id") != null) VALUES("hr_emp_id", "#{id}");
				if(map.get("sumZ") != null) VALUES("cw_expend_all", "#{sumZ}");
				if(map.get("startTime") != null) VALUES("cw_begin_date", "#{startTime}");
				if(map.get("endTime") != null) VALUES("cw_end_date", "#{endTime}");
				if(map.get("sumS") != null) VALUES("cw_income_all", "#{sumS}");
				if(map.get("sumT") != null) VALUES("cw_actual", "#{sumT}");
			}
		}.toString();
	}
	
}
