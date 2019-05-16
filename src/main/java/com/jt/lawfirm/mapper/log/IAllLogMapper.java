package com.jt.lawfirm.mapper.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.log.Job;

@Mapper
public interface IAllLogMapper {
	
	public List<HashMap<String, Object>> queryAll(Map<String, Object> map);

	public List<HashMap<String, Object>> queryAll();

	
	@Select("select  * "+
			"  FROM log_job "+
			" left JOIN log_type on log_job.logtype_id = log_type.id "+
			" left JOIN client on log_job.client_id = client.id "+
			" left JOIN case_law on case_law.id = log_job.case_law_id"+
			" where log_job.id = #{id} ")
	public Map<String, Object> selInfoById(int id);
	

}
