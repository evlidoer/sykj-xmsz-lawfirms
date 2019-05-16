/**
 * 2019年5月2日下午8:34:42
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.mapper.permission;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.system.Permission;

/**
 * 2019年5月2日下午8:34:42
 * @author 许威
 * @Desc 
 */
public interface PermissionMapper {

	/**
	 * 2019年5月2日下午8:35:22
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@Select("select * from system_permission")
	List<Permission> selPermissionAll();

}
