package com.jt.lawfirm.mapper.statistics.sqlProvider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ComprehensiveSqlProvider {
	
	public String selectSiveToMap(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("case when a.times is null then b.times else a.times end times,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when a.sumHetong is null then 0 else a.sumHetong end sumHetong,\r\n" + 
						"	case when a.sumGui is null then 0 else a.sumGui end sumGui,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when b.sumInvoice is null then 0 else b.sumInvoice end sumInvoice\r\n" +
						"from (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(ci.cw_inout_date,'%Y年%m月') as times, \r\n" + 
						"		sum(ci.cw_inout_money) sumInout,\r\n" + 
						"		sum(cl.case_agencyfee) sumHetong,\r\n" + 
						"		sum(case when cl.case_plan = 'C' then ci.cw_inout_money else 0 end) sumGui\r\n" + 
						"		from cw_inout ci\r\n" + 
						"		left join case_law cl on cl.id = ci.case_law_id\r\n" + 
						"	where ci.cw_inout_date >= #{startTime} and ci.cw_inout_date <= #{endTime}\r\n" + 
						"	group by times\r\n" + 
						") a left join (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(cw_invoice_date,'%Y年%m月') as times, \r\n" + 
						"		sum(cw_invoice_money) sumInvoice\r\n" + 
						"		from cw_invoice\r\n" + 
						"	where cw_invoice_date >= #{startTime} and cw_invoice_date <= #{endTime}\r\n" + 
						"	group by times\r\n" + 
						") b on b.times = a.times \r\n" + 
						"union\r\n" + 
						"select case when a.times is null then b.times else a.times end times,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when a.sumHetong is null then 0 else a.sumHetong end sumHetong,\r\n" + 
						"	case when a.sumGui is null then 0 else a.sumGui end sumGui,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when b.sumInvoice is null then 0 else b.sumInvoice end sumInvoice\r\n" +
						"from (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(ci.cw_inout_date,'%Y年%m月') as times, \r\n" + 
						"		sum(ci.cw_inout_money) sumInout,\r\n" + 
						"		sum(cl.case_agencyfee) sumHetong,\r\n" + 
						"		sum(case when cl.case_plan = 'C' then ci.cw_inout_money else 0 end) sumGui\r\n" + 
						"		from cw_inout ci\r\n" + 
						"		left join case_law cl on cl.id = ci.case_law_id\r\n" + 
						"	where ci.cw_inout_date >= #{startTime} and ci.cw_inout_date <= #{endTime}\r\n" + 
						"	group by times\r\n" + 
						") a right join (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(cw_invoice_date,'%Y年%m月') as times, \r\n" + 
						"		sum(cw_invoice_money) sumInvoice\r\n" + 
						"		from cw_invoice\r\n" + 
						"	where cw_invoice_date >= #{startTime} and cw_invoice_date <= #{endTime}\r\n" + 
						"	group by times\r\n" + 
						") b on b.times = a.times ");
			}
		}.toString();
	}
	
	
	public String selectPersonalBusiness(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("he.emp_name, case when a.sumInvoice is null then 0 else a.sumInvoice end sumInvoice, " + 
						" case when b.sumInout is null then 0 else b.sumInout end sumInout," + 
						" case when b.sumGui is null then 0 else b.sumGui end sumGui");
				FROM("hr_emp he");
				LEFT_OUTER_JOIN("(select hr_emp_id, sum(cw_invoice_money) sumInvoice from cw_invoice " + 
						" where cw_invoice_date >= #{startTime} and cw_invoice_date <= #{endTime}" + 
						" group by hr_emp_id ) a on he.id = a.hr_emp_id");
				LEFT_OUTER_JOIN("(select ci.cw_inout_person,sum(ci.cw_inout_money) sumInout, " + 
						" sum(case when cl.case_plan = 'C' then ci.cw_inout_money else 0 end) sumGui from cw_inout ci " + 
						" inner join case_law cl on cl.id = ci.case_law_id where cw_inout_date >= #{startTime} "
						+ "and cw_inout_date <= #{endTime} group by ci.cw_inout_person ) b on b.cw_inout_person = he.id");
			}
		}.toString();
	}
	
	public String selectSiveToMapPlus(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("case when a.times is null then b.times else a.times end times,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when a.sumHetong is null then 0 else a.sumHetong end sumHetong,\r\n" + 
						"	case when a.sumGui is null then 0 else a.sumGui end sumGui,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when b.sumInvoice is null then 0 else b.sumInvoice end sumInvoice\r\n" +
						"from (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(ci.cw_inout_date,'%Y年%m月') as times, \r\n" + 
						"		sum(ci.cw_inout_money) sumInout,\r\n" + 
						"		sum(cl.case_agencyfee) sumHetong,\r\n" + 
						"		sum(case when cl.case_plan = 'C' then ci.cw_inout_money else 0 end) sumGui\r\n" + 
						"		from cw_inout ci\r\n" + 
						"		left join case_law cl on cl.id = ci.case_law_id\r\n" + 
						"	where ci.cw_inout_date >= #{startTime} and ci.cw_inout_date <= #{endTime}\r\n"
						+ " and ci.cw_inout_person = #{properId} " + 
						"	group by times\r\n" + 
						") a left join (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(cw_invoice_date,'%Y年%m月') as times, \r\n" + 
						"		sum(cw_invoice_money) sumInvoice\r\n" + 
						"		from cw_invoice\r\n" + 
						"	where cw_invoice_date >= #{startTime} and cw_invoice_date <= #{endTime}\r\n"
						+ " and hr_emp_id = #{properId}" + 
						"	group by times\r\n" + 
						") b on b.times = a.times \r\n" + 
						"union\r\n" + 
						"select case when a.times is null then b.times else a.times end times,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when a.sumHetong is null then 0 else a.sumHetong end sumHetong,\r\n" + 
						"	case when a.sumGui is null then 0 else a.sumGui end sumGui,\r\n" + 
						"	case when a.sumInout is null then 0 else a.sumInout end sumInout,\r\n" + 
						"	case when b.sumInvoice is null then 0 else b.sumInvoice end sumInvoice\r\n" +
						"from (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(ci.cw_inout_date,'%Y年%m月') as times, \r\n" + 
						"		sum(ci.cw_inout_money) sumInout,\r\n" + 
						"		sum(cl.case_agencyfee) sumHetong,\r\n" + 
						"		sum(case when cl.case_plan = 'C' then ci.cw_inout_money else 0 end) sumGui\r\n" + 
						"		from cw_inout ci\r\n" + 
						"		left join case_law cl on cl.id = ci.case_law_id\r\n" + 
						"	where ci.cw_inout_date >= #{startTime} and ci.cw_inout_date <= #{endTime}\r\n" 
						+ " and ci.cw_inout_person = #{properId} " + 
						"	group by times\r\n" + 
						") a right join (\r\n" + 
						"	select \r\n" + 
						"		DATE_FORMAT(cw_invoice_date,'%Y年%m月') as times, \r\n" + 
						"		sum(cw_invoice_money) sumInvoice\r\n" + 
						"		from cw_invoice\r\n" + 
						"	where cw_invoice_date >= #{startTime} and cw_invoice_date <= #{endTime}\r\n" +
						" and hr_emp_id = #{properId}" + 
						"	group by times\r\n" + 
						") b on b.times = a.times ");
			}
		}.toString();
	}
	
	public String selectReceiveStatistical(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("cw_pay_type, sum(cw_inout_money) money");
				FROM("cw_inout");
				WHERE("cw_inout_date >= #{startTime}");
				WHERE("cw_inout_date <= #{endTime}");
				GROUP_BY("cw_pay_type");
			}
		}.toString();
	}
	
	public String selectClassInvoice(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("a.date1,\r\n" + 
						"	sum(case when a.type_pid = 1001 then a.sumMoney else 0 end) as '1001', " + 
						"	sum(case when a.type_pid = 1002 then a.sumMoney else 0 end) as '1002', " + 
						"	sum(case when a.type_pid = 1003 then a.sumMoney else 0 end) as '1003',\r\n" + 
						"  sum(case when a.type_pid = 1004 then a.sumMoney else 0 end) as '1004',\r\n" + 
						"  sum(case when a.type_pid = 1005 then a.sumMoney else 0 end) as '1005',\r\n" + 
						"  sum(case when a.type_pid = 1006 then a.sumMoney else 0 end) as '1006',\r\n" + 
						"  sum(case when a.type_pid = 1007 then a.sumMoney else 0 end) as '1007',\r\n" + 
						"  sum(case when a.type_pid = 1008 then a.sumMoney else 0 end) as '1008',\r\n" + 
						"  sum(case when a.type_pid = 1009 then a.sumMoney else 0 end) as '1009',\r\n" + 
						"  sum(case when a.type_pid = 1010 then a.sumMoney else 0 end) as '1010',\r\n" + 
						"  sum(case when a.type_pid = 1011 then a.sumMoney else 0 end) as '1011'\r\n" + 
						" from (\r\n" + 
						"select DATE_FORMAT(c.cw_invoice_date,'%Y-%c') date1,t.type_pid,sum(c.cw_invoice_money) sumMoney from cw_invoice c \r\n" + 
						"	inner join case_law w on c.case_law_id = w.id \r\n" + 
						"	inner join case_case_type t on t.id = w.case_case_type_id\r\n" + 
						"	where DATE_FORMAT(c.cw_invoice_date,'%Y-%m') >= #{startTime} "
						+ " and DATE_FORMAT(c.cw_invoice_date,'%Y-%m') <= #{endTime}\r\n" + 
						"	group by DATE_FORMAT(c.cw_invoice_date,'%Y-%c'),t.type_pid\r\n" + 
						") a \r\n" + 
						"group by a.date1\r\n" + 
						"");
			}
		}.toString();
	}
	
}
