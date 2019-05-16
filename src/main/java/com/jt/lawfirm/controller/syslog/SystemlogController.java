package com.jt.lawfirm.controller.syslog;
import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
/**
 * @author 代
 * */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.system.mysystembean.MySysTemSelect;
import com.jt.lawfirm.service.systemlog.ISystemlogService;

@Controller
@RequestMapping(value="/sys/index")
public class SystemlogController {
	
	@Resource(name="systemlogservice")
	private ISystemlogService systemlogService;
	
	@RequiresPermissions(value = {"sys:log","admin","test"},logical = Logical.OR)
	@RequestMapping(value="/toindex")
	public String tosystemlog(){
		return "/systemlog/systemlog";
	}
	
	@ResponseBody
	@RequestMapping(value="/selectlog",method=RequestMethod.GET)
	public Object selelog(Integer offset,Integer limit,MySysTemSelect mySysTemSelect){
		PageBean pb = new PageBean(offset, limit, 0L, null);
		systemlogService.selectlog(pb, mySysTemSelect);
		return pb;
	}
	
}
