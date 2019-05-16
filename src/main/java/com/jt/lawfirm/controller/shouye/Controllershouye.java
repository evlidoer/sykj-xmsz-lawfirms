package com.jt.lawfirm.controller.shouye;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.shouye.Calendar;
import com.jt.lawfirm.service.shouye.IShouyeService;

@Controller
public class Controllershouye {
	@Autowired
	private IShouyeService shouyeservice;
	//案件数量查询
	@RequestMapping("statisticsanjian")
	@ResponseBody
	public Map<String,Object> number(){
		Map<String,Object> map = new HashMap<>();
		int numberapproval	 = shouyeservice.approvalnum();
		int numberoffice = shouyeservice.officenum();
		int numsettle = shouyeservice.settlenum();
		map.put("numberapproval",numberapproval);
		map.put("numberoffice",numberoffice);
		map.put("numsettle",numsettle);
		System.out.println("待审批数量="+numberapproval+"在办数量="+numberoffice+"结案数量="+numsettle);
		return map;
	}
	//案件查看
	@RequestMapping("tableanjian")
	@ResponseBody
	public List<Map<String,Object>> tableanjian(){
	 List<Map<String,Object>> SelectAll = shouyeservice.SelectLaw();
		
	 return SelectAll;
	}
	//公告查询
	@RequestMapping("noticename")
	@ResponseBody
	public List<Map<String,Object>> noticename(){
		List<Map<String,Object>> map = shouyeservice.Selectnotice();
		return map;
	}
	//日历事件
	@RequestMapping("addcalendar")
	@ResponseBody
	public int addcalendar(Calendar calendr){
		System.out.println(calendr.toString());
		int number =  shouyeservice.addcalendar(calendr);
		return number;
	}
	
}
