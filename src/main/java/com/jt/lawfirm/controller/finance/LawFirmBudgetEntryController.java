package com.jt.lawfirm.controller.finance;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.service.finance.ILawFirmBudgetEntryService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping("finance/lawEntry")
public class LawFirmBudgetEntryController {
	
	@Resource(name="LFBEService")
	private ILawFirmBudgetEntryService lawService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:LawEntry","admin","test"},logical = Logical.OR)
	public String showCase() {
		return "finance/lawFirmBudgetEntry";
	}
	
	@ResponseBody
	@RequestMapping(value="names", method=RequestMethod.GET)
	public Object getNames(String name) {
		return lawService.findEmpToIdAndName(name);
	}
	
	@ResponseBody
	@RequestMapping(value="iType", method=RequestMethod.GET)
	public Object getInoutType() {
		return lawService.findInoutTypeAll();
	}
	
	@ResponseBody
	@RequestMapping(value="addInout", method=RequestMethod.POST)
	public Object addInout(HttpServletRequest request) {
		return HRBoolean.yesOrNo(lawService.addInoutOneRow(AutoConversion.conversionToMap(request)));
	}
	
}
