package com.jt.lawfirm.controller.anjian;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.finance.CaseType;
import com.jt.lawfirm.service.anjian.CaseService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class addCase {
	
	@Resource
	private CaseService caseService;
	@RequiresPermissions(value= {"anjian:xzaj","admin","test"},logical=Logical.OR)
	@RequestMapping("addCase")
	public String addCase() {
		return "anjian/addCase1";
	}
	
	//下面菜单
	@RequestMapping("CaseCols2")
	@ResponseBody
	public Object CaseCols2(String Cols) {
		System.out.println(Cols);
		Myoc.Ioc().put("anjianType", Integer.parseInt(Cols));
		List<CaseType> caseList = caseService.findCaseType(Integer.parseInt(Cols));
		System.out.println(caseList);
		return caseList; 
	}
	
	//addCase1
	@RequestMapping("addCase1")
	public String addCase1() {
		return "anjian/addCase1";
	}
	
	//addCase2
	@RequestMapping("addCase2")
	public String addCase2() {
		return "anjian/addCase2";
	}		
	//addCase3
	@RequestMapping("addCase3")
	public String addCase3() {
		return "anjian/addCase3";
	}
	//addCase4
	@RequestMapping("addCase4")
	public String addCase4() {
		return "anjian/addCase4";
	}	

	//addCase5
	@RequestMapping("addCase5")
	public String addCase5() {
		return "anjian/addCase5";
	}
	//addCase5_1
	@RequestMapping("addCase5_1/{time}")
	public String addCase5_1() {
		return "anjian/addCase5_1";
	}
	
	//addCase6
	@RequestMapping("addCase6/{time}")
	public String addCase6() {
		return "anjian/addCase6";
	}
	
	//addCase4  添加 law
	@RequestMapping(value="addCaseForm",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addCaseForm(Law law,String clientname,HttpServletRequest request) {
		System.out.println("+++++++++++++++++++++++law" + law);
		System.out.println("+++++++++++++++++++++++clientname" + clientname);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String userName = (String) request.getSession().getAttribute("userName");
		map.put("userName", userName);//---------------------------------->登陆人账号***
		System.out.println("---------------------------------->登陆人账号***" + userName);
		
		Integer empId =  caseService.findEmpById(map);
		law.setSystemApprovalId(empId);
		
		if(!clientname.equals("null") && !"".equals(clientname.trim())) {
			Integer clientId = caseService.selClientByName(clientname,empId);
			System.out.println("clientname"+clientname);
			law.setClientId(clientId);
			
		}else {
			Integer clientId = (Integer) Myoc.Ioc().get("clientId");
			System.err.println("clientId" + clientId);
			law.setClientId(clientId);
		}
		
		
		Integer anjianType = (Integer)Myoc.Ioc().get("anjianType");
		System.out.println("添加law 表中的 anjianType ==" + anjianType);
		law.setCaseCaseTypeId(anjianType);
		try {
			Integer boo = caseService.addCaseLaw(law);
			Myoc.Ioc().remove("anjianType");
			Myoc.Ioc().remove("clientId");
			return law.getCasePropernum();
		} catch (Exception e) {
			return "false";
		}
	}
	
		//判断案号
		@RequestMapping("myanjianHaoYN/{anjianHao}")
		@ResponseBody
		public Object anjianHaoYN(@PathVariable("anjianHao") String anjianHao) {
			Integer law = caseService.anjianHaoYN(anjianHao);
			//System.out.println("判断案号--------------" + law);
			return law;
		}	
	
		//addCase5_1添加	文书表CaseSealApplyfor
	
		@RequestMapping(value="addCaseSealApplyfor/{applyfor}/{anhao}",method=RequestMethod.POST)
		@ResponseBody
		public boolean addCaseSealApplyfor(@PathVariable("applyfor")String applyfor,
											@PathVariable("anhao")String anhao,
											CaseSealApplyfor cs,HttpServletRequest request) {
			System.out.println(applyfor);
			System.out.println("-----" + anhao);
			String[] split = null;
			if(applyfor.contains(",")) {
				split = applyfor.split(",");
			}else {
				 split = new String[]{applyfor};
			}
			
			int year = LocalDate.now().getYear();
			String user = (String) request.getSession().getAttribute("userName");
			//查询案号id
			Integer case_law_id = caseService.anjianHaoSel(anhao);
			boolean boo =false;
			for (String string : split) {
				int count =  (int)(Math.random()*1000);
				//在前面补0
				 DecimalFormat df=new DecimalFormat("0000");
			     String str2=df.format(count);
				cs.setSanum("("+year+")"+"巨天民第"+str2+"号");
				
				cs.setCase_law_id(case_law_id);
				cs.setApplyforReceive(LocalDate.now().toString());
				cs.setApplyforApprovalStatus("未审批");
				
				cs.setApplyforRecipient(user);
				cs.setApplyforUsingTheItem(string);
				
				 boo = caseService.addCaseSealApplyfor(cs);
			}
			return boo;
		}
		
		
		
		//addCase6 查  用印记录
		@RequestMapping(value="ajaxCaseSealApplyfor",method=RequestMethod.POST)
		@ResponseBody
		public Object ajaxCaseSealApplyfor(Integer offset,
				Integer limit,String anhao,
				String casePropernum,
				String applyfor_using_the_item,
				String applyfor_approval_status,HttpServletRequest request) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("anhao",anhao);
			map.put("casePropernum",casePropernum);
			map.put("applyfor_using_the_item",applyfor_using_the_item);
			map.put("applyfor_approval_status",applyfor_approval_status);
			
			String userName = (String) request.getSession().getAttribute("userName");
			map.put("userName", userName);//---------------------------------->登陆人账号***
			System.out.println("---------------------------------->登陆人账号***" + userName);
			
			System.err.println("+++++++++++++++++++++++++"+map);
			Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);
			List<Map<String,Object>> CaseSealApplyfor = caseService.ajaxCaseSealApplyfor(map);
			Map<String,Object>  CaseSealApplyforMap = new HashMap<String,Object>();
			CaseSealApplyforMap.put("total", startPage.getTotal());
			CaseSealApplyforMap.put("rows", CaseSealApplyfor);
			return CaseSealApplyforMap;
		}
		
				
	/**
	 * 
	 * pdf	
	 */
		@RequestMapping(value="pdf",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
		@ResponseBody
		public String pdf(String fileName, HttpServletRequest request) {
			
			return fileName+".pdf";
		}
		
		
}
