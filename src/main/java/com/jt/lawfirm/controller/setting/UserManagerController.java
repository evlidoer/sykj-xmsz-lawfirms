/**
 * 2019年5月5日下午7:34:36
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.controller.setting;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.setting.SystemUserService;
import com.jt.lawfirm.util.AutoConversion;

/**
 * 2019年5月5日下午7:34:36
 * @author 许威
 * @Desc 
 */
@Controller
public class UserManagerController {
	@Resource(name = "SystemUserService")
	private SystemUserService systemUserService;
	/**
	 *  	去用户UserManger页面 
	 * 2019年5月5日下午7:50:51
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager")
	public String userManager() {
		return "settingView/UserManger";
	}
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/selall")
	public @ResponseBody PageBean userManagerssss(int offset ,int limit,HttpServletRequest request) {
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("tle");
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
		systemUserService.findSystemUserAll(map);
		return pageBean;
	}


	/**
	 * 	查询页面
	 * 2019年5月8日下午9:13:24
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/selinfoById")
	public String selinfo() {
		return "settingView/InfoUserManger";
	}

	/**
	 *  修改页面
	 * 2019年5月8日下午9:13:36
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/upd")
	public String toupd() {
		return "settingView/updUserManger";
	}
	/**
	 * 	查看详情,以及修改之前的以id查询
	 * 2019年5月8日下午9:14:31
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/selByid/{id}")
	public @ResponseBody Map<String,Object> selByid(@PathVariable("id") int id) {
		Map<String,Object> map = systemUserService.userManagerSelByID(id);
		return map;
	}
	/**
	 * 	添加用户
	 * 2019年5月11日下午11:57:32
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/setting/userManager/toadd")
	public String toadd() {
		return "settingView/addUserManger";
	}


	/**
	 * 	添加用户时选择emp
	 * 2019年5月12日上午1:47:39
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/emp/show")
	public String showEmp() {
		return "settingView/new_emp";
	}

	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/emp/selall")
	public @ResponseBody PageBean selemp(int offset ,int limit,HttpServletRequest request) {
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("tle");
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
		systemUserService.findempAll(map);
		return pageBean;
	}
	/***
	 * 	添加user
	 * 2019年5月12日下午1:22:53
	 * @User 许威
	 * @Desc 
	 * @param request
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/user/adduser")
	public @ResponseBody String adduser(HttpServletRequest request) {
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		return systemUserService.addUser(isNotEmptyKeyMap);
	}


	/**
	 * 	修改user
	 * 2019年5月12日下午1:23:11
	 * @User 许威
	 * @Desc 
	 * @param request
	 * @return
	 */
	@RequiresPermissions(value = {"SettingManager:UserManager","admin","test"},logical = Logical.OR)
	@RequestMapping("setting/user/upduser")
	public @ResponseBody Boolean upduser(HttpServletRequest request) {
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		for (Object iterable_element : isNotEmptyKeyMap.keySet()) {
			System.out.println(iterable_element+":"+isNotEmptyKeyMap.get(iterable_element));
		}
		return systemUserService.upduser(isNotEmptyKeyMap);
	}

}
