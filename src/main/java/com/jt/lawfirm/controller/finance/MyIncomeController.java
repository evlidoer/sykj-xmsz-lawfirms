package com.jt.lawfirm.controller.finance;

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
import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.service.finance.IMyIncomeService;
import com.jt.lawfirm.service.login.LoginService;
import com.jt.lawfirm.service.statistics.IProsonFinanceStatisticsService;
import com.jt.lawfirm.util.ExportFile;

@Controller
@RequestMapping(value="finance/income")
public class MyIncomeController {
	
	@Resource(name="myIncomeService")
	private IMyIncomeService incomeService;
	@Resource(name = "LoginService")
	private LoginService LoginService;
	@Resource(name="prosonFinanceStatisticsService")
	private IProsonFinanceStatisticsService statiscsService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:Income","admin","test"},logical = Logical.OR)
	public String show() {
		return "/finance/myIncome";
	}
	
	@RequestMapping(value="showIncome", method=RequestMethod.GET)
	public String showIncome() {
		return "/finance/incomeParticulars";
	}
	
	@ResponseBody
	@RequestMapping(value="lstj", method=RequestMethod.GET)
	public Object showLstj(PageBean pb, HttpServletRequest request) {
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		statiscsService.findHistoryAndEmp(pb, user.getHrEmpId());
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="revenue", method=RequestMethod.GET)
	public Object getRevenue(MyStatisticsOfSive my, HttpServletRequest request) {
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		Integer id = 0;
		try {
			id = user.getHrEmpId();
		}catch (NullPointerException e) {
			System.out.println("重新登录");
		}
		my.setId(id);
		return incomeService.findIncomeOfSivePlus(my);
	}
	
	@ResponseBody
	@RequestMapping(value="reserved", method=RequestMethod.GET)
	public Object getReserved(MyStatisticsOfSive my, HttpServletRequest request) {
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		Integer id = 0;
		try {
			id = user.getHrEmpId();
		}catch (NullPointerException e) {
			System.out.println("重新登录");
		}
		my.setId(id);
		return incomeService.findReservedOfSivePlus(my);
	}
	
	@ResponseBody
	@RequestMapping(value="commission", method=RequestMethod.GET)
	public Object getCommission(MyStatisticsOfSive my, HttpServletRequest request) {
		User user = LoginService.finUserByNamw((String) request.getSession().getAttribute("userName"));
		Integer id = 0;
		try {
			id = user.getHrEmpId();
		}catch (NullPointerException e) {
			System.out.println("重新登录");
		}
		my.setId(id);
		return incomeService.findCommissionPlus(my);
	}
	
	@RequestMapping(value="export", method=RequestMethod.POST)
	public String export(MyStatisticsOfSive my, HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder("我的收入(");
		sb.append(my.getStartTime() + "至" + my.getEndTime() + ")");
		ExportFile.exportExcelOfS(response ,sb.toString() , getMap() , incomeService.findIncomeOfSivesPlus(my), 
				incomeService.findReservedOfSivePlus(my), incomeService.findCommissionPlus(my));
		return null;
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
