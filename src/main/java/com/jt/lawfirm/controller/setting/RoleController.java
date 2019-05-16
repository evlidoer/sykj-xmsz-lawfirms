/**
 * 2019年5月7日上午9:52:59
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.controller.setting;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.system.Role;
import com.jt.lawfirm.bean.system.System_Role_Permission;
import com.jt.lawfirm.service.role.RoleService;

/**
 * 2019年5月7日上午9:52:59
 * @author 许威
 * @Desc 
 */
@Controller
public class RoleController {
	@Resource(name = "RoleService")
	private RoleService roleService;
	/**
	 * 	去角色 User页面
	 * 2019年5月5日下午7:51:23
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/roles")
	public String rolePage() {
		return "settingView/Role";
	}
	
	
	
	
	
	
	
	/**
	 * 	所有角色查询
	 * 2019年5月7日上午9:57:45
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/roles/sel/all")
	public @ResponseBody PageBean roleSelall(int offset ,int limit,HttpServletRequest request) {
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title+"%");
		}
		/**
		 * 	先传入 limit 再传入 offset
		 */
		PageBean pageBean = new PageBean();
		pageBean.setLimit(limit);
		pageBean.setOffset(offset);
		
		/**
		 * 	将该 pageBean 放入map 
		 */
		map.put("pageBean", pageBean);
		/**
		 * 	传入 service ,让service操作传过去的map里边的pageBean里边的List<?> , 不需要返回值,只需service层setRows()值
		 */
		roleService.findRoleall(map);
		return pageBean;
	}
	
	/**
	 *	去权限分配页面
	 * 2019年5月7日下午5:58:15
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/fenpwi")
	public String FenPwiPage() {
		return "settingView/FenPei";
	}
	
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/roles/sel")
	@ResponseBody
	public List<Role> selrole() {
		return roleService.findRole();
	}
	
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("sel/role/permissons/{id}")
	@ResponseBody
	public Role sel_role_permissons(@PathVariable("id") int id) {
		Role role = roleService.findRoleById(id);
		System.out.println("role : "+role);
		return role;
	}
	
	/**
	 * 	修改权限
	 * 2019年5月11日下午3:12:40
	 * @User 许威
	 * @Desc 
	 * @param request
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping(value = "role/permissons/modyfyPer",method = RequestMethod.POST)
	@ResponseBody
	public Boolean sel_role_permissons_upd(HttpServletRequest request) {
		List<System_Role_Permission> list = new ArrayList<System_Role_Permission>();
		int parseInt = Integer.parseInt(request.getParameter("id"));
		String[] split = request.getParameter("permission").split(",");
		for (String string : split) {
			System.out.println(string);
			if (!string.equals("") && Integer.parseInt(string) > 1000)
				list.add(new System_Role_Permission(parseInt,Integer.parseInt(string)));
		}
		boolean bo = roleService.modyfi_role_permission_by_id(list);
		return bo;
	}
	
	
	/**
	 * 	去添加角色页面
	 * 2019年5月11日下午3:23:26
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/addRole")
	public String addRole() {
		return "settingView/addRole";
	}
	
	/**
	 * 	添加交色
	 * 2019年5月11日下午3:12:27
	 * @User 许威
	 * @Desc 
	 * @param request
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping(value = "role/permissons/addRole",method = RequestMethod.POST)
	@ResponseBody
	public Boolean addRole(HttpServletRequest request) {
		boolean bo = roleService.addRole(request.getParameter("rname"),request.getParameter("remark"),request.getParameter("permission"));
		return bo;
	}
	
	
	/**
	 * 	删除角色
	 * 2019年5月11日下午3:45:13
	 * @User 许威
	 * @Desc 
	 * @param request
	 * @return
	 */
	@RequiresPermissions(value = {"setting:roles","admin","test"},logical = Logical.OR)
	@RequestMapping(value = "role/permissons/removerole/{id}",method = RequestMethod.POST)
	@ResponseBody
	public Boolean delRole(@PathVariable("id") int id) {
		boolean bo = roleService.removerole(id);
		return bo;
	}
}
