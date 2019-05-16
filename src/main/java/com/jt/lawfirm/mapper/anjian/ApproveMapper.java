package com.jt.lawfirm.mapper.anjian;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ApproveMapper {

	@Select("select * from act_re_deployment d inner join act_ge_bytearray  b on d.ID_ = b.DEPLOYMENT_ID_")
	List<Map<String, Object>> approveShow();
	
	
	
}
