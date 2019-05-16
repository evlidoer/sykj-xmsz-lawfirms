package com.jt.lawfirm.controller.anjian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.anjian.CaseInvestigation;
import com.jt.lawfirm.bean.anjian.CaseProcuratorialWork;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.service.anjian.KaiTingMsgService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class KaiTingMsgController {
			
	@Resource
	private KaiTingMsgService kaiTingMsgService;
	
	@RequiresPermissions(value= {"anjian:kt","admin","test"},logical=Logical.OR)
	@RequestMapping("kaitingMsg")
	public String CasecHoldAHearing() {
		return "anjian/kaitingMsg";
	}
	
	//-------------------------------------------------------------------------
	//显示表格 ajaxCasecHoldAHearing  -----> 开庭信息
	@RequestMapping(value="ajaxCasecHoldAHearing",method=RequestMethod.POST)
	@ResponseBody
	public Object ajaxCasecHoldAHearing(CasecHoldAHearing ch,HttpServletRequest request,Law law,Integer offset,Integer limit) {
		
		//Page<Object> startPage = PageHelper.startPage(offset/limit+1,limit);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("casePropernum", law.getCasePropernum());
		map.put("hearingcourt", ch.getHearingcourt());
		map.put("hearingholdacoutstatus", ch.getHearingholdacoutstatus());
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		System.out.println("---------------------------------->登陆人账号***" + userName);
		
		System.out.println(map);
		
		List<Map<String,Object>> chList =  kaiTingMsgService.casecHoldAHearingShow(map);
		
		//Map<String,Object> chListMap = new HashMap<String,Object>();
		//map.put("total", startPage.getTotal());
		//map.put("rows", chList);
		return chList;
	}
	
	
	//跳转添加页面			开庭添加
	@RequestMapping(value="kaitingMsgAdd")
	public String CasecHoldAHearingAdd(CasecHoldAHearing ch,Map<String,Object> map) {
		return "anjian/kaitingMsgAdd";
	}
	//开庭添加
	@RequestMapping(value="CasecHoldAHearingFormAdd",method=RequestMethod.POST)
	@ResponseBody
	public Object CasecHoldAHearingFormAdd(CasecHoldAHearing ch,Law law) {
		ch.setHearingholdacoutstatus("未开庭");
		ch.setCaselawid(law.getId());
		ch.setId(null);//设置为null 要不id冲突
		boolean boo =  kaiTingMsgService.CasecHoldAHearingFormAdd(ch);
		return boo?"true":"false";
	}	
	
	//----------------------------------------------------------------------------
	
	//显示表格                                    -----> 侦查机关信息
			@RequestMapping(value="ajaxZhenCha",method=RequestMethod.POST)
			@ResponseBody
			public Object ajaxZhenCha(CaseInvestigation ci,HttpServletRequest request,Law law,Integer offset,Integer limit) {
				
				//Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("casePropernum", law.getCasePropernum());
				map.put("investigationOffice", ci.getInvestigationOffice());
				
				String userName = (String) request.getSession().getAttribute("userName");
				map.put("userName", userName);//---------------------------------->登陆人账号***
				System.out.println("---------------------------------->登陆人账号***" + userName);
				
				System.out.println(map);
			
				List<Map<String,Object>> ciList =  kaiTingMsgService.zhenChaShow(map);
				//Map<String,Object> ciListMap = new HashMap<String,Object>();
				//map.put("total", startPage.getTotal());
				//map.put("rows", ciList);
				
				return ciList;
			}
			//跳转添加页面			侦查添加
			@RequestMapping(value="scoutAdd")
			public String scoutAdd() {
				return "anjian/kaitingMsgZCAdd";
			}
				//添加			侦查添加
			@RequestMapping(value="kaitingMsgZCAdd")
			@ResponseBody
			public String kaitingMsgZCAdd(CaseInvestigation ci,Law law) {
				ci.setCaseLawId(law.getId());
				ci.setId(null);//设置为null 要不id冲突
				boolean boo = kaiTingMsgService.kaitingMsgZCAdd(ci);
				return boo?"true":"false";
			}
	
	
	//----------------------------------------------------------------------------
	
	
			//显示表格 								  -----> 检查机关信息
			@RequestMapping(value="ajaxJianCha",method=RequestMethod.POST)
			@ResponseBody
			public Object ajaxJianCha(CaseProcuratorialWork cpw,HttpServletRequest request,Law law,Integer offset,Integer limit) {
				//Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("casePropernum", law.getCasePropernum());
				map.put("workOffice", cpw.getWorkOffice());
				
				String userName = (String) request.getSession().getAttribute("userName");
				map.put("userName", userName);//---------------------------------->登陆人账号***
				System.out.println("---------------------------------->登陆人账号***" + userName);
					
				System.out.println(map);
				
				List<Map<String,Object>> cpList =  kaiTingMsgService.JianChaShow(map);
				//Map<String,Object> cpListMap = new HashMap<String,Object>();
				//map.put("total", startPage.getTotal());
				//map.put("rows", cpList);
				return cpList;
			}
		
	
	//跳转添加页面			jian查添加
	@RequestMapping(value="examineAdd")
	public String examineAdd(CasecHoldAHearing ch,Map<String,Object> map) {
		return "anjian/kaitingMsgJCAdd";
	}
	
		
	@RequestMapping(value="kaitingMsgJCAdd",method=RequestMethod.POST)
	@ResponseBody
	public String kaitingMsgJCAdd(CaseProcuratorialWork cp,Law law) {
		cp.setCaseLawId(law.getId());
		cp.setId(null);//设置为null 要不id冲突
		boolean boo = kaiTingMsgService.kaitingMsgJCAdd(cp);
		return boo?"true":"false";
	}
	
	
	//删除
	
	//
	// 
		@RequestMapping(value="delKaiTing/{id}")
		@ResponseBody
		public Object delKaiTing(@PathVariable("id") Integer id) {
			boolean boo = kaiTingMsgService.delKaiTing(id);
			return boo;
		}
		@RequestMapping(value="delZhenCha/{id}")
		@ResponseBody
		public Object delZhenCha(@PathVariable("id") Integer id) {
			boolean boo = kaiTingMsgService.delZhenCha(id);
			return boo;
		}
		@RequestMapping(value="delJianCha/{id}")
		@ResponseBody
		public Object delJianCha(@PathVariable("id") Integer id) {
			boolean boo = kaiTingMsgService.delJianCha(id);
			return boo;
		}
	
	
	
}

