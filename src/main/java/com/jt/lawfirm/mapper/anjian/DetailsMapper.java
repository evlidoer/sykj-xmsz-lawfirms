package com.jt.lawfirm.mapper.anjian;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface DetailsMapper {
	

	
	List<Map<String, Object>> findDetailsLaw(Map<String, Object> map);
	
}
