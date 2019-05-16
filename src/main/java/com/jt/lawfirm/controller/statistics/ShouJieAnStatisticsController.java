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

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.statistics.IShouJieAnStatisticsService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.ExportFile;

@Controller
@RequestMapping("statistics/shoujiean")
public class ShouJieAnStatisticsController {
	
	@Resource(name="sjaStatisticsService")
	private IShouJieAnStatisticsService sjaStatistics;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"statistics:Shoujiean","admin","test"},logical = Logical.OR)
	public String show() {
		return "statistics/shouJieAnStatistics";
	}
	
	@ResponseBody
	@RequestMapping(value="lawType", method=RequestMethod.GET)
	public Object lawType() {
		return sjaStatistics.findInoutTypeAll();
	}
	
	@ResponseBody
	@RequestMapping(value="data", method=RequestMethod.GET)
	public Object getData(PageBean pb, HttpServletRequest request) {
		sjaStatistics.findLawAllOfSive(pb, AutoConversion.conversionToMap(request));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="export", method=RequestMethod.POST)
	public Object exportLoad(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "case(" + sdf.format(new Date()) + ")", getMap(), 
				sjaStatistics.findLawAllOfSiveExport(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	private List<Map<String, Object>> getMap() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("case_propernum", "案号");
		listMap.put("case_cause", "案由");
		listMap.put("case_subtime", "收案日期");
		listMap.put("case_parties", "委托人");
		listMap.put("case_opposite_parties", "对方当事人");
		listMap.put("emp_name", "承办律师");
		listMap.put("case_accept", "受理单位");
		listMap.put("agencyfee", "标的(元)");
		listMap.put("case_lawsuitobj", "收费(元)");
		listMap.put("sumInout", "已付款(元)");
		listMap.put("sumInvoice", "已开票(元)");
		listMap.put("case_clash", "归档状态");
		listMap.put("case_filenumber", "归档号");
		listMap.put("case_settle_date", "结案日期");
		listMap.put("case_settle_way", "结案方式");
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	
}
