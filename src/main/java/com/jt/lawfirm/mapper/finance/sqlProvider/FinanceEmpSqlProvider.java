package com.jt.lawfirm.mapper.finance.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

public class FinanceEmpSqlProvider {
	
	public String selectNameByCaseId(String id) {
		return new SQL() {
			{
				SELECT("he.id");
				FROM("hr_emp he");
				INNER_JOIN("case_law cl on he.id = cl.case_attorney_id");
				WHERE("cl.id = #{id}");
			}
		}.toString();
	}
	
	public String selectEmpToIdAndName(String name) {
		return new SQL() {
			{	
				SELECT("he.id, he.emp_name empName");
				FROM("hr_emp he ");
				INNER_JOIN("hr_ident hi on hi.hr_emp_id = he.id");
				INNER_JOIN("hr_lawyer_identity hli on hli.id = hi.lawyer_identity_id");
				WHERE("hli.identity_name = '律师'");
				if(name.trim().equals("")) {
					WHERE("he.emp_name = '-1111111111'");
				}else {
					WHERE("he.emp_name like '%" + name + "%'");
				}
				GROUP_BY("he.id");
			}
		}.toString();
	}
}
