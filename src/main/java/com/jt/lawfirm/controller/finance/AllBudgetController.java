package com.jt.lawfirm.controller.finance;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.finance.IAllBudgetService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.DateTime;
import com.jt.lawfirm.util.ExportFile;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping("finance/allBudget")
public class AllBudgetController {
	
	@Resource(name="allBudgetService")
	private IAllBudgetService allBudgetService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:AllBudget","admin","test"},logical = Logical.OR)
	public String showAllBudget() {
		return "finance/allBudget";
	}
	
	@ResponseBody
	@RequestMapping(value="allBudget", method=RequestMethod.GET)
	public Object allBudgetData(PageBean pb ,HttpServletRequest request) {
		allBudgetService.findAllBudgetOfSive(pb ,DateTime.exchangeDate(AutoConversion.conversionToMap(request), "startTime",
				"endTime"));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="inout/{id}", method=RequestMethod.DELETE)
	public Object deleteInout(@PathVariable("id") int id) {
		return HRBoolean.yesOrNo(allBudgetService.removeInoutById(id));
	}
	
	@ResponseBody
	@RequestMapping(value="export", method=RequestMethod.POST)
	public Object allBudgetExport(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> sheet = new HashMap<String, Object>();
		Map<String, String> sheetVal = new HashMap<String, String>();
		sheet.put("sheetName", "Table1");
		sheetVal.put("caseUmber", "案号");
		sheetVal.put("cwInoutTypeName", "收支类别");
		sheetVal.put("cw_inout_date" , "日期");
		sheetVal.put("put" , "收入");
		sheetVal.put("get", "支出");
		sheetVal.put("cw_pay_type" ,"支付方式");
		sheetVal.put("emp_name", "收支人");
		sheetVal.put("cw_payer", "付款人");
		sheetVal.put("cw_remark", "备注");
		sheet.put("sheetVal", sheetVal);
		list.add(sheet);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "Finance(" + sdf.format(new Date()) + ")";
		ExportFile.exportExcelOfS(response, filename, list, allBudgetService.findAllBudgetOfExport(AutoConversion.conversionToMap(request)));
		return null;
	}
	
}
