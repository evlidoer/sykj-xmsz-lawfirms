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
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyInvoice;
import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.service.finance.IMyInvoiceService;
import com.jt.lawfirm.service.login.LoginService;

@Controller
@RequestMapping(value="finance/invoice")
public class MyInvoiceController {
	
	@Resource(name="invoiceService")
	private IMyInvoiceService invoiceService;
	@Resource(name = "LoginService")
	private LoginService LoginService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:Invoice","admin","test"},logical = Logical.OR)
	public String showInvoice() {
		return "/finance/myInvoice";
	}
	
	@ResponseBody
	@RequestMapping(value="getVal", method=RequestMethod.GET)
	public Object getInvoice(Integer limit,Integer offset, MyInvoice invoice, HttpServletRequest request) {
		PageBean pb = new PageBean(offset, limit, 0L, null);
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		Integer id = 0;
		try {
			id = user.getHrEmpId();
		}catch (NullPointerException e) {
			System.out.println("重新登录");
		}
		invoice.setId(id.toString());
		System.err.println(invoice);
		invoiceService.findInvoiceofSive(pb, invoice);
		return pb;
	}
	
}
