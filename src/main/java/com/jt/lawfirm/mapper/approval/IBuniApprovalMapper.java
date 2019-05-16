package com.jt.lawfirm.mapper.approval;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface IBuniApprovalMapper {
	
	@Select("<script>"
			+ "select * from case_cost_relief cd inner join case_law cl on cd.case_law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id "
			+ "<where>"
			+ "<if  test='casePropernum!=null and casePropernum!= &apos;&apos;'>"
			+ "and case_propernum like #{casePropernum}"
			+ "</if>"
			+"<if test='caseApproveStatus!=null and caseApproveStatus!= &apos;&apos;'>"
			+ "and relief_approval_status = #{caseApproveStatus}"
			+"</if>"
			+"<if test='EndcaseSubtime!=null and EndcaseSubtime!= &apos;&apos;'>"
			+ "and relief_application_date &lt;=#{EndcaseSubtime}"
			+"</if>"
			+"<if test='StartcaseSubtime!=null and StartcaseSubtime!= &apos;&apos;'>"
			+"and relief_application_date &gt;= #{StartcaseSubtime}"
			+"</if>"
			+ "</where>"
			+ "</script>")
	List<Map<String, Object>> FindBuni(Map<String, Object> map);
	
	@Select("<script>"
			+ "select * from case_settle cd inner join case_law cl on cd.law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id "
			+ "<where>"
			+ "<if  test='casePropernum!=null and casePropernum!= &apos;&apos;'>"
			+ "and case_propernum like #{casePropernum}"
			+ "</if>"
			+"<if test='caseApproveStatus!=null and caseApproveStatus!= &apos;&apos;'>"
			+ "and status = #{caseApproveStatus}"
			+"</if>"
			+"<if test='EndcaseSubtime!=null and EndcaseSubtime!= &apos;&apos;'>"
			+ "and settletime &lt;=#{EndcaseSubtime}"
			+"</if>"
			+"<if test='StartcaseSubtime!=null and StartcaseSubtime!= &apos;&apos;'>"
			+"and settletime &gt;= #{StartcaseSubtime}"
			+"</if>"
			+ "</where>"
			+ "</script>")
	List<Map<String, Object>> FindSettle(Map<String, Object> map);

	@Select("<script>"
			+ "select * from case_refund cd inner join case_law cl on cd.law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id "
			+ "<where>"
			+ "<if  test='casePropernum!=null and casePropernum!= &apos;&apos;'>"
			+ "and case_propernum like #{casePropernum}"
			+ "</if>"
			+"<if test='caseApproveStatus!=null and caseApproveStatus!= &apos;&apos;'>"
			+ "and case_refund_status = #{caseApproveStatus}"
			+"</if>"
			+"<if test='EndcaseSubtime!=null and EndcaseSubtime!= &apos;&apos;'>"
			+ "and case_refundtime &lt;=#{EndcaseSubtime}"
			+"</if>"
			+"<if test='StartcaseSubtime!=null and StartcaseSubtime!= &apos;&apos;'>"
			+"and case_refundtime &gt;= #{StartcaseSubtime}"
			+"</if>"
			+ "</where>"
			+ "</script>")
	List<Map<String, Object>> FindRefund(Map<String, Object> map);
	
	@Select("select * from case_cost_relief cd inner join case_law cl on cd.case_law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id  where cd.id = #{id}")
	List<Map<String, Object>> FinreliefSelById(Integer id);
	
	@Select("select * from case_settle cd inner join case_law cl on cd.law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id  where cd.id = #{id}")
	List<Map<String, Object>> FindSettleById(Integer id);

	@Select("select * from case_refund cd inner join case_law cl on cd.law_id = cl.id "
			+"inner join client c on cl.client_id = c.id "
			+"inner join hr_emp he on c.empid = he.id "
			+"inner join system_user su on su.hr_emp_id = he.id  where cd.id = #{id}")
	List<Map<String, Object>> FindRefundById(Integer id);
	
	@Select("select id from record where law_case_id = #{id}")
	String record(Integer id);
	
}
