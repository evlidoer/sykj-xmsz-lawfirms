package com.jt.lawfirm.controller.finance;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyBudget;
import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.service.finance.IMyBudgetService;
import com.jt.lawfirm.service.login.LoginService;

@Controller
@RequestMapping("finance/budget")
public class MyBudgetController {

	@Resource(name = "myBudgetService")
	private IMyBudgetService myBudgetService;
	@Resource(name = "LoginService")
	private LoginService LoginService;
	
	//加载我的收支页面
	@RequiresPermissions(value = {"finance:Budget","admin","test"},logical = Logical.OR)
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String showBudget() {
		return "/finance/myBudget";
	}
	
	//获取收支数据
	@ResponseBody
	@RequestMapping(value = "getData", method = RequestMethod.GET)
	public Object getData(Integer limit,Integer offset, MyBudget myBudget ,HttpServletRequest request) {
		PageBean page = new PageBean(offset, limit, 0L, null);
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		Integer id = 0;
		try {
			id = user.getHrEmpId();
		}catch (NullPointerException e) {
			System.out.println("重新登录");
		}
		myBudget.setHrEmpId(id.toString());	
		myBudgetService.findInoutOfSive(page, myBudget);
		System.out.println(page);
		return page;
	}

	// 获取收支类型数据
	@ResponseBody
	@RequestMapping(value = "Itype", method = RequestMethod.GET)
	public Object getInoutType() {
		return myBudgetService.findInoutTypeAll();
	}

	// 获取案件类型数据
	@ResponseBody
	@RequestMapping(value = "Ctype", method = RequestMethod.GET)
	public Object getCaseType() {
		return myBudgetService.findCaseTypeAll();
	}
	
}
