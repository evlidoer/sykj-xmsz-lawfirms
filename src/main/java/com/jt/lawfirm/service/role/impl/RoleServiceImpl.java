/**
 * 2019年5月3日下午5:12:13
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.role.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.system.Role;
import com.jt.lawfirm.bean.system.System_Role_Permission;
import com.jt.lawfirm.mapper.role.RoleMapper;
import com.jt.lawfirm.service.role.RoleService;

/**
 * 2019年5月3日下午5:12:13
 * @author 许威
 * @Desc 
 */
@Service(value = "RoleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 2019年5月3日下午6:22:58
	 * @author 许威
	 * @Desc 
	 * @param string
	 * @return
	 */
	@Override
	public Set<String> findRoleByUserId(String string) {
		return roleMapper.selRoleByUserId(string);
	}

	@Override
	public Set<String> findPermissionByUserId(String string) {
		return roleMapper.selPermissionByUserId(string);
	}

	/**
	 * 2019年5月7日上午10:07:12
	 * @author 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	@Override
	public List<?> findRoleall(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Role> selectList = new ArrayList<Role>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = roleMapper.selRoleAll(map);
		}else {
			selectList = roleMapper.selRoleAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.out.println(pageBean.getRows().toString());
		return null;
	}

	/**
	 * 2019年5月9日下午4:58:30
	 * @author 许威
	 * @Desc 
	 * @return
	 */
	@Override
	public List<Role> findRole() {
		return roleMapper.selRole();
	}

	/**
	 * 2019年5月11日上午8:37:22
	 * @author 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Override
	public Role findRoleById(int id) {
		Role role = roleMapper.selRoleById(id);
		role.setPermission(roleMapper.selPermissionByRleId(role.getId()));
		return role;
	}

	/**
	 * 2019年5月11日下午2:25:26
	 * @author 许威
	 * @Desc 
	 * @param list
	 * @return
	 */
	@Override
	public boolean modyfi_role_permission_by_id(List<System_Role_Permission> list) {
		try {
			/**
			 *  	删除权限
			 */
			roleMapper.del_role_permission_by_id(list.get(0).getRoleId());
			/**
			 * 	添加权限
			 */
			roleMapper.upd_role_permission_by_id(list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();//打印错误信息
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动回滚失误
		}
		return false;
	}

	/**
	 * 2019年5月11日下午3:15:29
	 * @author 许威
	 * @Desc 
	 * @param rname
	 * @param parameter2
	 * @param parameter3
	 * @return
	 */
	@Override
	public boolean addRole(String rname, String remark, String permissions) {
		try {
			/**
			 * 先根据角色查询,是否重复
			 */
			int i =	roleMapper.selRoleVyName(rname);
			if (i > 0)
				return false;
			/**
			 * 	添加角色
			 */
			Role roel = new Role();
			roel.setRname(rname);
			roel.setRemark(remark);
			roleMapper.insertRole(roel);
			System.out.println("insertRole"+ roel.getId());

			/**
			 *	为该交色添加权限
			 */
			List<System_Role_Permission> list = new ArrayList<System_Role_Permission>();
			String[] split = permissions.split(",");
			for (String string : split) {
				System.out.println(string);
				if (!string.equals("") && Integer.parseInt(string) > 1000)
					list.add(new System_Role_Permission(roel.getId(),Integer.parseInt(string)));
			}
			roleMapper.upd_role_permission_by_id(list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();//打印错误信息
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动回滚失误
		}
		return false;

	}

	/**
	 * 2019年5月11日下午3:47:48
	 * @author 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Override
	public boolean removerole(int id) {
		try {
			/**
			 * 	先查询,使用中则不可以删除
			 */
			int i = roleMapper.sel_Role_byID(id);
			if (i > 0) {
				return false;
			}
			/**
			 * 	成功后先清空该角色对应的权限
			 */
			roleMapper.del_role_permission_by_id(id);
			/**
			 * 	在执行删除角色
			 */
			roleMapper.delRole(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();//打印错误信息
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动回滚失误
		}
		return false;
	}

}
