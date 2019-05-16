package com.jt.lawfirm.mapper.statistics.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;

public class InoutAndTypeSqlProvider {
	
	public String selectFinanceStatistics(MyIncomeOfSive myOfSive) {
		return new SQL() {
			{
				SELECT("cit.id, cit.cw_pid,sum(case when ci.cw_inout_money is null then 0 else ci.cw_inout_money end) money");
				FROM("cw_inout ci ");
				RIGHT_OUTER_JOIN("cw_inout_type cit on cit.id = ci.cw_inout_type_id ");
				if(myOfSive.getStartTime() != null && !myOfSive.getStartTime().equals("")) WHERE("ci.cw_inout_date >= #{startTime}");
				if(myOfSive.getEndTime() != null && !myOfSive.getEndTime().equals("")) WHERE("ci.cw_inout_date <= #{endTime}");
				GROUP_BY("cit.id");
			}
		}.toString();
	}
	
}
