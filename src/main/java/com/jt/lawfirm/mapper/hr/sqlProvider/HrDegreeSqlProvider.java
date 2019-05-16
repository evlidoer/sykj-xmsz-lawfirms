package com.jt.lawfirm.mapper.hr.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class HrDegreeSqlProvider {
	public String selectdegreebyid(Map<String, Object> map){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_degree");
				if (map.get("hr_emp_id") != null && map.get("hr_emp_id") != "") WHERE("hr_emp_id ='" + map.get("hr_emp_id")+"'") ;
				if (map.get("id")!= null && map.get("id") != "") WHERE("id ='" + map.get("id")+"' ");
			}
		}.toString();
	}
}
