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

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.service.log.MylogService;


/**
 * 
 * @author 二乐
 *我的工作日志 数据显示页面 
 *
 *操作:查看-修改-删除
 *
 */
@Controller
public class MyLogController {
	@Autowired
	private MylogService mylogservice;
	
	
	@RequestMapping("goto/log")
	public String logShow(){

		return "log/logshow";	
	}
	@RequestMapping(value = "goto/log/log_type",method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>>  log_typeSel(){
		return mylogservice.log_typeSel();
	}
	//我的工作日志 操作-查看页面(跳转)
	@RequestMapping("goto/log/operationview")
	public String logOperationview(){
		return "log/operationview";	
	}
	//我的工作日志 操作-修改页面(跳转)
		@RequestMapping("goto/log/operationtomodify")
		public String logOperationview_operationtomodify(){
			return "log/operationtomodify";	
		}
	
	//根据id查看详情
	@RequestMapping(value = "goto/log/operationview/info/{id}",method = RequestMethod.GET)
	@ResponseBody
	public  Object logOperationview(@PathVariable("id")Integer id){
		List<Map<String, Object>> selInfoById = mylogservice.selInfoById(id);
		System.err.println(selInfoById);
		return selInfoById;
	}	
	
	
	//我的工作日志 操作-修改页面
		@RequestMapping(value = "goto/log/operationtomodify/upd/{id}",method = RequestMethod.GET)
		@ResponseBody
		public  Object logOperationtomodify(@PathVariable("id")Integer id){
			System.out.println(id);
			return mylogservice.selInfoById(id);
		}
		
		//修改 goto/log/operationview/uplog
		@RequestMapping(value = "goto/log/operationview/uplog",method = RequestMethod.POST)
		public  Object logOperationtuplog(Job job){
			System.err.println("job------"+job);
			boolean boo = mylogservice.uplog(job);
			return "redirect:goto/log";
		}
	//删除
		@RequestMapping(value = "goto/log/dellogshow/{id}",method = RequestMethod.DELETE)
		public @ResponseBody Boolean  dellogshow(@PathVariable("id") Integer id){
			mylogservice.remove_logshowById(id);
			return true;
		}	
	
		


	//我的工作日志 ——显示数据
	@RequestMapping("/log/show")
	@ResponseBody
	public Object Log_show(HttpServletRequest request){
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
		
		List<HashMap<String ,Object>> queryAll = mylogservice.queryAll(map);
		System.out.println(queryAll);
		return queryAll;


	}
}
