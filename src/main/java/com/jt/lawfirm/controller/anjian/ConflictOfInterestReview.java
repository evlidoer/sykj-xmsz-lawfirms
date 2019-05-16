package com.jt.lawfirm.controller.anjian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.service.anjian.CaseService;
import com.jt.lawfirm.util.Myoc;


/**
 * 	案件
 * @author 李阳
 *	2019/4/17 14:20
 */
@Controller
public class ConflictOfInterestReview {
	
	@Resource
	private CaseService caseService;
	

	@RequiresPermissions(value= {"anjian:lyctsc","admin","test"},logical=Logical.OR)
	@RequestMapping(value="/ConflictOfInterestReview")
	public String ConflictOfInterestReview() {
		return "anjian/ConflictOfInterestReview";
	}
	
	/**
	 * 利益冲突审查
	 */
	//显示案件
	@RequestMapping(value="/ConflictOfInterestReview",method=RequestMethod.POST)
	@ResponseBody								//委托人   //对方当事人 
	public Object ConflictOfInterestReview(String Wtr,String DWtr,Integer offset,Integer limit,
					HttpServletRequest request) {

		System.out.println(offset);
		System.out.println(limit);
		Map<String,Object> map = new HashMap<String,Object>();
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		if(Wtr.trim().equals("") || Wtr == null) Wtr="@";
		map.put("case_parties", Wtr);														
		map.put("case_opposite_parties", DWtr);
		
		System.out.println(map);
		//分页
		Page<Object> startPage = PageHelper.startPage(offset/limit+1,limit);
		List<Map<String, Object>> lawList = caseService.ConflictOfInterestReview(map);
		
		Map<String,Object> Listmap = new HashMap<String,Object>();
		Listmap.put("total", startPage.getTotal());
		Listmap.put("rows", lawList);
		
	
		return Listmap;
	}
	
	
	
	
	
	
	
	
	
	
	//显示案件
	@RequestMapping(value="/ajaxConflictOfInterestReview",method=RequestMethod.POST)
	@ResponseBody								//委托人   //对方当事人  //从addCase6发来的 anhao
	public Object ajaxConflictOfInterestReview(String Wtr,String DWtr,Integer offset,Integer limit,
					String anhao,String paycols ,Law law,HttpServletRequest request) {//paycols收费情况WholeCase传过来的
		
		System.out.println(offset);
		System.out.println(limit);
		Map<String,Object> map = new HashMap<String,Object>();
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		
		map.put("case_parties", Wtr);														
		map.put("case_opposite_parties", DWtr);
		map.put("anhao", anhao);
		map.put("paycols", paycols);
		
		map.put("casePropernum", law.getCasePropernum());
		map.put("caseApproveStatus", law.getCaseApproveStatus());
		map.put("caseSettleStatus", law.getCaseSettleStatus());
		map.put("caseAssign", law.getCaseAssign());
		System.out.println(map);
		//分页
		Page<Object> startPage = PageHelper.startPage(offset/limit+1,limit);
		List<Map<String, Object>> lawList = caseService.findCase(map);
		
		Map<String,Object> Listmap = new HashMap<String,Object>();
		Listmap.put("total", startPage.getTotal());
		Listmap.put("rows", lawList);
		
		//map.put("userName", "asd");
		//Integer empId = caseService.findEmpById(map);
		//System.err.println("law利益----"+law);
		//System.out.println("empId=========" + empId);
		//Myoc.Ioc().put("empId", empId);
		return Listmap;
	}
	
	


}
