package com.jt.lawfirm.controller.assess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.assess.IDataReportService;

@Controller
public class ControllerDataReport {
	@Autowired
	private IDataReportService datareportService;
	
	@RequestMapping("gotorepotr")
	public String gotorepotr(){
		return "assess/report";
	}
	@RequestMapping("gotohistory")
	public String gotohistory(){
		return "assess/history";
	}
	@RequestMapping("gotoyearend")
	public String gotoyearend(){
		return "assess/yearend";
	}
	@RequestMapping("gotorecord")
	public String gotorecord(){
		return "assess/record";
	}
	
	@ResponseBody
	@RequestMapping("datareport")
	public PageBean show(Integer offset,Integer limit,Map<String,Object> map,HttpServletRequest request){
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
		 List<Map<String,Object>> findAll = datareportService.FindAll(finMap);
		 return pb;
	
	}
}
