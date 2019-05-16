package com.jt.lawfirm.mapper.finance.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class AllInoutSqlProvider {
	
	public String selectAllBudgetOfSive(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("a.cwInoutTypeName, a.id cwId, a.cw_inout_date, a.case_law_id, a.cw_pay_type, b.caseUmber, a.emp_name, a.cw_payer,"
						+ " a.cw_remark, a.cw_inout_money, c.get, c.put");
				FROM("(SELECT ci.*, cit.cw_name cwInoutTypeName, cit.cw_pid, he.emp_name FROM cw_inout ci " + 
						"INNER JOIN cw_inout_type cit ON cit.id = ci.cw_inout_type_id " + 
						"INNER JOIN hr_emp he on he.id = ci.cw_inout_person) a");
				LEFT_OUTER_JOIN("(SELECT cl.case_propernum caseUmber,cl.case_parties, cl.id cid, cct.type_pid, cl.case_case_type_id " + 
						"FROM case_law cl INNER JOIN case_case_type cct ON cct.id = cl.case_case_type_id ) b "
						+ "on b.cid = a.case_law_id");
				INNER_JOIN("(SELECT ci.id  cid, CASE WHEN ci.cw_inout_type_id = 1001 OR cit.cw_pid = 1001 "
						+ "OR ci.cw_inout_type_id = 1002 OR cit.cw_pid = 1002 OR cit.cw_pid = 100103 THEN ci.cw_inout_money END "
						+ "as 'put', CASE WHEN ci.cw_inout_type_id = 1003 OR cit.cw_pid = 1003 OR ci.cw_inout_type_id = 1004 "
						+ "OR cit.cw_pid = 1004 OR cit.cw_pid = 1005 OR ci.cw_inout_type_id = 1005 THEN ci.cw_inout_money END"
						+ " AS 'get' FROM cw_inout ci INNER JOIN cw_inout_type cit ON cit.id = ci.cw_inout_type_id " + 
						") c on c.cid = a.id");
				if(map.get("caseId") != null) {
					if(map.get("caseIdNum").equals("1")) WHERE("b.caseUmber like '%" + map.get("caseId") + "%'");
					if(map.get("caseIdNum").equals("2")) WHERE("a.emp_name like '%" + map.get("caseId") + "%'");
					if(map.get("caseIdNum").equals("3")) WHERE("b.case_parties like '%" + map.get("caseId") + "%'");
				}
				if(!map.get("cType").equals("-1")) WHERE("(b.case_case_type_id = #{cType} or b.type_pid = #{cType})");
				if(!map.get("payment").equals("-1")) WHERE("a.cw_pay_type = #{payment}");
				if(!map.get("inType").equals("-1")) WHERE("(a.cw_inout_type_id = #{inType} or a.cw_pid = #{inType})");
				if(map.get("startTime") != null) WHERE("a.cw_inout_date >= #{startTime}");
				if(map.get("endTime") != null) WHERE("a.cw_inout_date <= #{endTime}");
				ORDER_BY("a.cw_inout_date desc");
			}
		}.toString();
	}
	
}
