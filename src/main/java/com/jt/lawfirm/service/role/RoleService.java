/**
 * 2019年5月3日下午5:11:32
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.role;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jt.lawfirm.bean.system.Role;
import com.jt.lawfirm.bean.system.System_Role_Permission;

/**
 * 2019年5月3日下午5:11:32
 * @author 许威
 * @Desc 
 */
public interface RoleService {
	/**
	 * 2019年5月3日下午6:21:25
	 * @User 许威
	 * @Desc 
	 * @param string
	 */
	Set<String> findRoleByUserId(String string);
	Set<String> findPermissionByUserId(String string);
	/**
	 * 2019年5月7日上午10:06:54
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	List<?> findRoleall(Map<String, Object> map);
	/**
	 * 2019年5月9日下午4:58:06
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	List<Role> findRole();
	/**
	 * 2019年5月11日上午8:36:56
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	Role findRoleById(int id);
	/**
	 * 2019年5月11日上午11:25:03
	 * @User 许威
	 * @Desc 
	 * @param list
	 * @return
	 */
	boolean modyfi_role_permission_by_id(List<System_Role_Permission> list);
	/**
	 * 2019年5月11日下午3:15:12
	 * @User 许威
	 * @Desc 
	 * @param parameter
	 * @param parameter2
	 * @param parameter3
	 * @return
	 */
	boolean addRole(String rname, String parameter2, String parameter3);
	/**
	 * 2019年5月11日下午3:46:28
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	boolean removerole(int id);
}
