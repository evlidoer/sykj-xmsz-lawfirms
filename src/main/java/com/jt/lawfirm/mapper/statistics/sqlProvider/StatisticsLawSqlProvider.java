package com.jt.lawfirm.mapper.statistics.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class StatisticsLawSqlProvider {
	
	public String selectLawAll(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("cl.case_propernum, cl.case_cause, cl.case_subtime, cl.case_parties, cl.case_opposite_parties, he.emp_name, cl.case_accept," + 
						" case when cl.case_agencyfee is null then 0 else cl.case_agencyfee end agencyfee, cl.case_lawsuitobj," + 
						" a.sumInout, b.sumInvoice, cl.case_clash, cl.case_filenumber, cl.case_settle_status, cl.case_settle_date, cl.case_settle_way");
				FROM("case_law cl");
				INNER_JOIN("hr_emp he on he.id = cl.case_attorney_id");
				INNER_JOIN("case_case_type cct on cct.id = cl.case_case_type_id");
				INNER_JOIN("(select cl.id, sum(case when ci.cw_inout_money is null then 0 else ci.cw_inout_money end) sumInout "
						+ " from case_law cl left join cw_inout ci on ci.case_law_id = cl.id " + 
						" group by cl.id ) a on a.id = cl.id");
				INNER_JOIN("(select cl.id, sum(case when ci.cw_invoice_money is null then 0 else ci.cw_invoice_money end) sumInvoice "
						+ " from case_law cl left join cw_invoice ci on ci.case_law_id = cl.id group by cl.id ) b on b.id = cl.id");
				if(map.get("properId") != null) WHERE("he.id = #{properId}");
				if(map.get("cType") != null) WHERE("(cct.id = #{cType} or cct.type_pid = #{cType})");
				if(map.get("ssjd") != null) WHERE("cl.case_status = #{ssjd}");
				if(map.get("jaStatus") != null) WHERE("case_settle_status = #{jaStatus}");
				if(map.get("sffs") != null) WHERE("case_charge_way = #{sffs}");
				if(map.get("startTime") != null) WHERE("case_subtime >= #{startTime}");
				if(map.get("endTime") != null) WHERE("case_subtime <= #{endTime}");
				if(map.get("dagd") != null) WHERE("case_clash = #{dagd}");
				ORDER_BY("cl.id desc");
			}
		}.toString();
	}
	
}
