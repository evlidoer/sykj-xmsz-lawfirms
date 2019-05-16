package com.jt.lawfirm.controller.anjian;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.service.anjian.ManageCaseService;

@Controller
public class ManageCase {
	
	@Resource
	private ManageCaseService manageCaseService;
	
	@RequiresPermissions(value= {"anjian:glaj","admin","test"},logical=Logical.OR)
	@RequestMapping("ManageCase")
	public String ManageCase() {
		return "anjian/manageCase";
	}
	//改暗号
	@RequestMapping("ManageCase2")
	public String ManageCase2() {
		return "anjian/manageCase2";
	}
	//修	upAnjianHao
	@RequestMapping(value="upAnjianHao",method=RequestMethod.POST)
	@ResponseBody
	public Integer upAnjianHao(String NewCaseId,String id,Map<String,Object> map) {
		map.put("id", id);
		map.put("NewCaseId",NewCaseId);
		Integer upAnjianHao = manageCaseService.upAnjianHao(map);
		return upAnjianHao;
	}
	//判断案号
	@RequestMapping(value="selCasePropernum/{CasePropernum}",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selCasePropernum(@PathVariable("CasePropernum")String CasePropernum) {
		String newcasePropernum = manageCaseService.selCasePropernum(CasePropernum);
		return newcasePropernum;
	}
	
	
	
	@RequestMapping("ManageCase3")
	public String ManageCase3() {
		return "anjian/manageCase3";
	}
	//添加档案号
	@RequestMapping(value="setCaseFilenumber",method=RequestMethod.PUT)
	@ResponseBody
	public Integer setCaseFilenumber(String caseFilenumber,
			String id,Map<String,Object>map
			) {
		map.put("caseFilenumber", caseFilenumber);
		map.put("id", Integer.parseInt(id));
		Integer num = manageCaseService.setCaseFilenumber(map);
		return num;
	}
	
	@RequestMapping("ManageCase4")
	public String ManageCase4() {
		return "anjian/manageCase4";
	}
	//删除law   DelLaw
	@RequestMapping("DelLaw")
	@ResponseBody
	public Integer DelLaw(String id) {
		Integer addLawHistroy_DelLaw = manageCaseService.addLawHistroy_DelLaw(id);
		return addLawHistroy_DelLaw;
	}
	
	
	
	@RequestMapping("ManageCase5")
	public String ManageCase5() {
		return "anjian/manageCase5";
	}
	
	//显示回收
	
	@RequestMapping("lawHistroy")
	@ResponseBody
	public Object lawHistroy(String Title) {
		List<Map<String,Object>> lawHistroyList = manageCaseService.lawHistroy(Title);
		return lawHistroyList;
	}
}
