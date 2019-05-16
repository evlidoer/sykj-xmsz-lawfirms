package com.jt.lawfirm.controller.hr;
/*
 * 
 * @author代国繁
 * */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.hr.HrDegree;
import com.jt.lawfirm.service.hr.IHrDegreeService;
import com.jt.lawfirm.service.hr.IHrEmpService;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping(value="/hr/degree")
public class HrDegreeController {
	
	@Resource(name="degreeservice")
	private IHrDegreeService degreeService;
	@Resource(name="hrempservice")
	private IHrEmpService empService;
	
	
	@ResponseBody
	@RequestMapping(value="/bydegrreselect/{id}",method=RequestMethod.GET)
	public Object selectdegreebyid(@PathVariable("id") int id,Map<String, Object> map,HttpServletResponse res,HttpServletRequest req) throws IOException{
		map.put("id", id);
		return degreeService.selectdegreebyid(map);
	}
	@ResponseBody
	@RequestMapping(value="/bydegrreselectid/{id}",method=RequestMethod.GET)
	public Object stdegreebyid(@PathVariable("id") int id,Map<String, Object> map,HttpServletResponse res,HttpServletRequest req) throws IOException{
		map.put("hr_emp_id", id);
		return degreeService.selectdegreebyid(map);
	}
	@ResponseBody
	@RequestMapping(value="/bydegrreselectid",method=RequestMethod.GET)
	public Object selectdegreebyid1(Map<String, Object> map) throws IOException{
		List<String> selectempid = empService.selectempid();
		Integer id= Integer.valueOf(selectempid.get(0))+1;
		map.put("hr_emp_id", id);
		return degreeService.selectdegreebyid(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatedegree",method=RequestMethod.GET)
	public Object update(HrDegree hrDegree){
		return HRBoolean.yesOrNo(degreeService.updatedegree(hrDegree));
	}
	
	@ResponseBody
	@RequestMapping(value="/degrredeletebyid/{id}",method=RequestMethod.GET)
	public Object delete(@PathVariable("id") int id) throws IOException{
		return HRBoolean.yesOrNo(degreeService.deletedegree(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/degrreinsert",method=RequestMethod.GET)
	public Object insert(HrDegree hrDegree) throws IOException{
		List<String> selectempid = empService.selectempid();
		Integer id= Integer.valueOf(selectempid.get(0))+1;
		hrDegree.setHrEmpId(id);
		return HRBoolean.yesOrNo(degreeService.adddegrree(hrDegree));
	}
	
	@ResponseBody
	@RequestMapping(value="/degrreinsertid/{id}",method=RequestMethod.GET)
	public Object insertid(@PathVariable("id")int id,HrDegree hrDegree) throws IOException{
		hrDegree.setHrEmpId(id);
		return HRBoolean.yesOrNo(degreeService.adddegrree(hrDegree));
	}
}
