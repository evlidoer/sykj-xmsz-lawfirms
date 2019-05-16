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
import com.jt.lawfirm.service.finance.IKpListService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.DateTime;
import com.jt.lawfirm.util.ExportFile;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping("finance/kpList")
public class KpListController {
	
	@Resource(name="kpListService")
	private IKpListService kpListService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:KpList","admin","test"},logical = Logical.OR)
	public String loadHtml() {
		return "finance/KpList";
	}
	
	@ResponseBody
	@RequestMapping(value="invoice", method=RequestMethod.GET)
	public Object getData(PageBean pb, HttpServletRequest request) {
		kpListService.findInvoiceOfSiveAll(pb, DateTime.exchangeDate(AutoConversion.conversionToMap(request)
				, "startTime", "endTime"));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="invoice/{id}", method=RequestMethod.DELETE)
	public Object getData(@PathVariable("id") int id) {
		return HRBoolean.yesOrNo(kpListService.removeInvoiceOfId(id));
	}
	
	@ResponseBody
	@RequestMapping(value="export", method=RequestMethod.POST)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> sheet = new HashMap<String, Object>();
		Map<String, String> sheetVal = new HashMap<String, String>();
		sheet.put("sheetName", "Table1");
		sheetVal.put("case_propernum", "案号");
		sheetVal.put("shengqing", "申请人");
		sheetVal.put("banan" , "办案律师");
		sheetVal.put("cw_invoice_title" , "发票抬头");
		sheetVal.put("case_agencyfee", "代理费(元)");
		sheetVal.put("cw_invoice_money" ,"发票金额");
		sheetVal.put("sumInvoice", "已开票金额(元)");
		sheetVal.put("sumInout", "已付款(元)");
		sheetVal.put("cw_invoice_date", "开票日期");
		sheetVal.put("cw_invoice_status", "开票状态");
		sheet.put("sheetVal", sheetVal);
		list.add(sheet);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "Bill(" + sdf.format(new Date()) + ")";
		ExportFile.exportExcelOfS(response, filename, list, 
				kpListService.findInvoiceOfSiveAllExprot(
					DateTime.exchangeDate(AutoConversion.conversionToMap(request),"startTime", "endTime")));
		return null;
	}
	
}
