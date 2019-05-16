package com.jt.lawfirm.mapper.hr;
/**
 * @author 代
 * */
import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrIdentSqlProvider;

public interface IHrCaseTypeMapper extends BaseMapper<CaseType>{
	
	@SelectProvider(type=HrIdentSqlProvider.class,method="selectcase")
	List<String> selectcase(String casetypename);
}
