package com.jt.lawfirm.controller.hr;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * @author代国繁
 * */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.myhrbean.Myempident;
import com.jt.lawfirm.service.hr.IHrEmpService;
import com.jt.lawfirm.service.hr.IHrIdentService;
import com.jt.lawfirm.util.ExportFile;

@Controller
@RequestMapping(value="/hr/index")
public class HrController {
	
	@Resource(name="hrIdentServie")
	private IHrIdentService hrservice;
	
	@Resource(name="hrempservice")
	private IHrEmpService hrEmpService;
	
	@RequiresPermissions(value = {"hr:archives","admin","test"},logical = Logical.OR)
	@RequestMapping(value="/show")
	public String show(){
		return "/hr/hrhome";
	}
	
	@RequiresPermissions(value = {"hr:team","admin","test"},logical = Logical.OR)
	@RequestMapping(value="/showteam")
	public String showteam(){
		return "/hr/hrteam";
	}
	
	@RequestMapping(value="/showsee")
	public String showsee(){
		
		return "/hr/hrEmpSee";
	}
	
	@RequestMapping(value="/toadd")
	public String toadd(){
		return "/hr/hraddLawyer";
	}
	@RequestMapping(value="/toaddsx")
	public String toaddsx(){
		return "/hr/hraddInternship";
	}
	
	@RequestMapping(value="/toaddfz")
	public String toaddfz(){
		return "/hr/hraddauxiliary";
	}
	
	@RequestMapping(value="/toaddteam")
	public String toaddteam(){
		return "/hr/hraddteam";
	}

	
	@RequestMapping(value="/toup")
	public String toupdate(){
		return "/hr/hrEmpUpdate";
	}
	@RequestMapping(value="/toindex")
	public String toindex(){
		return "/hr/hrhome";
	}
	
	@ResponseBody
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public Object selectemp(Integer offset,Integer limit,HttpServletRequest req,Myempident myempident){
		PageBean pb = new PageBean(offset,limit,0L,null);
		hrservice.selectaident(pb, myempident);
		return pb;
	}
	@ResponseBody
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public String ex(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String chval = request.getParameter("chval");
		HSSFWorkbook excel = new HSSFWorkbook();
		if (chval.contains("1")) ExportFile.setSheet(excel, hrEmpService.selectemp(), getempmap());
		if (chval.contains("2")) ExportFile.setSheet(excel, hrEmpService.selectdegree(), getdegreemap());
		if (chval.contains("3")) ExportFile.setSheet(excel, hrEmpService.selectwork(), getworkmap());
		if (chval.contains("4")) ExportFile.setSheet(excel, hrEmpService.selectrew(), getrewmap());
		if (chval.contains("5")) ExportFile.setSheet(excel, hrEmpService.selectpun(), getpunmap());
		ExportFile.downFile(response, "人事信息.xlsx", excel);
		return null;
	}
	
	private Map<String, Object> getempmap(){
		Map<String, Object> list = new HashMap<String,Object>();
		Map<String, String> listmap = new HashMap<String,String>();
		list.put("sheetName", "人事基本资料");
		listmap.put("emp_name", "姓名");
		listmap.put("emp_phone", "手机号码");
		listmap.put("emp_site", "联系地址");
		listmap.put("emp_entrydate", "入职时间");
		listmap.put("emp_email", "邮箱地址");
		listmap.put("emp_postcode", "邮政编码");
		listmap.put("emp_qq", "QQ账号");
		listmap.put("emp_wechat", "微信账号");
		listmap.put("emp_cont_startdate", "合同开始时间");
		listmap.put("emp_cont_enddate", "合同结束时间");
		listmap.put("emp_workstatus", "在职状态");
		listmap.put("emp_social_num", "社保号码");
		listmap.put("emp_status", "状态");
		listmap.put("emp_sex", "性别");
		listmap.put("emp_birthdate", "出生日期");
		listmap.put("emp_paperstype", "证件类型");
		listmap.put("emp_papersnum", "证件号");
		listmap.put("emp_maritalsta", "婚姻状态");
		listmap.put("emp_entrancenum", "门禁号");
		listmap.put("emp_pracnum", "执业号码");
		listmap.put("emp_pracdate", "首次执业时间");
		listmap.put("emp_pracsite", "首次执业地址");
		listmap.put("emp_certifynum", "资格证号码");
		listmap.put("emp_gainway", "资格证取得方式");
		listmap.put("emp_gainsite", "资格证取得地址");
		listmap.put("emp_introduce", "个人介绍");
		listmap.put("hr_certify_id", "资格证类别");
		listmap.put("hr_practise_id", "执业类别");
		listmap.put("hr_specialty_id", "专业部");
		listmap.put("hr_nation_id", "民族");
		listmap.put("hr_political_id", "政治面貌");
		listmap.put("hr_internal_id", "内部身份");
		listmap.put("emp_education", "最高学历");
		listmap.put("emp_academic", "最高学位");
		listmap.put("emp_goodfield", "擅长领域");
		list.put("sheetVal", listmap);
		return list;
	}
	
	
	private Map<String, Object> getdegreemap(){
		Map<String, Object> list = new HashMap<String,Object>();
		Map<String, String> listmap = new HashMap<String,String>();
		list.put("sheetName", "教育经历");
		listmap.put("degree_school", "毕业学校");
		listmap.put("degree_major", "主修专业");
		listmap.put("degree_degrees", "获得学位");
		listmap.put("degree_crednum", "证书编号");
		listmap.put("degree_fulltime", "全日制");
		listmap.put("degree_site", "所在地");
		list.put("sheetVal", listmap);
		return list;
	}
	
	private Map<String, Object> getworkmap(){
		Map<String, Object> list = new HashMap<String,Object>();
		Map<String, String> listmap = new HashMap<String,String>();
		list.put("sheetName", "工作经历");
		listmap.put("workhistory_startdate", "开始日期");
		listmap.put("workhistory_enddate", "结束日期");
		listmap.put("workhistory_workunit", "工作单位");
		listmap.put("workhistory_job_position", "工作职务");
		listmap.put("workhistory_worktype", "工作类别");
		listmap.put("workhistory_worknature", "工作性质");
		listmap.put("workhistory_site", "所在地");
		list.put("sheetVal", listmap);
		return list;
	}
	
	private Map<String, Object> getrewmap(){
		Map<String, Object> list = new HashMap<String,Object>();
		Map<String, String> listmap = new HashMap<String,String>();
		list.put("sheetName", "获奖记录");
		listmap.put("reward_time", "获奖日期");
		listmap.put("reward_level", "获奖级别");
		listmap.put("lssuing_body", "颁奖机构");
		listmap.put("reward_content", "获奖内容");
		list.put("sheetVal", listmap);
		return list;
	}
	
	private Map<String, Object> getpunmap(){
		Map<String, Object> list = new HashMap<String,Object>();
		Map<String, String> listmap = new HashMap<String,String>();
		list.put("sheetName", "惩罚记录");
		listmap.put("punishment_time", "惩罚日期");
		listmap.put("punishment_level", "惩罚级别");
		listmap.put("punishment_matter", "惩罚事项");
		listmap.put("lssuing_body", "惩罚机构");
		listmap.put("punishment_content", "惩罚内容");
		list.put("sheetVal", listmap);
		return list;
	}
}
