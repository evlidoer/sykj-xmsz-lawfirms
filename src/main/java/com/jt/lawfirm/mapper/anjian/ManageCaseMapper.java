package com.jt.lawfirm.mapper.anjian;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ManageCaseMapper {
	
	//修改案号
	@Update("update case_law set case_propernum=#{NewCaseId} where id=#{id}")
	Integer upAnjianHao(Map<String, Object> map);
	//判断重复案号
	@Select("select case_propernum from case_law where case_propernum = #{CasePropernum}")
	String selCasePropernum(String CasePropernum);
	//设置档案号
	@Update("update case_law set case_filenumber=#{caseFilenumber} where id=#{id}")
	Integer setCaseFilenumber(Map<String, Object> map);
	//回收
	@Insert("insert into case_law_histroy select * from case_law where id = #{id}")
	Integer addLawHistroy(String id);
	//删除
	@Delete("delete from  case_law where id = #{id}")
	Integer DelLaw(String id);
	//显示回收
	@Select("select * from  case_law_histroy")
	List<Map<String, Object>> lawHistroy(String title);
}
