/**
 * 2019年5月3日下午5:14:13
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.mapper.role;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.system.Role;
import com.jt.lawfirm.bean.system.System_Role_Permission;

/**
 * 2019年5月3日下午5:14:13
 * @author 许威
 * @Desc 
 */
public interface RoleMapper {
	/**
	 * 2019年5月3日下午6:22:05
	 * @User 许威
	 * @Desc 
	 * @param username
	 * @return
	 */
	Set<String> selRoleByUserId(String user_name);

	/**
	 * 2019年5月6日下午5:44:23
	 * @User 许威
	 * @Desc 
	 * @param string
	 * @return
	 */
	@Select("select p.authority_desc from system_user u" + 
			"	inner join system_user_role ur on u.id = ur.user_id " + 
			"	inner join system_role_permission rp on rp.role_id = ur.id " + 
			"	left join system_permission p on p.id = rp.permission_id where u.user_name = #{user_name}")
	Set<String> selPermissionByUserId(String user_name);

	/**
	 * 2019年5月7日上午10:10:15
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	List<Role> selRoleAll(Map<String, Object> map);

	/**
	 * 2019年5月9日下午4:58:47
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@Select("select * from system_role")
	List<Role> selRole();

	/**
	 * 2019年5月11日上午8:39:05
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select * from  system_role where id = #{id}")
	Role selRoleById(int id);

	/**
	 * 2019年5月11日上午8:55:40
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select system_permission.id from system_role_permission" + 
			"	inner join system_role on system_role.id = system_role_permission.role_id " + 
			"	inner join system_permission on system_permission.id = system_role_permission.permission_id " + 
			" 	where system_role.id = #{id}"	
			)
	List<Integer> selPermissionByRleId(Integer id);

	/**
	 * 2019年5月11日上午11:28:13
	 * @User 许威
	 * @Desc 
	 * @param role
	 */
	@Delete("delete from system_role_permission where role_id = #{id}")
	void del_role_permission_by_id(int id);

	/**
	 * 2019年5月11日上午11:37:44
	 * @User 许威
	 * @Desc 
	 * @param list
	 */
	void upd_role_permission_by_id(List<System_Role_Permission> list);

	/**
	 * 2019年5月11日下午3:18:56
	 * @User 许威
	 * @Desc 
	 * @param rname
	 * @param remark
	 */
	@Insert("INSERT INTO system_role (id,rname,remark) VALUES (null,#{rname},#{remark})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void insertRole(Role roel);

	/**
	 * 2019年5月11日下午3:51:38
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Select("select COUNT(*) from system_user_role where role_id = #{id}")
	int sel_Role_byID(int id);

	/**
	 * 2019年5月11日下午3:55:43
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	@Delete("delete from system_role where id = #{id}")
	void delRole(int id);

	/**
	 * 2019年5月12日上午12:02:43
	 * @User 许威
	 * @Desc 
	 * @param rname
	 * @return
	 */
	@Select("select COUNT(*) from system_role where rname = #{rname}")
	int selRoleVyName(String rname);
}
