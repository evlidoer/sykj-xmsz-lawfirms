package com.jt.lawfirm.mapper.shouye;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.shouye.Calendar;

public interface IShouyeMapper {
	
	@Select("select count(*) from case_law where case_approve_status ='N'")
	int approvalquantity();
	@Select("select count(*) from case_law")
	int officequantity();
	@Select("select count(*) from case_law where case_settle_status ='Y'")
	int settlequantity();
	
	@Select("select * from case_law where case_unpaidsal !=0 limit 3")
	List<Map<String, Object>> FindLaw();
	
	@Select("select * from adm_notice ORDER BY id desc limit 1")
	List<Map<String, Object>> Findnotice();
	
	@Insert("insert into calendar values(null,#{calendartype},#{worktype},#{eventname},#{starttime},#{endtime},#{law_id},#{describe},#{place},#{publicstatus},#{filepath})")
	int insertcalendr(Calendar calendr);

	

}
