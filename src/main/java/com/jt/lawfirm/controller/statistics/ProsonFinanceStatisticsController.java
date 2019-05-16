package com.jt.lawfirm.controller.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;
import com.jt.lawfirm.service.finance.ILawFirmBudgetEntryService;
import com.jt.lawfirm.service.statistics.IProsonFinanceStatisticsService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.ExportFile;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping("statistics/prosonFinance")
public class ProsonFinanceStatisticsController {
	
	@Resource(name="LFBEService")
	private ILawFirmBudgetEntryService lawService;
	@Resource(name="prosonFinanceStatisticsService")
	private IProsonFinanceStatisticsService statiscsService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"statistics:ProsonFinance","admin","test"},logical = Logical.OR)
	public String show() {
		return "statistics/prosonFinanceStatistics";
	}
	
	@ResponseBody
	@RequestMapping(value="upLsjl", method=RequestMethod.POST)
	public Object upLsjl(HttpServletRequest request) {
		return HRBoolean.yesOrNo(statiscsService.addHistory(AutoConversion.conversionToMap(request)));
	}
	
	@ResponseBody
	@RequestMapping(value="names", method=RequestMethod.GET)
	public Object getNames(String name) {
		return lawService.findEmpToIdAndName(name);
	}
	
	@ResponseBody
	@RequestMapping(value="revenue", method=RequestMethod.GET)
	public Object getRevenue(MyStatisticsOfSive my) {
		return statiscsService.findIncomeOfSive(my);
	}
	
	@ResponseBody
	@RequestMapping(value="reserved", method=RequestMethod.GET)
	public Object getReserved(MyStatisticsOfSive my) {
		return statiscsService.findReservedOfSive(my);
	}
	
	@ResponseBody
	@RequestMapping(value="commission", method=RequestMethod.GET)
	public Object getCommission(MyStatisticsOfSive my) {
		return statiscsService.findCommission(my);
	}
	
	@RequestMapping(value="export", method=RequestMethod.POST)
	public String export(MyStatisticsOfSive my, HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder("执业人员财务统计(");
		sb.append(my.getStartTime() + "至" + my.getEndTime() + ")");
		ExportFile.exportExcelOfS(response ,sb.toString() , getMap() , statiscsService.findIncomeOfSives(my),
				statiscsService.findReservedOfSive(my), statiscsService.findCommission(my));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="lstj", method=RequestMethod.GET)
	public Object showLstj(PageBean pb,Integer id) {
		statiscsService.findHistoryAndEmp(pb,id);
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="delHis", method=RequestMethod.DELETE)
	public Object delHis(Integer id) {
		return HRBoolean.yesOrNo(statiscsService.removeHistory(id));
	}
	
	private List<Map<String, Object>> getMap() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "律师创收");
		listMap.put("caseLawyer", "承办律师");
		listMap.put("caseUmber", "案号");
		listMap.put("caseParties", "委托人");
		listMap.put("caseOppositeParties", "对方当事人");
		listMap.put("cw_inout_date", "收款日期");
		listMap.put("cw_inout_money", "收款金额");
		listMap.put("cw_pay_type", "备注");
		list.put("sheetVal", listMap);
		Map<String, Object> reserved = new HashMap<String, Object>();
		Map<String, String> reservedMap = new HashMap<String, String>();
		reserved.put("sheetName", "律师归档预留");
		reservedMap.put("caseUmber", "案号");
		reservedMap.put("sumMoney", "总收款金额");
		reserved.put("sheetVal", reservedMap);
		Map<String, Object> commission = new HashMap<String, Object>();
		Map<String, String> commissionMap = new HashMap<String, String>();
		commission.put("sheetName", "律师归档提成");
		commissionMap.put("caseLawyer", "承办律师");
		commissionMap.put("caseUmber", "案号");
		commissionMap.put("caseParties", "委托人");
		commissionMap.put("caseOppositeParties", "对方当事人");
		commissionMap.put("sumMoney", "创收金额");
		commissionMap.put("sumMoney", "归档金");
		commission.put("sheetVal", commissionMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		tableName.add(reserved);
		tableName.add(commission);
		return tableName;
	}
	
}
