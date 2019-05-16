package com.jt.lawfirm.mapper.approval;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.casea.CaseApproval;

public interface ISealApprovalMapper {
	
	@Select("<script>"
			+ "select * from case_seal_applyfor csa left join case_law cl on csa.case_law_id = cl.id"
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
			+ "order by csa.id"
			+ "</script>")
	List<Map<String,Object>> FindAll(Map<String,Object> map);
	
	@Select("select * from case_seal_applyfor where case_law_id = #{id}")
	List<Map<String, Object>> FindSeal(Integer id);
	
	@Select("select * from case_law where id = #{id}")
	List<Map<String, Object>> FindLawById(Integer id);

	@Select("select * from case_seal_applyfor csa inner join record_file rf on csa.file_id = rf.id where case_law_id = #{id}")
	List<Map<String, Object>> FindSealLawById(Integer id);
	
	@Select("select * from hr_emp")
	List<Map<String, Object>> FindEmpById(Integer id);
	
	@Insert("insert into case_approval values(null,#{approvalDate},#{approvalStaus},#{systemRoleId},#{lawId},#{approvalText})")
	int AddApprove(CaseApproval lawApproval);
	@Update("update case_law set case_approve_status = #{approvalStaus} where id = #{lawId}")
	int modifyLaw(CaseApproval lawApproval);

	@Select("select count(*) from record  where law_case_id = #{id}")
	int recordnumber(Integer id);
	
	@Update("update case_seal_applyfor set applyfor_approval_status = #{applyfor_approval_status} where id = #{id}")
	int modifSeal(Map<String, Object> map);

	@Select("select * from case_seal_applyfor csa right join record_file rf on csa.file_id = rf.id "
			+"inner join case_law cl on csa.case_law_id = cl.id where case_law_id = #{id} ")
	List<Map<String, Object>> FindSealFileById(Integer id);
}
