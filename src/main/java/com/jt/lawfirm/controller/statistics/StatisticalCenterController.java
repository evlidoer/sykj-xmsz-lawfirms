package com.jt.lawfirm.controller.statistics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.jt.lawfirm.service.finance.ILawFirmBudgetEntryService;
import com.jt.lawfirm.service.statistics.IStatisticalCenterService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.ExportFile;

@Controller
@RequestMapping("statistics/center")
public class StatisticalCenterController {
	
	@Resource(name="centerService")
	private IStatisticalCenterService centerService;
	@Resource(name="LFBEService")
	private ILawFirmBudgetEntryService lawService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"statistics:Center","admin","test"},logical = Logical.OR)
	public String show() {
		return "statistics/statisticalCenter";
	}
	
	@ResponseBody
	@RequestMapping(value="list1Data", method=RequestMethod.GET)
	public Object list1Data(HttpServletRequest request) {
		return centerService.findSiveToMap(AutoConversion.conversionToMap(request));
	}
	
	@ResponseBody
	@RequestMapping(value="names", method=RequestMethod.GET)
	public Object getNames(String name) {
		return lawService.findEmpToIdAndName(name);
	}
	
	@ResponseBody
	@RequestMapping(value="list2Data", method=RequestMethod.GET)
	public Object list2Data(HttpServletRequest request) {
		return centerService.findPersonalBusiness(AutoConversion.conversionToMap(request));
	}
	
	@ResponseBody
	@RequestMapping(value="list3Data", method=RequestMethod.GET)
	public Object list3Data(HttpServletRequest request) {
		return centerService.findSiveToMapPlus(AutoConversion.conversionToMap(request));
	}
	
	@ResponseBody
	@RequestMapping(value="list4Data", method=RequestMethod.GET)
	public Object list4Data(HttpServletRequest request) {
		return centerService.findReceiveStatistical(AutoConversion.conversionToMap(request));
	}
	
	@ResponseBody
	@RequestMapping(value="list5Data", method=RequestMethod.GET)
	public Object list5Data(HttpServletRequest request) {
		return centerService.findClassInvoice(AutoConversion.conversionToMap(request));
	}
	
	@ResponseBody
	@RequestMapping(value="list1Exprot", method=RequestMethod.POST)
	public Object list1Exprot(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "TongJi(" + sdf.format(new Date()) + ")", getList1Map(), 
				centerService.findSiveToMap(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="list2Exprot", method=RequestMethod.POST)
	public Object list2Exprot(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "TongJi(" + sdf.format(new Date()) + ")", getList2Map(), 
				centerService.findPersonalBusiness(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="list3Exprot", method=RequestMethod.POST)
	public Object list3Exprot(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "UsersTongJi(" + sdf.format(new Date()) + ")", getList1Map(), 
				centerService.findSiveToMapPlus(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="list4Exprot", method=RequestMethod.POST)
	public Object list4Exprot(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "LawTongJi(" + sdf.format(new Date()) + ")", getList4Map(), 
				centerService.findReceiveStatistical(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	private List<Map<String, Object>> getList1Map() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("times", "日期");
		listMap.put("sumHetong", "合同金额");
		listMap.put("sumInvoice", "开票金额");
		listMap.put("sumInout", "收款金额");
		listMap.put("sumGui", "归档金额");
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	
	private List<Map<String, Object>> getList2Map() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("emp_name", "姓名");
		listMap.put("sumInvoice", "开票金额");
		listMap.put("sumInout", "收款金额");
		listMap.put("sumGui", "归档金额");
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	
	private List<Map<String, Object>> getList4Map() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("cw_pay_type", "收费方式");
		listMap.put("money", "收费金额");
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	
}
