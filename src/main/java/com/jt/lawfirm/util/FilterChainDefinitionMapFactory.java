/**
 * 2019年5月2日下午7:38:33
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jt.lawfirm.bean.system.Permission;
import com.jt.lawfirm.service.permission.PermissionService;

/**
 * 2019年5月2日下午7:38:33
 * @author 许威
 * @Desc 
 */
public class FilterChainDefinitionMapFactory {
	@Resource(name = "PermissionService")
	private  PermissionService permissionSrvice;
	
	public  Map<String , String> findPermissionMap() {
		/**
		 * 有序的集合,方便存储,拦截从上往下拦截,所以必须时有序的集合
		 */
		Map<String , String> permissionMap = new LinkedHashMap<String, String>();
		List<Permission> list  = permissionSrvice.findPermission();
		for (Permission permission : list) {
			System.out.println(permission.getAuthorityPath()+"="+permission.getAuthorityMode());
			permissionMap.put(permission.getAuthorityPath(),permission.getAuthorityMode());
		}
		return permissionMap;
	}
}
