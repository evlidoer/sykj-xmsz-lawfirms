/**
 * 2019年5月5日下午8:09:30
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.mapper.setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.hr.HrEmp;

/**
 * 2019年5月5日下午8:09:30
 * @author 许威
 * @Desc 
 */
public interface SystemUsermapper {

	/**
	 * 2019年5月5日下午8:10:02
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 * 	用户角色查询,
	 */
	@Select("<script> \n"
			+ "select *,user_id userid from system_user_role \n" 
			+ " inner join system_user on system_user.id = system_user_role.user_id \n"
			+ "	inner join system_role on system_role.id = system_user_role.role_id where 1= 1 \n"
			+ " <if test = 'title != null'> and user_name like #{title} or user_realname like #{title} </if> \n"
			+ "</script>")
	List<HashMap<String, Object>> selSystemUserall(Map<String, Object> map);

	/**
	 * 2019年5月8日下午9:18:06
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select * from system_user_role "
			+ " inner join system_user on system_user.id = system_user_role.user_id"
			+ "	inner join system_role on system_role.id = system_user_role.role_id "
			+ "	left join hr_emp on system_user.hr_emp_id = hr_emp.id "
			+ "	where system_user.id = #{id}")
	Map<String, Object> userManagerSelByID(int id);

	/**
	 * 2019年5月12日上午10:52:59
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	@Select("<script> \n"
			+ "	select * from hr_emp where 1 = 1"
			+ " <if test = 'title != null'> and emp_name like #{title} or emp_phone like #{title} </if> \n"
			+ "</script>")
	List<HrEmp> selempAll(Map<String, Object> map);

	/**
	 * 2019年5月12日上午11:13:33
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	@Select("select COUNT(*) from system_user where user_name = #{user_name}")
	int selUserByid(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年5月12日上午11:18:20
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	int insertUser(@Param("dataMap")HashMap<String,Object> isNotEmptyKeyMap);

	/**
	 * 2019年5月12日上午11:24:43
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	@Select("select id from system_user where user_name = #{user_name}")
	int selUserIDByname(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年5月12日上午11:33:39
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	@Insert("insert into system_user_role values(null,#{id},#{role_id})")
	void addRole(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年5月12日下午12:45:02
	 * @User 许威
	 * @Desc 
	 * @param result
	 * @param format
	 */
	@Update("update system_user set user_pwd = #{result} ,user_createdate = #{format} where id = #{id}")
	void insertUserP(@Param("result")String result, @Param("format")String format,@Param("id")Integer id);

	/**
	 * 2019年5月12日下午1:26:27
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void upduser(@Param("params")HashMap<String, Object> isNotEmptyKeyMap);

}
