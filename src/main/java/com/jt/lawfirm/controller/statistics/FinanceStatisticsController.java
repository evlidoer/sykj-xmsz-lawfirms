package com.jt.lawfirm.controller.statistics;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.service.finance.IFinanceStatisticsService;
import com.jt.lawfirm.util.DateTime;

@Controller
@RequestMapping("statistics/finance")
public class FinanceStatisticsController {
	
	@Resource(name="financeStatisticsService")
	private IFinanceStatisticsService financeStatisticsService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"statistics:Finance","admin","test"},logical = Logical.OR)
	public String show() {
		return "statistics/financeStatistics";
	}
	
	@ResponseBody
	@RequestMapping(value="inout", method=RequestMethod.GET)
	public Object inoutData(MyIncomeOfSive myOfSive) {
		return financeStatisticsService.findFinanceStatistics(DateTime.exchangeDate(myOfSive, "startTime", "endTime"));
	}
	
}
