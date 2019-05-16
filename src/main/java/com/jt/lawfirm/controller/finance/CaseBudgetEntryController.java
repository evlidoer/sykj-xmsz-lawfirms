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
import com.jt.lawfirm.service.finance.ICaseBudgetEntryService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping("finance/caseEntry")
public class CaseBudgetEntryController {
	
	@Resource(name="cbeService")
	private ICaseBudgetEntryService cbeService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:CaseEntry","admin","test"},logical = Logical.OR)
	public String showCase() {
		return "finance/caseBudgetEntry";
	}
	

	@RequestMapping(value="showAdd", method=RequestMethod.GET)
	public String showAdd() {
		return "finance/caseBudgetEntryAdd";
	}
	
	
	@ResponseBody
	@RequestMapping(value="lawData", method=RequestMethod.GET)
	public Object getLawData(PageBean pb, String caseId, String souId) {
		cbeService.findLawOfSive(pb, AutoConversion.conversionToMap(caseId,souId));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="type", method=RequestMethod.GET)
	public Object getInoutType() {
		return cbeService.findInoutTypeIncome();
	}
	
	@ResponseBody
	@RequestMapping(value="addUp", method=RequestMethod.POST)
	public Object addUp(HttpServletRequest request) {
		return HRBoolean.yesOrNo(cbeService.addInoutOfSive(AutoConversion.conversionToMap(request)));
	}
	
}
