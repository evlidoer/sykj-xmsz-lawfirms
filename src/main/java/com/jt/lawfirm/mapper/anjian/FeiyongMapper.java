package com.jt.lawfirm.mapper.anjian;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface FeiyongMapper {
	
	//显示案件费用记录表
	   	//案件费用记录表与law 表关联模糊查***
	List<Map<String, Object>> feiyongShow(Map<String, Object> map);
	@Delete("delete from case_cost_relief where id=#{id}")
	boolean delfeiyong(Integer id);
	
	
}
