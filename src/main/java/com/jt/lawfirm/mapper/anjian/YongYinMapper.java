package com.jt.lawfirm.mapper.anjian;

import org.apache.ibatis.annotations.Delete;

public interface YongYinMapper {
	
	@Delete("delete from case_seal_applyfor where id = #{id}")
	boolean delCaseSealApplyfor(Integer id);
	
}
