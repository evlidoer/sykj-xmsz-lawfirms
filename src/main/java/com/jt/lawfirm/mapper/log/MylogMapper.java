package com.jt.lawfirm.mapper.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.log.Job;


@Mapper
public interface MylogMapper {
	public List<HashMap<String ,Object>> queryAll();
	
	public List<HashMap<String, Object>> queryAll(Map<String, Object> map);

	
	@Select("select  * "+
			"  FROM log_job "+
			" left JOIN log_type on log_job.logtype_id = log_type.id "+
			" left JOIN client on log_job.client_id = client.id "+
			" left JOIN case_law on case_law.id = log_job.case_law_id	"+
			" where log_job.id = #{id} ")
	public List<Map<String, Object>> selInfoById(Integer id);
	
	
	 
	@Delete("delete from log_job where id = #{id}")
	int dellogshow(Integer id);

	
	@Select("Select * from log_type")
	public List<Map<String, Object>> log_typeSel();
	
	public boolean uplog(Job job);

	


	
}
