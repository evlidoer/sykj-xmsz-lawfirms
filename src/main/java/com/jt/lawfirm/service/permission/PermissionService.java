/**
 * 2019年5月2日下午7:56:51
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.permission;

import java.util.List;

import com.jt.lawfirm.bean.system.Permission;

/**
 * 2019年5月2日下午7:56:51
 * @author 许威
 * @Desc 
 */
public interface PermissionService {

	/**
	 * 2019年5月2日下午8:03:32
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	List<Permission> findPermission();

}
