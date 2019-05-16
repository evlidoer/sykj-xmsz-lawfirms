package com.jt.lawfirm.controller.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.log.Job;
import com.jt.lawfirm.service.log.IAddLogService;

/**
 * 
 * @author 二乐
 *	添加工作日志
 */

@Controller
public class AddLogController {

	@Autowired
	private IAddLogService addlogService;
	
	@RequestMapping("goto/log/addlog")
	public String addlog(){
		return "log/addlog";
		
	}
	@ResponseBody
	@RequestMapping("add/addlog")
	public int add(Job job){
		System.out.println(job.toString());
	int number = 	addlogService.addlog(job);
		return number;
	}
	
	
}
