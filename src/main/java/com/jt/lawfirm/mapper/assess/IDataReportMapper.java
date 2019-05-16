package com.jt.lawfirm.mapper.assess;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface IDataReportMapper {
	@Select("<script>"
			+ "select * from case_law cl left join client c on cl.client_id = c.id"
			+" left join case_case_type cct on cl.case_case_type_id = cct.id"
			+" left join case_settle cs on cs.law_id = cl.id"
			+" left join hr_emp  he on c.hr_emp_id = he.id"
			+ "<where>"
			+ "<if  test='casePropernum!=null and casePropernum!= &apos;&apos;'>"
			+ "and case_propernum like #{casePropernum}"
			+ "</if>"
			+ "<if test='caseSubmitter!=null and caseSubmitter!= &apos;&apos;'>"
			+ "and case_submitter like #{caseSubmitter}"
			+ "</if>"
			+"<if test='caseApproveStatus!=null and caseApproveStatus!= &apos;&apos;'>"
			+ "and case_approve_status = #{caseApproveStatus}"
			+"</if>"
			+"<if test='caseTypeId!=null and caseTypeId!= &apos;&apos;'>"
			+ "and applyfor_using_the_item = #{caseTypeId} "
			+"</if>"
			+"<if test='EndcaseSubtime!=null and EndcaseSubtime!= &apos;&apos;'>"
			+ "and applyfor_receive &lt;=#{EndcaseSubtime}"
			+"</if>"
			+"<if test='StartcaseSubtime!=null and StartcaseSubtime!= &apos;&apos;'>"
			+"and applyfor_receive &gt;= #{StartcaseSubtime}"
			+"</if>"
			+ "</where>"
			+ "</script>")
	List<Map<String, Object>> SelectAll(Map<String, Object> finMap);

}
