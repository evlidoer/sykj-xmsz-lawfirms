package com.jt.lawfirm.controller.anjian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.anjian.Feiyong;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.service.anjian.FeiyongService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class FeiyongController {
	
	@Resource
	private FeiyongService feiyongService;
	@RequiresPermissions(value= {"anjian:fy","admin","test"},logical=Logical.OR)
	@RequestMapping(value="feiyong")
	public String feiyong() {
		return "anjian/feiyong";
	}
	
	//显示 申请记录表
	@RequestMapping(value = "ajaxFeiyong",method=RequestMethod.POST)
	@ResponseBody
	public Object ajaxFeiyong(Feiyong feiyong,Law law,Integer offset,Integer limit,HttpServletRequest request){
		System.out.println(offset + "---" + limit);
		Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);

		Map<String,Object> map = new  HashMap<>();
		System.out.println("++++++++++++++++++==" + feiyong.getRelief_approval_status());
		System.out.println("++++++++++++++++++==" + law.getCasePropernum());
		map.put("relief_approval_status", feiyong.getRelief_approval_status());
		map.put("casePropernum", law.getCasePropernum());
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		System.out.println("---------------------------------->登陆人账号***" + userName);
		
		
		List<Map<String,Object>> feiyongList = feiyongService.feiyongShow(map);
		Map<String,Object> feiyongListMap = new  HashMap<>();
		feiyongListMap.put("total", startPage.getTotal());
		feiyongListMap.put("rows", feiyongList);
		return feiyongListMap;
	}
	
	
	//删除
	@RequestMapping(value="delfeiyong/{id}")
	@ResponseBody
	public Object delfeiyong(@PathVariable("id")Integer id) {
		boolean boo = feiyongService.delfeiyong(id);
		return boo;
	}
	
}
