package com.jt.lawfirm.controller.anjian;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.finance.Invoice;
import com.jt.lawfirm.service.anjian.WholeCaseService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class WholeCaseController {
	
	@Resource
	private WholeCaseService wholeCaseService;
	
	@RequiresPermissions(value= {"anjian:syaj","admin","test"},logical=Logical.OR)
	@RequestMapping("WholeCase")
	public String bulkLoad() {
		return "anjian/WholeCase";
	}
	
	
	@RequestMapping("WholeCaseCZ1")
	public String WholeCaseCZ1() {
		return "anjian/WholeCaseCZ1";
	}
	@RequestMapping("WholeCaseCZ2")
	public String WholeCaseCZ2() {
		return "anjian/WholeCaseCZ2";
	}
	//申请发票 "addWholeCaseCZ2"
	@RequestMapping("addWholeCaseCZ2")
	@ResponseBody
	public Integer  addWholeCaseCZ2(Invoice invoice) {
		invoice.setCw_invoice_status("N");
		Integer a = wholeCaseService.addWholeCaseCZ2(invoice);
		System.out.println(invoice);
		return a;
	}
	
	
	
	@RequestMapping("WholeCaseCZ3")
	@ResponseBody
	public Object WholeCaseCZ3(Integer id,String case_recycle) {
		
		boolean boo = wholeCaseService.upWholeCaseCZ3(id,case_recycle);
		return boo;
	}
	@RequestMapping("WholeCaseCZ4")
	@ResponseBody
	public Object WholeCaseCZ4(Integer id,String case_clash) {
		boolean boo = wholeCaseService.upWholeCaseCZ4(id,case_clash);
		return boo;
	}
	
}
