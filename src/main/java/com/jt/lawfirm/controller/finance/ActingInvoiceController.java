package com.jt.lawfirm.controller.finance;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.finance.IActingInvoiceService;
import com.jt.lawfirm.service.finance.ICaseBudgetEntryService;
import com.jt.lawfirm.service.finance.ILawFirmBudgetEntryService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.HRBoolean;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("finance/acting")
public class ActingInvoiceController {
	
	@Resource(name="cbeService")
	private ICaseBudgetEntryService cbeService;
	@Resource(name="actingInvoiceService")
	private IActingInvoiceService invoiceService;
	@Resource(name="LFBEService")
	private ILawFirmBudgetEntryService lawService;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	@RequiresPermissions(value = {"finance:ActingInvoice","admin","test"},logical = Logical.OR)
	public String showActing() {
		return "finance/actingInvoice";
	}
	
	@ResponseBody
	@RequestMapping(value="lawData", method=RequestMethod.GET)
	public Object getLawData(PageBean pb, String caseId, String souId) {
		cbeService.findLawOfSive(pb, AutoConversion.conversionToMap(caseId,souId));
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="invoiceNumber/{id}", method=RequestMethod.GET)
	public Object getinvoiceNumber(@PathVariable("id") int id) {
		return invoiceService.findInvoiceByIdOfNumber(id);
	}
	
	@ResponseBody
	@RequestMapping(value="names", method=RequestMethod.GET)
	public Object getNames(String name) {
		return lawService.findEmpToIdAndName(name);
	}
	
	@ResponseBody
	@RequestMapping(value="updata", method=RequestMethod.POST)
	public Object updata(MultipartFile mypath, String kdManagerF, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload");
		@SuppressWarnings("unchecked")
		Map<String, String> bean = (Map<String, String>) JSONObject.toBean(JSONObject.fromObject(kdManagerF), HashMap.class);
		if(mypath != null) {
			String filename = mypath.getOriginalFilename();
			String fileName = filename.substring(0, filename.lastIndexOf(".")) + "." + new Date().getTime()
					+ filename.substring(filename.lastIndexOf("."), filename.length());
			File file = new File(path, fileName);
			try {
				mypath.transferTo(file);
				bean.put("file_name", filename);
				bean.put("file_type", file.getAbsolutePath());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return HRBoolean.yesOrNo(false);
			}
		}
		return HRBoolean.yesOrNo(invoiceService.addCollectionAll(bean));
	}
	
	@ResponseBody
	@RequestMapping(value="f", method=RequestMethod.GET)
	public Object getKdmanagerF() {
		return invoiceService.findKdmanagerFAllByY();
	}
	
	@ResponseBody
	@RequestMapping(value="kb", method=RequestMethod.GET)
	public Object getKdmanagerKb() {
		return invoiceService.findKdmanagerKdAllByY();
	}
	
}
