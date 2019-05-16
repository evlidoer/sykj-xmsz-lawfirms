package com.jt.lawfirm.controller.hr;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.HrInsured;
import com.jt.lawfirm.bean.hr.HrPunishment;
import com.jt.lawfirm.bean.hr.HrReward;
import com.jt.lawfirm.service.hr.IHrEmpService;
import com.jt.lawfirm.service.hr.IHrIdentService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.HRBoolean;
@Controller
@RequestMapping(value="/hr/emp")
public class hrempController {
	
	@Resource(name="hrempservice")
	private IHrEmpService empService;
	@Resource(name="hrIdentServie")
	private IHrIdentService hrIdentService;
	
	@ResponseBody
	@RequestMapping(value="/byidselect/{id}",method=RequestMethod.GET)
	public Object selectbyid(@PathVariable("id") int id,Map<String, Object> map){
		map.put("id", id);
		return empService.selectbyid(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(HrEmp hremp){
		return HRBoolean.yesOrNo(empService.updatebyid(hremp));
	}
	
	@ResponseBody
	@RequestMapping(value="/updatecb",method=RequestMethod.POST)
	public Object updatecb(Map<String, Object> map,String insuredName,String id,String hrEmpId){
		boolean b = false;
		if (id.equals("")) {
			map.put("hrEmpId", hrEmpId);
			map.put("insuredName", insuredName);
			b = empService.insertcb(map);
		}else {
			map.put("insuredName", insuredName);
			map.put("id", id);
			b= empService.updatecb(map);
		}
		return HRBoolean.yesOrNo(b);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deletebyid/{id}",method=RequestMethod.GET)
	public Object delete(@PathVariable("id") int id,Map<String, Object> map){
		map.put("hr_emp_id", id);
		return HRBoolean.yesOrNo(empService.deletebyid(id,map));
	}
	
	@ResponseBody
	@RequestMapping(value="/selectcase",method=RequestMethod.POST)
	public Object selectcase(@RequestParam("casetypename") String casetypename){
		return empService.selectcase(casetypename);
	}
	
	@ResponseBody
	@RequestMapping(value="/deletebyidback",method=RequestMethod.GET)
	public Object delete(Map<String, Object> map){
		List<String> selectempid = empService.selectempid();
		Integer id = Integer.valueOf(selectempid.get(0))+1;
		map.put("hr_emp_id", id);
		return HRBoolean.yesOrNo(empService.deletebyid(id,map));
	}
	
	@ResponseBody
	@RequestMapping(value="/insertidentsx",method=RequestMethod.POST)
	public Object insertidentsx(HrIdent hrIdent,String insuredName){
		List<String> selectempid = empService.selectempid();
		HrInsured insured = new HrInsured();
		Integer integer = Integer.valueOf(selectempid.get(0));
		insured.setHrEmpId(integer);
		insured.setInsuredName(insuredName);
		hrIdent.setHrEmpId(integer);
		hrIdent.setLawyerIdentity_id(2);
		return HRBoolean.yesOrNo(empService.addident(hrIdent, insured));
	}
	@ResponseBody
	@RequestMapping(value="/insertidentfz",method=RequestMethod.POST)
	public Object insertidentfz(HrIdent hrIdent,String insuredName){
		HrInsured insured = new HrInsured();
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0));
		insured.setHrEmpId(integer);
		insured.setInsuredName(insuredName);
		hrIdent.setHrEmpId(integer);
		hrIdent.setLawyerIdentity_id(3);
		return HRBoolean.yesOrNo(empService.addident(hrIdent, insured));
	}
	@ResponseBody
	@RequestMapping(value="/insertemp",method=RequestMethod.POST)
	public Object inseremp(MultipartFile file ,HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String, String> map = AutoConversion.conversionToMap(request);
		String path = request.getServletContext().getRealPath("/upload");
		if(file != null) {
			String s = file.getOriginalFilename();
			String sub = s.substring(s.lastIndexOf("."), s.length());
			String pro = s.substring(0,s.lastIndexOf("."));
			File f = new File(path, pro + "." + new Date().getTime() + sub);
			file.transferTo(f);
			System.out.println(f.getAbsolutePath());
			map.put("Picturepath", f.getAbsolutePath());
		}
		List<String> selectempid = empService.selectempid();
		Integer id = Integer.valueOf(selectempid.get(0));
		System.out.println(id);
		map.put("empStatus","已审核");
		return HRBoolean.yesOrNo(empService.insert(map, id));
	}
	
	@ResponseBody
	@RequestMapping(value="/inserident",method=RequestMethod.POST)
	public Object inserident(HrIdent ident,String insuredName) {
		HrInsured insured = new HrInsured();
		System.out.println(insuredName);
		ident.setLawyerIdentity_id(1);
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0));
		insured.setHrEmpId(integer);
		insured.setInsuredName(insuredName);
		ident.setHrEmpId(integer);
		return HRBoolean.yesOrNo(empService.addident(ident,insured));
	}
	@ResponseBody
	@RequestMapping(value="/inserreward",method=RequestMethod.GET)
	public Object insertreward(HrReward hrReward,String insuredName) {
		System.out.println(hrReward);
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0))+1;
		hrReward.setHrEmpId(integer);
		return HRBoolean.yesOrNo(empService.addreward(hrReward));
	}
	@ResponseBody
	@RequestMapping(value="/inserpun",method=RequestMethod.GET)
	public Object insertpun(HrPunishment hrPunishment,String insuredName) {
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0))+1;
		hrPunishment.setHrEmpId(integer); 
		return HRBoolean.yesOrNo(empService.addpun(hrPunishment));
	}
	
	@ResponseBody
	@RequestMapping(value="/inserrew/{id}",method=RequestMethod.GET)
	public Object insertrewardid(@PathVariable("id")int id,HrReward hrReward,String insuredName) {
		hrReward.setHrEmpId(id);
		return HRBoolean.yesOrNo(empService.addreward(hrReward));
	}
	@ResponseBody
	@RequestMapping(value="/inserpun/{id}",method=RequestMethod.GET)
	public Object insertpunid(@PathVariable("id")int id,HrPunishment hrPunishment,String insuredName) {
		hrPunishment.setHrEmpId(id); 
		return HRBoolean.yesOrNo(empService.addpun(hrPunishment));
	}
	
	
	@ResponseBody
	@RequestMapping(value="/selectrew",method=RequestMethod.GET)
	public Object selectrew(Map<String, Object> map) {
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0))+1;
		map.put("hr_emp_id", integer);
		return empService.selectrew(map);
	}
	@ResponseBody
	@RequestMapping(value="/selectpun",method=RequestMethod.GET)
	public Object selectpun(Map<String, Object> map) {
		List<String> selectempid = empService.selectempid();
		Integer integer = Integer.valueOf(selectempid.get(0))+1;
		map.put("hr_emp_id", integer);
		return empService.selectpun(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectrewid/{id}",method=RequestMethod.GET)
	public Object selectrewbyid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("id", id);
		return empService.selectrew(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectpunid/{id}",method=RequestMethod.GET)
	public Object selectpunbyid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("id", id);
		return empService.selectpun(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectrewbyid/{id}",method=RequestMethod.GET)
	public Object selectrewid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("hr_emp_id", id);
		return empService.selectrew(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectpunbyid/{id}",method=RequestMethod.GET)
	public Object selectpunid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("hr_emp_id", id);
		return empService.selectpun(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selrewbyid/{id}",method=RequestMethod.GET)
	public Object selrewbyid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("id", id);
		return empService.selectrew(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/selpunbyid/{id}",method=RequestMethod.GET)
	public Object selpunbyid(@PathVariable("id") int id,Map<String, Object> map) {
		map.put("id", id);
		return empService.selectpun(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/uprew",method=RequestMethod.GET)
	public Object uprewbyid(HrReward hrReward) {
		return HRBoolean.yesOrNo(empService.uprew(hrReward));
	}
	
	@ResponseBody
	@RequestMapping(value="/uppun",method=RequestMethod.GET)
	public Object uppunbyid(HrPunishment hrPunishment) {
		return HRBoolean.yesOrNo(empService.uppun(hrPunishment));
	}
	
	@ResponseBody
	@RequestMapping(value="/deleterew/{id}",method=RequestMethod.GET)
	public Object deleterewbyid(@PathVariable("id") int id) {
		return HRBoolean.yesOrNo(empService.deleterew(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/deletepun/{id}",method=RequestMethod.GET)
	public Object deletepunbyid(@PathVariable("id") int id) {
		return HRBoolean.yesOrNo(empService.deletepun(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/selectins/{id}",method=RequestMethod.GET)
	public Object selectins(@PathVariable("id") String id){
		System.err.println(id);
		return empService.selectins(id);
	}
}
