package com.jt.lawfirm.mapper.casea;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.casea.CaseLawtype;
import com.jt.lawfirm.bean.casea.Law;
//王立冬
public interface ILwaApprovalMapper {
	
	@Select("<script>"
			+ "select * from case_law cl inner join case_case_type ct on cl.case_case_type_id = ct.id"
			+" inner join client c on cl.client_id = c.id" 
			+" inner join hr_emp he on c.empid = he.id" 
			+" inner join system_user su on su.hr_emp_id = he.id"
			+ "<where>"
			+ "<if  test='casePropernum!=null and casePropernum!= &apos;&apos;'>"
			+ " and case_propernum like #{casePropernum}"
			+ "</if>"
			+ "<if test='caseSubmitter!=null and caseSubmitter!= &apos;&apos;'>"
			+ "and case_submitter like #{caseSubmitter}"
			+ "</if>"
			+"<if test='caseApproveStatus!=null and caseApproveStatus!= &apos;&apos;'>"
			+ "and case_approve_status = #{caseApproveStatus}"
			+"</if>"
			+"<if test='caseTypeId!=null and caseTypeId!= &apos;&apos;'>"
			+ " and case_case_type_id = #{caseTypeId} "
			+"</if>"
			+"<if test='EndcaseSubtime!=null and EndcaseSubtime!= &apos;&apos;'>"
			+ "and case_subtime &lt;=#{EndcaseSubtime}"
			+"</if>"
			+"<if test='StartcaseSubtime!=null and StartcaseSubtime!= &apos;&apos;'>"
			+"and case_subtime &gt;= #{StartcaseSubtime}"
			+"</if>"
			+ "</where>"
			+ "</script>")//查询所有,收案申请
	public List<Map<String,Object>> SelectAll(Map<String,Object> map);
	
	@Select("select * from case_law cl inner join client c on cl.client_id = c.id  inner join hr_emp he on c.empid = he.id where cl.id = #{id}")
	public List<Map<String,Object>> SelectById(Integer id);
	
	@Update("update case_law set case_opposite_parties=#{caseoppositeparties},case_subtime= #{caseSubtime} where id=#{id}")
	int updatelaw(Law law);
	
	@Select("select * from case_case_type where type_pid is null")
	public List<CaseLawtype> SelectLawtype();
}
