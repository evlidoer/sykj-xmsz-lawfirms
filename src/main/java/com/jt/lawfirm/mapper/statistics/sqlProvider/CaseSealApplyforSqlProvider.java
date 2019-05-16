package com.jt.lawfirm.mapper.statistics.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CaseSealApplyforSqlProvider {
	
	public String selectApplyforOfSive(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("csa.*, cl.case_propernum, he.emp_name");
				FROM("case_seal_applyfor csa");
				INNER_JOIN("case_law cl on cl.id = csa.case_law_id");
				LEFT_OUTER_JOIN("case_case_type cct on cct.id = cl.case_case_type_id");
				INNER_JOIN("hr_emp he on he.id = cl.case_attorney_id");
				if (map.get("yyType") != null) WHERE("csa.applyfor_using_the_item = #{yyType}");
				if (map.get("properId") != null) WHERE("he.id = #{properId}");
				if (map.get("cType") != null) WHERE("(cct.id = #{cType} or cct.type_pid = #{cType})");
				if (map.get("startTime") != null) WHERE("csa.applyfor_receive >= #{startTime}");
				if (map.get("endTime") != null) WHERE("csa.applyfor_receive <= #{endTime}");
				if (map.get("spStatus") != null) WHERE("csa.applyfor_approval_status = #{spStatus}");
				ORDER_BY("csa.applyfor_receive desc");
			}
		}.toString();
	}
	
}
