package com.jt.lawfirm.mapper.hr.sqlProvider;

import org.apache.ibatis.jdbc.SQL;
/**
 * @author 代
 * */
public class HrTeamSqlProvider {
	public String selectuser(String string){
		return new SQL(){
			{
				SELECT("e.id id,u.user_name userName,e.emp_name empName,e.emp_phone empPhone");
				FROM("system_user u");
				INNER_JOIN("hr_emp e on e.id = u.hr_emp_id");
				if (string != null) WHERE("(user_name like "+"'%"+string+"%')or(user_realname like "+"'%"+string+"%')or(user_phone like "+"'%"+string+"%')");
			}
		}.toString();
	}
}
