
package com.jt.lawfirm.controller.hr;
import java.io.IOException;
import java.util.List;
/*
 * 
 * @author代国繁
 * */
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.hr.HrWorkhistory;
import com.jt.lawfirm.service.hr.IHrEmpService;
import com.jt.lawfirm.service.hr.IHrWorkhistoryService;
import com.jt.lawfirm.util.HRBoolean;
/**
 * @author 代
 * */
@Controller
@RequestMapping(value="/hr/work")
public class HeWorkhistoryController {
	
	@Resource(name="workservice")
	private IHrWorkhistoryService hrWorkhistoryService;
	@Resource(name="hrempservice")
	private IHrEmpService empService;
	
	@ResponseBody
	@RequestMapping(value="/byworkselect/{id}",method=RequestMethod.GET)
	public Object show(@PathVariable("id") int id,Map<String, Object> map){
		map.put("id", id);
		return  hrWorkhistoryService.selectworkby(map);
	}
	@ResponseBody
	@RequestMapping(value="/byworkselectid/{id}",method=RequestMethod.GET)
	public Object select(@PathVariable("id") int id,Map<String, Object> map){
		map.put("hr_emp_id", id);
		return  hrWorkhistoryService.selectworkby(map);
	}
	@ResponseBody
	@RequestMapping(value="/byworkselectid",method=RequestMethod.GET)
	public Object showwork(Map<String, Object> map){
		List<String> selectempid = empService.selectempid();
		Integer id= Integer.valueOf(selectempid.get(0));
		map.put("hr_emp_id", id+1);
		return  hrWorkhistoryService.selectworkby(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatework",method=RequestMethod.GET)
	public Object update(HrWorkhistory hrWorkhistory) throws IOException{
		return HRBoolean.yesOrNo(hrWorkhistoryService.updatework(hrWorkhistory));
	}
	
	@ResponseBody
	@RequestMapping(value="/workdeletebyid/{id}",method=RequestMethod.GET)
	public Object delete(@PathVariable("id") int id) throws IOException{
		return HRBoolean.yesOrNo(hrWorkhistoryService.deletework(id));
	}
	@ResponseBody
	@RequestMapping(value="/insertwork",method=RequestMethod.GET)
	public Object insert(HrWorkhistory hrWorkhistory){
		List<String> selectempid = empService.selectempid();
		Integer id= Integer.valueOf(selectempid.get(0))+1;
		hrWorkhistory.setHrEmpId(id);
		return HRBoolean.yesOrNo(hrWorkhistoryService.insertwork(hrWorkhistory));
	}
	@ResponseBody
	@RequestMapping(value="/insertworkid/{id}",method=RequestMethod.GET)
	public Object insertwork(@PathVariable("id")int id,HrWorkhistory hrWorkhistory){
		hrWorkhistory.setHrEmpId(id);
		return HRBoolean.yesOrNo(hrWorkhistoryService.insertwork(hrWorkhistory));
	}
	
}
