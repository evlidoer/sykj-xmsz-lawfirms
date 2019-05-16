package com.jt.lawfirm.mapper.administration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.administration.Expressage;

public interface IExpressageMapper extends BaseMapper<Expressage>{

	List<Map<String, Object>> selExpressageAll(Map<String, Object> map);

	List<Map<String, Object>> selselUserAll(Map<String, Object> map);

	void deleteExpressageById(int id);

	/*
	 * @Select("select * from case_law inner join hr_emp on case_law.case_attorney_id = hr_emp.id"
	 * )
	 */
	List<Map<String,Object>> selLawAndEMp(Map<String, Object> map);

	Map<String, Object> selExpressageById(int id);

	List<Map<String,Object>> selkuaidi(Map<String, Object> map);

	List<Map<String, Object>> selkuaidiType(Map<String, Object> map);

	void insertAll(@Param("dataMap")HashMap<String,Object> dataMap);
	
	@Select("select * from system_user where system_user.id = #{id}")
	HashMap<String, Object> selEmpIDByUserId(Object id);

	/**
	 * 2019年4月26日下午3:43:44
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void updateAll(@Param("params")HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月26日下午7:21:02
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	@Delete("delete from kdmanager where kdmanager.id = #{id}")
	void delExpressageByID(int id);

	/**
	 * 2019年4月26日下午11:40:58
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	@Update("update kdmanager_gs set gs_name = #{name} where id = #{id}")
	void updExpressageCompany(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月26日下午11:41:11
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	@Update("update kdmanager_kd set kd_type = #{name} where id = #{id}")
	void updateExpressageCompanyType(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午12:31:24
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	@Insert("insert into kdmanager_gs values(null,#{name},'Y')")
	void updExpressageCompanyadd(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午12:31:30
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	@Insert("insert into kdmanager_kd values(null,#{name},'Y')")
	void updateExpressageCompanyTypeadd(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午1:14:11
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select * from kdmanager where kdtype = #{id}")
	List<Map<String,Object>> selByKDTypeID(int id);

	/**
	 * 2019年4月27日上午1:15:41
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select * from kdmanager where company = #{id}")
	List<Map<String,Object>> selByKDID(int id);

	/**
	 * 2019年4月27日上午1:22:35
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Delete("delete from kdmanager_kd where id = #{id}")
	boolean delCompanyType(int id);

	/**
	 * 2019年4月27日上午1:22:42
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Delete("delete from kdmanager_gs where id = #{id}")
	boolean delCompany(int id);

	/**
	 * 2019年4月27日下午4:58:22
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void addFAll(@Param("dataMap")HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日下午8:39:32
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selExpressageFAll(Map<String, Object> map);

	/**
	 * 2019年4月27日下午11:18:22
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return 
	 */
	@Delete("delete from kdmanager_f where id = #{id}")
	int delExpressageF(int id);

	/**
	 * 2019年4月28日上午12:13:48
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	HashMap<String, Object> selFbyid(int id);

	/**
	 * 2019年4月28日上午8:34:33
	 * @User 许威
	 * @Desc 
	 * @param hashMap
	 */
	void updF(@SuppressWarnings("rawtypes") @Param("params")HashMap hashMap);

	/**
	 * 2019年5月12日下午6:28:45
	 * @User 许威
	 * @Desc 
	 * @param username
	 */
	@Select("select id from system_user where user_name = #{username}")
	Integer selUserIdByName(String username);
}
