package com.jt.lawfirm.mapper.hr.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author 代
 * */
public class HrEmpSqlProvider {

	
	public String selectemp(){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_emp");
			}
		}.toString();
	}
	public String selectdegree(){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_degree");
			}
		}.toString();
	}
	
	public String selectwork(){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_workhistory");
			}
		}.toString();
	}
	
	public String selectrew(){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_reward");
			}
		}.toString();
	}
	
	public String selectpun(){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_punishment");
			}
		}.toString();
	}
	
	public String selectins(String id){
		return new SQL(){
			{
				SELECT("*");
				FROM("hr_insured");
				WHERE("hr_emp_id = '" + id+"'");
			}
		}.toString();
	}
	public String updatecb(Map<String, Object> map){
		return new SQL(){
			{
				UPDATE("hr_insured");
				SET("insured_name = '"+map.get("insuredName")+"'");
				WHERE("id = '"+map.get("id")+"'");
			}
		}.toString();
	}
	
	public String insertcb(Map<String, Object> map){
		return new SQL(){
			{
				INSERT_INTO("hr_insured");
				VALUES("insured_name", "'" + map.get("insuredName")+"'" );
				VALUES("hr_emp_id", "'" + map.get("hrEmpId")+"'" );
			}
		}.toString();
	}
}
