package com.jt.lawfirm.mapper.hr;
/*
 * 
 * @author代国繁
 * */
import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.myhrbean.Myempident;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrIdentSqlProvider;

public interface IHrIdentMapper extends BaseMapper<HrIdent>{

	@SelectProvider(type=HrIdentSqlProvider.class,method="selectIdent")
	List<HrIdent> selectIdent(Myempident myempident);
	
}
