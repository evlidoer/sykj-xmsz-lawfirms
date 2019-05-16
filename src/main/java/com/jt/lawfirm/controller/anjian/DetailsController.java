package com.jt.lawfirm.controller.anjian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.service.anjian.DetailsService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class DetailsController {
	@Resource
	private DetailsService detailsService;
	
	
	@RequestMapping(value="findDetailsLaw",method=RequestMethod.POST)
	@ResponseBody
	public Object Details(Integer id,HttpServletRequest request) {
		System.out.println(id);
		Map<String,Object> map = new  HashMap<String,Object>();
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		
		map.put("id",id);
		System.out.println(map);
		//显示
		List<Map<String,Object>> lawList =  detailsService.findDetailsLaw(map);
		return lawList;
	}
}
