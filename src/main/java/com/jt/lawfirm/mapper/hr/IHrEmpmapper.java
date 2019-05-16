package com.jt.lawfirm.mapper.hr;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/*
 * 
 * @author代国繁
 * */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.bean.hr.HrInsured;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrEmpSqlProvider;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrIdentSqlProvider;
/**
 * @author 代
 * */
public interface IHrEmpmapper extends BaseMapper<HrEmp>{
	
	@InsertProvider(type=HrIdentSqlProvider.class,method="insertemp")
	boolean insertemp(Map<String, String> map);
	
	@SelectProvider(type=HrIdentSqlProvider.class,method="selectempid")
	List<String> selectempid();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectemp")
	List<Map<String, String>> selectemp();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectdegree")
	List<Map<String, String>> selectdegree();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectwork")
	List<Map<String, String>> selectwork();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectrew")
	List<Map<String, String>> selectrew();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectpun")
	List<Map<String, String>> selectpun();
	
	@SelectProvider(type=HrEmpSqlProvider.class,method="selectins")
	List<HrInsured> selectins(String id);
	
	@UpdateProvider(type=HrEmpSqlProvider.class,method="updatecb")
	boolean updatecb(Map<String, Object> map);
	
	@InsertProvider(type=HrEmpSqlProvider.class,method="insertcb")
	boolean insertcb(Map<String, Object> map);
}

