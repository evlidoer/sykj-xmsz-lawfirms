package com.jt.lawfirm.mapper.hr;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

/*
 * 
 * @author代国繁
 * */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.hr.HrDegree;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrDegreeSqlProvider;

public interface IHrDegreeMapper extends BaseMapper<HrDegree>{

	@SelectProvider(type=HrDegreeSqlProvider.class,method="selectdegreebyid")
	List<HrDegree> selectdegreebyid(Map<String, Object> map);
	
}
