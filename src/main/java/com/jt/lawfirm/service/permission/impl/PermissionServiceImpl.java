/**
 * 2019年5月2日下午8:33:03
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.permission.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.system.Permission;
import com.jt.lawfirm.mapper.permission.PermissionMapper;
import com.jt.lawfirm.service.permission.PermissionService;

/**
 * 2019年5月2日下午8:33:03
 * @author 许威
 * @Desc 
 */
@Service(value = "PermissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	/**
	 * 2019年5月2日下午8:33:03
	 * @author 许威
	 * @Desc 
	 * @return
	 */
	@Override
	public List<Permission> findPermission() {
		return permissionMapper.selPermissionAll();
	}

}
