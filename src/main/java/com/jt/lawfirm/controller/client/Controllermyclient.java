package com.jt.lawfirm.controller.client;
import java.util.ArrayList;
import java.util.Date;
//王立冬
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.client.AddclientBean;
import com.jt.lawfirm.bean.client.Client;
import com.jt.lawfirm.service.anjian.CaseService;
import com.jt.lawfirm.service.client.IMyclientService;
import com.jt.lawfirm.util.AutoConversion;
import com.jt.lawfirm.util.ExportFile;
import com.jt.lawfirm.util.Myoc;
//王立冬
@Controller
public class Controllermyclient {
	@Autowired
	private IMyclientService clientService;
	
	@Resource
	private CaseService caseService;
	
	
	//我的客户查看
	@RequestMapping(value="myclient")
	@ResponseBody
	public PageBean show(Map<String,Object> map,HttpServletRequest request ){
		Map<String,Object> cmap = new HashMap<>();
		String plimit = request.getParameter("limit");
		String poffset = request.getParameter("offset");
		String client = request.getParameter("client");
		String tel = request.getParameter("tel");
		String clientAssign = request.getParameter("clientAssign");
		String clientStuatus = request.getParameter("clientStuatus");
		
		if(client!=null&&client!=""){
			cmap.put("client","%"+client+"%");
		}
		if(tel!=null&&tel!=""){
			cmap.put("tel","%"+tel+"%");
		}
		if(clientAssign!=null&&clientAssign!=""){
			cmap.put("clientAssign",clientAssign);
		}
		if(clientStuatus!=null&&clientStuatus!=""){
			cmap.put("clientStuatus",clientStuatus);
		}
		
		PageBean pb = new PageBean();
		if(plimit!=null&&plimit!=""){
			Integer limit = Integer.parseInt(plimit);
			pb.setLimit(limit);
		}
		if(poffset!=null&&poffset!=""){
			Integer offset  = Integer.parseInt(poffset);
			pb.setOffset(offset);
		}
		
		cmap.put("pb",pb);
		List<Client> selectAll = clientService.SelectAll(cmap);
		
		System.err.println(selectAll);
		return pb;
	}
	//我的客户添加
	 
	@RequestMapping("addclient")
	public String add(AddclientBean client,HttpServletRequest request){
		

		Date time = new Date(new Date().getTime());
		client.setClientAddtime(time);
		
		clientService.Insertclient_insertTetail_Insertmsg(client);
		return "redirect:/gotomyclient";
		
	}
	@RequestMapping("gotoupdateclient")
	public String gotoupdate(){
		return "client/updateclient";
	}
	//客户修改
	@RequestMapping("updatelient")
	public String update(AddclientBean client){
		clientService.updateclient_updateclientdetail_updateclientmsg(client);
		return "redirect:/gotomyclient";
	}
	
	
	//查看详情页面转跳
	@RequestMapping("gotoclientSel")
	public String clientSelect(){
		return "client/clientSelect";
	}
	//查看详情
	@RequestMapping("clientSelect/{id}")
	@ResponseBody
	public List<AddclientBean> select(@PathVariable("id")Integer id){
		System.err.println(id);
		List<AddclientBean> selectClient = clientService.SelectClient(id);
		return selectClient;
	}
	
	@ResponseBody
	@RequestMapping("lawnum/{id}")
	public int lawnum(@PathVariable("id") Integer id){
		System.out.println("clientid=="+id);
		int lawnum = clientService.lawNumber(id);
		System.err.println(lawnum);
		return lawnum;
	}
	@ResponseBody
	@RequestMapping("delete/{id}")
	public int del(@PathVariable("id") Integer id){
		int  del = clientService.deleteById(id);
		return del;
	}
	@ResponseBody
	@RequestMapping("cientname/{client}")
	public int selname(@PathVariable("client") String client,HttpServletRequest request){
		
		
		String userName = (String) request.getSession().getAttribute("userName");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);//---------------------------------->登陆人账号***
		Integer empId =  caseService.findEmpById(map);
		System.out.println(empId);
		int count =  clientService.clientcount(client,empId);
		System.err.println(count);
		return count;
	}
	@ResponseBody
	@RequestMapping("clientLawById/{id}")
	public List<Map<String,Object>> clientlaw(@PathVariable("id") Integer id){
		List<Map<String,Object>> clientlaw = clientService.SelectLawById(id);
		return clientlaw;
	}
	//跳转emp页面
	@RequestMapping("gotoempSelect")
	public String show(){
		return "client/emp";
	}
	//emp查询
	@ResponseBody
	@RequestMapping("empSelect")
	public PageBean empSelect(Map<String,Object> map,HttpServletRequest request){
		Map<String,Object> cmap = new HashMap<>();
		String plimit = request.getParameter("limit");
		String poffset = request.getParameter("offset");
		String empname = request.getParameter("empname");
		PageBean pb = new PageBean();
		if(plimit!=null&&plimit!=""){
			Integer limit = Integer.parseInt(plimit);
			pb.setLimit(limit);
		}
		if(poffset!=null&&poffset!=""){
			Integer offset  = Integer.parseInt(poffset);
			pb.setOffset(offset);
		}
		if(empname!=null&&empname!=""){
			cmap.put("empname","%"+empname+"%");
		}
		cmap.put("pb",pb);
		List<Map<String,Object>> listmap = clientService.Selectemp(cmap);
		return pb;
	}
	
	//客户转送
	@ResponseBody
	@RequestMapping("updateempclient")
	public int updateempclient(HttpServletRequest request,Integer empid,Integer clientid){
		Map<String,Object> map = new HashMap<>();
		if(empid!=null&&empid!=0&&clientid!=null&&clientid!=0){
			map.put("clientid",clientid);
			map.put("empid",empid);
		}
		int number = clientService.updateclientEmp(map);
	
		return number;
	}
	
	//导出客户
	@RequestMapping("export")
	public String export(HttpServletResponse response, HttpServletRequest request){
		Map<String,Object> cmap = new HashMap<>();
		String client = request.getParameter("client");
		String tel = request.getParameter("tel");
		String clientAssign = request.getParameter("clientAssign");
		String clientStuatus = request.getParameter("clientStuatus");
		
		if(client!=null&&client!=""){
			cmap.put("client","%"+client+"%");
		}
		if(tel!=null&&tel!=""){
			cmap.put("tel","%"+tel+"%");
		}
		if(clientAssign!=null&&clientAssign!=""){
			cmap.put("clientAssign",clientAssign);
		}
		if(clientStuatus!=null&&clientStuatus!=""){
			cmap.put("clientStuatus",clientStuatus);
		}
		ExportFile.exportExcelOfS(response,"client", getMap(), clientService.SelectAllexport(cmap));
		return null;
	}
	
	private List<Map<String, Object>> getMap() {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, String> listMap = new HashMap<String, String>();
		list.put("sheetName", "Table1");
		listMap.put("client", "姓名");
		listMap.put("tel", "手机号码");
		listMap.put("client_type", "客户类型");
		listMap.put("idnumber", "证件号");
		listMap.put("caseOppositeParties", "对方当事人");
		listMap.put("type", "类型");
		listMap.put("industry", "产业");
		listMap.put("company_scale", "公司规模");
		listMap.put("idtype", "公司规模");
		listMap.put("company_scale", "身份特点");
		listMap.put("client_principal", "主要负责人");
		listMap.put("client_contacts", "业务联系人");
		listMap.put("client_email", "邮箱");
		listMap.put("client_duty", "职务");
		listMap.put("clientinfluence", "地区影响力");
		listMap.put("client_phone", "固定电话");
		listMap.put("client_region", "所属地区");
		listMap.put("client_stuatus", "客户状态");
		listMap.put("client_behalf", "法定代表人");
		listMap.put("client_legalphone", "法人联系方式");
		listMap.put("client_idcard", "身份证");
		listMap.put("client_nation", "民族");
		listMap.put("client_sex", "性别");
		listMap.put("client_site", "详细");
		listMap.put("client_birth", "出生日期");
		listMap.put("client_remark", "备注");
		listMap.put("client_addtime", "入库时间");
		
		list.put("sheetVal", listMap);
		List<Map<String, Object>> tableName = new ArrayList<Map<String, Object>>();
		tableName.add(list);
		return tableName;
	}
	//客户选择
	@RequestMapping("gotoclientSelname")
	public String clientshow(){
		return "client/clientSel";
	}
	//服务记录
	@ResponseBody
	@RequestMapping("logSelectById/{id}")
	public List<Map<String,Object>> logSelectById(@PathVariable("id") Integer id){
		List<Map<String,Object>> listmap = 	clientService.logSelectById(id);
		return listmap;
	}
	//查看是否有重复证件号
	@RequestMapping("idnumberSel")
	@ResponseBody
	public int idnumberSel(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
	String idnumber =  request.getParameter("idnumber");
	String clientid = request.getParameter("clientid");
	System.out.println(idnumber+"======"+clientid);
	map.put("idnumber",idnumber);
	if(clientid!=null&&clientid!=""){
		int client_id = Integer.parseInt(clientid);
		map.put("clientid",client_id);
	}
	 int number = clientService.foridnumber(map);
		return number;
	}
	//查看是否有重复的身份证号
	@RequestMapping("clientIdcardSel")
	@ResponseBody
	public int clientIdcardSel(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		String clientIdcard =  request.getParameter("clientIdcard");
		String clientid = request.getParameter("clientid");
		map.put("clientIdcard",clientIdcard);
		if(clientid!=null&&clientid!=""){
			int client_id = Integer.parseInt(clientid);
			map.put("clientid",client_id);
		}
		int number = clientService.forclientIdcardSel(map);
		return number;
	}
	
	//----------------------------------------------------liyang
	//我的客户添加
		@RequestMapping("addclientLy")
		public String addclientLy(AddclientBean client,HttpServletRequest request){
			
			String userName = (String) request.getSession().getAttribute("userName");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", userName);//---------------------------------->登陆人账号***
			Integer empId =  caseService.findEmpById(map);
		
			client.setEmpId(empId);
			
			Date time = new Date(new Date().getTime());
			client.setClientAddtime(time);
			clientService.Insertclient_insertTetail_Insertmsg(client);
			Myoc.Ioc().put("clientId",client.getId());
			System.out.println("client--"+client.getId());
			return "anjian/addCase4";
			
		}
	///_------------------------------------------------------------------------------
}
