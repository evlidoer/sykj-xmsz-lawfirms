package com.jt.lawfirm.mapper.finance.sqlProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyBudget;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;

public class InoutSqlProvider {
	
	/**
	  * 我的收支页面查询SQL
	 * @param myBudget
	 * @return
	 */
			 
	public String selectInoutOfSive(MyBudget myBudget) {
		return new SQL() {
			{	
				System.out.println(myBudget);
				SELECT("*");
				FROM("(select ci.* , cit.cw_name cwInoutTypeName, cit.cw_pid from cw_inout ci "
						+ "inner join cw_inout_type cit on cit.id = ci.cw_inout_type_id "
						+ " where ci.cw_inout_person = #{hrEmpId} ) a");
				LEFT_OUTER_JOIN("(select cl.case_propernum caseUmber,cl.id cid, cct.type_pid, cl.case_case_type_id from case_law cl "
						+ "inner join case_case_type cct on cct.id = cl.case_case_type_id) b on b.cid = a.case_law_id");
				if (!myBudget.getCaseId().trim().equals("")) WHERE("b.caseUmber like" + "'%" + myBudget.getCaseId() + "%'");
				if (!myBudget.getcType().equals("-1")) WHERE("(b.case_case_type_id = #{cType} or b.type_pid = #{cType})");
				if (!myBudget.getInType().equals("-1")) WHERE("(a.cw_inout_type_id = #{inType} or a.cw_pid = #{inType})") ;
				if (!myBudget.getPayment().equals("-1")) WHERE("a.cw_pay_type = #{payment} ") ;
				if (!myBudget.getStartTime().trim().equals("")) WHERE("a.cw_inout_date >= #{startTime}");
				if (!myBudget.getEndTime().trim().equals("")) WHERE("a.cw_inout_date <= #{endTime}");
				ORDER_BY("a.cw_enteringdate desc");
			}
		}.toString();
	}
	
	public String selectIncomeOfSive(MyIncomeOfSive myIncome) {
		return new SQL() {
			{
				SELECT("*");
				FROM("(select ci.cw_inout_date, he.emp_name caseLawyer," + 
						" ci.cw_inout_money,ci.cw_pay_type,ci.cw_remark, ci.case_law_id"
						+ " from cw_inout ci inner join cw_inout_type cit on cit.id = ci.cw_inout_type_id "
						+ "inner join hr_emp he on he.id = ci.cw_inout_person "
						+ "where (cit.id = 1001 or cit.cw_pid = 1001 or cit.cw_pid = 100103)) a ");
				LEFT_OUTER_JOIN("(select id cid ,case_propernum caseUmber, case_parties caseParties, "
						+ "case_opposite_parties caseOppositeParties, case_plan casePlan from"
						+ " case_law) b on b.cid = a.case_law_id");
				if (myIncome.getStartTime() != null) WHERE("a.cw_inout_date >= #{startTime}");
				if (myIncome.getEndTime() != null) WHERE("a.cw_inout_date <= #{endTime}");
			}
		}.toString();
	}
	
	public String selectReserved(MyIncomeOfSive myIncome) {
		return new SQL() {
			{
				SELECT("a.caseLawyer, a.case_law_id, b.*, sum(a.cw_inout_money) sumMoney ");
				FROM("(select he.emp_name caseLawyer,ci.case_law_id ,ci.cw_inout_money, ci.cw_inout_date from cw_inout ci " + 
						"INNER JOIN cw_inout_type cit ON cit.id = ci.cw_inout_type_id " + 
						"INNER JOIN hr_emp he ON he.id = ci.cw_inout_person where (cit.id = 1001 OR cit.cw_pid = 1001 or cit.cw_pid = 100103) " + 
						") a ");
				LEFT_OUTER_JOIN("(select id, case_propernum caseUmber, case_plan, case_parties caseParties," + 
						"case_opposite_parties caseOppositeParties from case_law) b on b.id = a.case_law_id");
				WHERE("(b.case_plan = 'C' or a.case_law_id is null)");
				if (myIncome.getStartTime() != null) WHERE("a.cw_inout_date >= #{startTime}");
				if (myIncome.getEndTime() != null) WHERE("a.cw_inout_date <= #{endTime}");
				GROUP_BY("a.case_law_id, a.caseLawyer");
			}
		}.toString();
	}
	
	public String selectCommission(MyIncomeOfSive myIncome) {
		return new SQL() {
			{
				SELECT("cl.case_propernum caseUmber,cl.case_parties caseParties, cl.case_opposite_parties caseOppositeParties,"
						+ " he.emp_name caseLawyer,sum(ci.cw_inout_money) sumMoney,ci.case_law_id");
				FROM("cw_inout ci");
				INNER_JOIN("cw_inout_type cit on cit.id = ci.cw_inout_type_id");
				INNER_JOIN("case_law cl on cl.id = ci.case_law_id");
				INNER_JOIN("hr_emp he on he.id = cl.case_attorney_id");
				WHERE("(cit.id = 1001 or cit.cw_pid = 1001) and cl.case_plan = 'C'");
				if (myIncome.getStartTime() != null) WHERE("ci.cw_inout_date >= #{startTime}");
				if (myIncome.getEndTime() != null) WHERE("ci.cw_inout_date <= #{endTime}");
				GROUP_BY("ci.case_law_id");
			}
		}.toString();
	}
	
	public String insertInout(Map<String, String> map) {
		return new SQL() {
			{	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				INSERT_INTO("cw_inout");
				VALUES("cw_inout_type_id", map.get("inoutType"));
				VALUES("cw_inout_date",  "'" + map.get("getTime")  + "'");
				VALUES("cw_inout_person", "'" + map.get("id") + "'");
				VALUES("cw_inout_money", map.get("getMoney"));
				VALUES("cw_pay_type",  "'" + map.get("payType")  + "'");
				VALUES("case_law_id", map.get("lawId"));
				VALUES("cw_enteringdate",  "'" + sdf.format(new Date())  + "'");
				if(map.get("desc") != null) VALUES("cw_remark",  "'" + map.get("desc")  + "'");
				if(map.get("payProper") != null) VALUES("cw_payer",  "'" + map.get("payProper")  + "'");
			}
		}.toString();
	}
	
	public String insertInoutOneRow(Map<String, String> map) {
		return new SQL() {
			{	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				INSERT_INTO("cw_inout");
				VALUES("cw_inout_type_id", map.get("inType"));
				VALUES("cw_inout_date",  "'" + map.get("getTime")  + "'");
				VALUES("cw_inout_person", "'" + map.get("properId") + "'");
				VALUES("cw_inout_money", map.get("getmoney"));
				VALUES("cw_pay_type",  "'" + map.get("payType")  + "'");
				VALUES("cw_enteringdate",  "'" + sdf.format(new Date())  + "'");
				if(map.get("desc") != null) VALUES("cw_remark",  "'" + map.get("desc")  + "'");
				if(map.get("payProper") != null) VALUES("cw_payer",  "'" + map.get("moneyProper")  + "'");
			}
		}.toString();
	}
	
	public String selectIncomeOfSivePlus(MyStatisticsOfSive my) {
		return new SQL() {
			{
				SELECT("*");
				FROM("(select ci.cw_inout_date, he.emp_name caseLawyer, ci.cw_inout_person," + 
						" ci.cw_inout_money,ci.cw_pay_type,ci.cw_remark, ci.case_law_id"
						+ " from cw_inout ci inner join cw_inout_type cit on cit.id = ci.cw_inout_type_id "
						+ "inner join hr_emp he on he.id = ci.cw_inout_person "
						+ "where (cit.id = 1001 or cit.cw_pid = 1001 or cit.cw_pid = 100103)) a ");
				LEFT_OUTER_JOIN("(select id cid ,case_propernum caseUmber, case_parties caseParties, "
						+ "case_opposite_parties caseOppositeParties, case_plan casePlan from"
						+ " case_law) b on b.cid = a.case_law_id");
				if (my.getStartTime() != null) WHERE("a.cw_inout_date >= #{startTime}");
				if (my.getId() != null) WHERE("a.cw_inout_person = #{id}");
				if (my.getEndTime() != null) WHERE("a.cw_inout_date <= #{endTime}");
			}
		}.toString();
	}
	
	public String selectReservedPlus(MyStatisticsOfSive my) {
		return new SQL() {
			{
				SELECT("a.caseLawyer, a.case_law_id, b.*, sum(a.cw_inout_money) sumMoney ");
				FROM("(select he.emp_name caseLawyer,ci.case_law_id ,ci.cw_inout_money, ci.cw_inout_person, ci.cw_inout_date from cw_inout ci " + 
						"INNER JOIN cw_inout_type cit ON cit.id = ci.cw_inout_type_id " + 
						"INNER JOIN hr_emp he ON he.id = ci.cw_inout_person where (cit.id = 1001 OR cit.cw_pid = 1001 or cit.cw_pid = 100103) " + 
						") a ");
				LEFT_OUTER_JOIN("(select id, case_propernum caseUmber, case_plan, case_parties caseParties," + 
						"case_opposite_parties caseOppositeParties from case_law) b on b.id = a.case_law_id");
				WHERE("(b.case_plan = 'C' or a.case_law_id is null)");
				if (my.getStartTime() != null) WHERE("a.cw_inout_date >= #{startTime}");
				if (my.getId() != null) WHERE("a.cw_inout_person = #{id}");
				if (my.getEndTime() != null) WHERE("a.cw_inout_date <= #{endTime}");
				GROUP_BY("a.case_law_id, a.caseLawyer");
			}
		}.toString();
	}
	
	public String selectCommissionPlus(MyStatisticsOfSive my) {
		return new SQL() {
			{
				SELECT("cl.case_propernum caseUmber,cl.case_parties caseParties, cl.case_opposite_parties caseOppositeParties,"
						+ " he.emp_name caseLawyer,sum(ci.cw_inout_money) sumMoney,ci.case_law_id");
				FROM("cw_inout ci");
				INNER_JOIN("cw_inout_type cit on cit.id = ci.cw_inout_type_id");
				INNER_JOIN("case_law cl on cl.id = ci.case_law_id");
				INNER_JOIN("hr_emp he on he.id = cl.case_attorney_id");
				WHERE("(cit.id = 1001 or cit.cw_pid = 1001) and cl.case_plan = 'C'");
				if (my.getStartTime() != null) WHERE("ci.cw_inout_date >= #{startTime}");
				if (my.getId() != null) WHERE("ci.cw_inout_person = #{id}");
				if (my.getEndTime() != null) WHERE("ci.cw_inout_date <= #{endTime}");
				GROUP_BY("ci.case_law_id");
			}
		}.toString();
	}
	
}
