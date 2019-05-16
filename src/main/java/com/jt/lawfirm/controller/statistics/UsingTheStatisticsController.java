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
import com.jt.lawfirm.service.statistics.IUsingStatisticsService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.ExportFile;

@Controller
@RequestMapping("statistics/using")
public class UsingTheStatisticsController {
	
	@Resource(name="sjaStatisticsService")
	private IShouJieAnStatisticsService sjaStatistics;
	@Resource(name="usingStatisticsService")
	private IUsingStatisticsService usingService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"statistics:Using","admin","test"},logical = Logical.OR)
	public String show() {
		return "statistics/usingTheStatistics";
	}
	
	@ResponseBody
	@RequestMapping(value="lawType", method=RequestMethod.GET)
	public Object lawType() {
		return sjaStatistics.findInoutTypeAll();
	}
	
	@ResponseBody
	@RequestMapping(value="data", method=RequestMethod.GET)
	public Object getData(PageBean pb, HttpServletRequest request) {
		usingService.findApplyforOfSive(pb, AutoConversion.conversionToMap(request));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="export", method=RequestMethod.POST)
	public Object exportLoad(HttpServletResponse response,HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExportFile.exportExcelOfS(response, "Official(" + sdf.format(new Date()) + ")", getMap(), 
				usingService.findApplyforOfSiveOnExprot(AutoConversion.conversionToMap(request)));
		return null;
	}
	
	private List<Map<String, Object>> getMap() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("sanum", "函号");
		listMap.put("case_propernum", "案号");
		listMap.put("applyfor_receive", "领用日期");
		listMap.put("applyfor_approval_status", "审批状态");
		listMap.put("emp_name", "领用人");
		listMap.put("applyfor_using_the_item", "用印事项");
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	
}
