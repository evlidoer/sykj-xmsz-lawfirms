package com.jt.lawfirm.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.casea.CaseLawtype;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.service.casea.ILwaApprovalService;
import com.jt.lawfirm.util.SaveIdUtil;
/**
 * 审批我的申请
 * 王立冬
 * */
@Controller
public class ControllerLwaApproval {
	@Autowired
	private ILwaApprovalService approvalService;
//	@Autowired
//	private ICasetypeService CasetypeService;
	//案件查看
	@RequestMapping("Approval")
	@ResponseBody
	public PageBean gomyapply(Integer offset,Integer limit,Map<String,Object> map,HttpServletRequest request){
		Map<String,Object> finMap = new HashMap<String,Object>();
		String casePropernum = request.getParameter("casePropernum");
		String caseApproveStatus = request.getParameter("caseApproveStatus");
		String StartcaseSubtime = request.getParameter("StartcaseSubtime");
		String scaseTypeId = request.getParameter("caseTypeId");
		String caseSubmitter = request.getParameter("caseSubmitter");
		if(caseSubmitter!=null&&caseSubmitter!=""){
			finMap.put("caseSubmitter","%"+caseSubmitter+"%");
		}
		if(scaseTypeId!=null&&scaseTypeId!=""){
			Integer caseTypeId = Integer.parseInt(scaseTypeId);
			finMap.put("caseTypeId",caseTypeId);
		}
		
		String EndcaseSubtime = request.getParameter("EndcaseSubtime");
		if(casePropernum!=null&&casePropernum!=""){
		
			finMap.put("casePropernum", "%"+casePropernum+"%");
		}
		if(caseApproveStatus!=null&&caseApproveStatus!=""){
			finMap.put("caseApproveStatus",caseApproveStatus);
		}
		if(StartcaseSubtime!=null&&StartcaseSubtime!=""){
			finMap.put("StartcaseSubtime",StartcaseSubtime);
		}
		if(EndcaseSubtime!=null&&EndcaseSubtime!=""){
			finMap.put("EndcaseSubtime",EndcaseSubtime);
		}
		System.out.println(limit+"a"+offset);
		
		PageBean pb = new PageBean();
		System.out.println(offset+"a"+"b"+limit);
		if(limit!=null&&limit!=0){
			pb.setLimit(limit);
		}
		if(offset!=null&&offset!=0){
			pb.setOffset(offset);
		}
		
		finMap.put("pb",pb);
		 List<Map<String,Object>> findAll = approvalService.FindAll(finMap);
		 return pb;
	
	}
	
	//案件类型查询
	@RequestMapping("lawtype")
	@ResponseBody
	public List<CaseLawtype> Selecttype(){
		List<CaseLawtype> Lawtype =  approvalService.FindType();
		System.err.println("type==="+Lawtype);
		return Lawtype;
	}
	
	//跳转到查看流程页面
	@RequestMapping("gocognizance")
	public String goognizance(){
		return "approval/cognizance";
	}
	
	
/*	@RequestMapping("business")
	@ResponseBody
	public List<Casetype> businesstype(){
		List<Casetype> findAll = CasetypeService.FindAll();
		
		return  findAll; 
		
	}*/
	//查看流程
	@ResponseBody
	@RequestMapping("cognizance/{id}")
	public List<Map<String,Object>> Select(@PathVariable("id")Integer id,HttpServletRequest request){
		List<Map<String,Object>> findById = approvalService.FindById(id);
		System.err.println(findById);
		return findById;
	}
	//对方当事人查看
	@ResponseBody
	@RequestMapping("lawSelect")
	public PageBean lawSelect(HttpServletRequest request,Map<String,Object> map){
		Map<String,Object> Map = new HashMap<>();
		String plimit = request.getParameter("limit");
		String poffset = request.getParameter("offset");
		String caseoppositeparties = request.getParameter("caseoppositeparties");
		
		if(caseoppositeparties!=null&&caseoppositeparties!=""){
			Map.put("caseoppositeparties","%"+caseoppositeparties+"%");
		}
		System.out.println(plimit);
		System.out.println(poffset);
		PageBean pb = new PageBean();
		if(plimit!=null&&plimit!=""){
			Integer limit = Integer.parseInt(plimit);
			pb.setLimit(limit);
		}
		if(poffset!=null&&poffset!=""){
			Integer offset = Integer.parseInt(poffset);
			pb.setOffset(offset);
		}
		
		Map.put("pb",pb);
		List<Map<String,Object>> findAll = approvalService.FindAll(Map);
		System.err.println(findAll);
		return pb;
	}
	//对方当事人修改页面跳转
	@RequestMapping("gotoupdateparties/{id}")
	public String goupdateparties(@PathVariable("id")Integer id){
		SaveIdUtil.saveID(id);
		return "client/updateparties";
	}
	
	//对方当事人修改
	@RequestMapping("updateparties")
	public String updatepartes(Law law){
		law.setId(SaveIdUtil.getID());
		int modiflaw = approvalService.modiflaw(law);
		return "redirect:/gotocounterparty";
	}
}
