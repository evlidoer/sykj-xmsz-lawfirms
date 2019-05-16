package com.jt.lawfirm.mapper.finance.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class FinanceLawSqlProvider {
	
	public String selectLawOfSive(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("a.moneyNum, (case when b.money is null then 0 else b.money end) money, c.*");
				FROM("(select cl.id clId, sum(ci.cw_inout_money) moneyNum " + 
						"from case_law cl left join cw_inout ci on ci.case_law_id = cl.id " + 
						"inner join cw_inout_type cit on cit.id = ci.cw_inout_type_id " + 
						"where (cit.id = 1001 or cit.cw_pid = 1001) group by cl.id) a ");
				LEFT_OUTER_JOIN("(select sum(cw_invoice_money) money, case_law_id cid " + 
						"from cw_invoice group by case_law_id ) b on a.clId = b.cid");
				RIGHT_OUTER_JOIN("(select cl.id csid , cl.case_parties parties, cl.case_opposite_parties oparties,"
						+ " cl.case_cause cause, cl.case_court court, cl.case_propernum propernum," + 
						" he.emp_name lawyer, cl.case_subtime subtime, cl.case_agencyfee agencyfee from case_law cl " + 
						" inner join hr_emp he on he.id = cl.case_attorney_id " + 
						") c on c.csid = a.clId");
				if(map.get("str0") != null) {
					if(map.get("str1").equals("1")) WHERE("c.propernum like '%" + map.get("str0") + "%'");
					if(map.get("str1").equals("2")) WHERE("c.parties like '%" + map.get("str0") + "%'");
					if(map.get("str1").equals("3")) WHERE("c.oparties like '%" + map.get("str0") + "%'");
					if(map.get("str1").equals("4")) WHERE("c.cause like '%" + map.get("str0") + "%'");
					if(map.get("str1").equals("5")) WHERE("c.lawyer like '%" + map.get("str0") + "%'");
					if(map.get("str1").equals("6")) WHERE("c.court like '%" + map.get("str0") + "%'");
				}
			}
		}.toString();
	}
	
}
