package com.jt.lawfirm.controller.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.service.log.IAllLogService;


/**
 * 
 * @author 二乐
 *  全所工作日志
 *  操作-查看
 */
@Controller
public class AllLogController {

	@Autowired
	private IAllLogService alllogService;
	
	//跳转显示页面
	@RequestMapping("goto/log/allworkshow")
	public String allworkshow(){
	
		return "log/allworkshow";	
	}
	

	//全所工作日志 操作-查看页面(跳转)
	@RequestMapping("goto/log/allworkjourna")
	public String logAllworkjourna(){

		return "log/allworkjourna";	
	}

	//根据id查看详情
	@RequestMapping(value = "goto/log/allworkjourna/info/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Map<String ,Object> logAllworkjourna(@PathVariable("id")int id){
		System.out.println(id);
		return alllogService.selInfoById(id);
	}
	
	
	//显示数据
	@RequestMapping("/log/allworkshow")
	public @ResponseBody Object All_WorkShow(HttpServletRequest request){
		
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();

		/**
		 * 	模糊查询所需条件
		 */
		String Title = request.getParameter("Title");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String status = request.getParameter("addresslist_state");
		if (Title != null && !"".equals(Title)) {
			map.put("Title", "%"+Title+"%");
		}
		if (stime != null && !"".equals(stime)) {
			map.put("stime", stime);
		}
		if (etime != null && !"".equals(etime)) {
			map.put("etime", etime);
		}
		if (status != null && !"".equals(status) && !"-1".equals(status)) {
			map.put("addresslist_state", status);
		}
		
		
		List<HashMap<String, Object>> queryAll=alllogService.queryAll(map);
		System.out.println(queryAll);
		return queryAll;
	}
	
	
}
