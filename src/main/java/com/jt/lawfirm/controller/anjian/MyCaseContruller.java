package com.jt.lawfirm.controller.anjian;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
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
import com.jt.lawfirm.bean.anjian.CaseCostRelief;
import com.jt.lawfirm.bean.anjian.CaseServiceLog;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.service.anjian.CaseService;
import com.jt.lawfirm.util.Myoc;

@Controller
public class MyCaseContruller {

	@Resource
	private CaseService caseService;
	
	@RequiresPermissions(value= {"anjian:wdaj","admin","test"},logical=Logical.OR)
	@RequestMapping("myCase")
	public String myCase() {
		return "anjian/myCase";
	}
	
	
	
	//表格显示
	//显示案件  加上面菜单不同显示,加 模糊查询
		@RequestMapping(value="/ajaxlaw",method=RequestMethod.POST)
		@ResponseBody								//委托人              //当事人
		public Object ajaxlaw(Law law,String btn1,
													String btn2,
													String btn3,
													String btn4,
													String btn5,
													String btn6,
													String btn7,
													Integer offset,
													Integer limit,HttpServletRequest request) {
			//System.out.println(btn1 + btn2+ btn3+ btn4+ btn5+ btn6+ btn7 + "-----------");
			Map<String,Object> map = new HashMap<>();
			System.out.println(map);
			map.put("btn1", btn1);//我的案件
			map.put("btn2", btn2);//在办案件
			map.put("btn3", btn3);//已结案件
			map.put("btn4", btn4);//我的合办
			map.put("btn5", btn5);//共享
			map.put("btn6", btn6);//代收款
			map.put("btn1", btn7);//我的
			map.put("casePropernum", law.getCasePropernum());//案号
			map.put("caseApproveStatus", law.getCaseApproveStatus());//收案审批
			map.put("caseSettleStatus", law.getCaseSettleStatus());//结案状态
			map.put("caseCaseTypeId", law.getCaseCaseTypeId()); //案件类型
			map.put("caseAssign", law.getCaseAssign());//指派
			String userName = (String) request.getSession().getAttribute("userName");
			map.put("userName", userName);//---------------------------------->登陆人账号***
			System.out.println("---------------------------------->登陆人账号***" + userName);
			Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);
			
			
			
			System.out.println(map);    					//=====>都有值 就剩写sql
			List<Map<String, Object>> lawList = caseService.myCasefindCase(map);
			
			Map<String,Object> lawListMap = new HashMap<String,Object>();
			lawListMap.put("total", startPage.getTotal());
			lawListMap.put("rows", lawList);
			System.out.println(lawList);
			return lawListMap;
		}
	
	
	
	
	
	
	
	
	
	/**
	 * *****************************************************************
	 * 	我的案件       	操作
	 *   1.修改跳转
	 * @param id
	 * @return
	 */
	//修改跳转
		@RequestMapping("myCaseSkip/{id}/{time}")
		public String myCaseSkip1(@PathVariable("id") Integer id) {
			Myoc.Ioc().put("id1", id);
			System.out.println("修改id========"+ id);
			return "anjian/myCaseUpdate";
		}
		
		//ajax请求查询显示修改项
		@RequestMapping(value="ajaxMyCasebyId",method=RequestMethod.POST)
		@ResponseBody
		public Object myCaseById() {
			Integer id = (Integer) Myoc.Ioc().get("id1");
			System.out.println("--------------------------" + id);
			List<Map<String, Object>> law = caseService.myCaseById(id);    
			
			return law;
		}
		
		
		//修改
		@RequestMapping(value="myCaseUpdate",method=RequestMethod.POST)
		@ResponseBody
		public Object myCaseUpdate(Law law) {
			Integer id = (Integer) Myoc.Ioc().get("id1");
			law.setId(id);
			System.out.println("11111111111111111---" + id);
			boolean bool = caseService.myCaseUpdate(law);     ///     ====>写修改sql
			Myoc.Ioc().remove("id1");
			System.err.println(bool);
			return bool?"1":"";
		}
		
		/**myCaseOperate3.html
		 * 2 .费用减免申请
		 */
		//费用减免申请 页面跳转
		@RequestMapping("myCaseSkip2/{id}/{time}")
		public String myCaseSkip2(@PathVariable("id") Integer id) {
			Myoc.Ioc().put("id2", id);
			System.out.println("id==========" + id);
			return "anjian/myCaseOperate2";
		}		
		//显示数据
		@RequestMapping("myCaseEmpshow")
		@ResponseBody
		public Object myCaseEmpshow() {   	//显示案件信息以及,,案件所属的登录账号人
			Integer id = (Integer) Myoc.Ioc().get("id2");
			List<Map<String,Object>> lawList = caseService.myCaseEmpById(id);   
			System.out.println(lawList);
			Myoc.Ioc().remove("id2");
			return lawList;
		}
		
		//提交申请      把数据添加到 案件费用减免记录 表    (form表单提交过来的  ajax过不来)
		@RequestMapping(value="myCaseSubmit",method=RequestMethod.POST)
		public String myCaseSubmit(CaseCostRelief ccr) {
			System.err.println(ccr.toString()); 
			ccr.setReliefapprovalstatus("N");
			boolean boo = caseService.addCaseCostRelief(ccr);//添加 案件费用减免记录 表case_cost_relief
			
			return "anjian/feiyong";  //添加成功直接跳转页面
		}


		
		/**myCaseOperate3.html
		 * 3 .收款方式
		 */
		@RequestMapping("myCaseSkip3/{id}/{time}")
		public String myCaseSkip3(@PathVariable("id") Integer id) {
			Myoc.Ioc().put("id3", id);
			return "anjian/myCaseOperate3";
		}				
		@RequestMapping("myCaseOperate3Show")
		@ResponseBody
		public Object myCaseOperate3Show() {
			Integer id = (Integer) Myoc.Ioc().get("id3");
			List<Map<String, Object>> law = caseService.myCaseById(id);  
			return law;
		}
		//修改付款金额
		
		@RequestMapping("myCaseOperate3Up")
		@ResponseBody
		public Object myCaseOperate3Up(Integer id,double PayPrice) {
			boolean boo = caseService.myCaseOperate3Up(id,PayPrice);  
			return boo?"1":"";
		}
		
		/**myCaseOperate4.html
		 * 4 .结案
		 */
		@RequestMapping("myCaseSkip4/{id}/{time}")
		public String myCaseSkip4(@PathVariable("id") Integer id) {
			Myoc.Ioc().put("id4", id);
			return "anjian/myCaseOperate4";
		}
		//显示数据
		@RequestMapping("myCaseOperate4show")
		@ResponseBody
		public Object myCaseOperate4show() {   	//显示案件信息以及,,案件所属的登录账号人
			Integer id = (Integer) Myoc.Ioc().get("id4");
			List<Map<String,Object>> lawList = caseService.myCaseEmpById(id);   
			System.out.println(lawList);
			return lawList;
		}			
		//结案提交
		@RequestMapping(value="myCaseOperate4Up",method=RequestMethod.POST)
		@ResponseBody
		public Object myCaseOperate4Up(String case_settle_way,String case_settle_date){
			Integer id = (Integer) Myoc.Ioc().get("id4");
			boolean boo = caseService.myCaseOperate4Up(id,case_settle_way,case_settle_date);
			return boo?"1":"";
		}
		
		/**
		 * *****************************************************************
		 * 	我的案件       	操作   end
		 */
		
		
		
		/**
		 * 	咨询与代书
		 * @return
		 */
		@RequiresPermissions(value= {"anjian:zxds","admin","test"},logical=Logical.OR)
		@RequestMapping("ConsultingGhostwriting")
		public String ConsultingGhostwriting() {
			return "anjian/ConsultingGhostwriting";
		}
		
		//显示
		@RequestMapping(value="ConsultingGhostwritingShow",method=RequestMethod.POST)
		@ResponseBody
		public Object ConsultingGhostwritingShow(String casePropernum,Map<String,Object> map,
										Integer offset,
										Integer limit,HttpServletRequest request
												){
			map.put("casePropernum", casePropernum);

			String userName = (String) request.getSession().getAttribute("userName");
			map.put("userName", userName);//---------------------------------->登陆人账号***
			System.out.println("---------------------------------->登陆人账号***" + userName);
			
			System.out.println(map);
			Page<Object> startPage = PageHelper.startPage(offset/limit+1, limit);
			
			List<Map<String,Object>> GGList = caseService.ConsultingGhostwritingShow(map);

			Map<String,Object> GGListMap = new HashMap<String,Object>();
			GGListMap.put("total", startPage.getTotal());
			GGListMap.put("rows", GGList);
			return GGListMap;
		}			
		
		//add添加頁面跳轉
		@RequestMapping(value="ConsultingGhostwritingAdd")
		public String ConsultingGhostwritingAdd(){
			return "anjian/ConsultingGhostwritingAdd";
		}
		//add添加  咨询与代书    服务表  与  案件表  自动生成案号
		@SuppressWarnings("deprecation")
		@RequestMapping(value="ConsultingGhostwritingFormAdd",method=RequestMethod.POST)
		@ResponseBody
		public String ConsultingGhostwritingFormAdd(CaseServiceLog cs,Law law,HttpServletRequest request){
			System.out.println("++++++++++++++++++++++++++++++++++=" + cs.toString());
			System.out.println("++++++++++++++++++++++++++++++++++=" + law.toString());
			
			//自动生成 案件号
			LocalDate sysDate = LocalDate.now();
			int count =  (int)(Math.random()*1000);
			//在前面补0
			 DecimalFormat df=new DecimalFormat("0000");
		     String str2=df.format(count);
			law.setCasePropernum(""+sysDate.getYear()+"（文）第"+ str2 +"号");
			//添加接案日期
			law.setCaseSubtime(sysDate+"");
			//添加对应的 empid
			String userName = (String) request.getSession().getAttribute("userName");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", userName);//---------------------------------->登陆人账号***
			Integer empId =  caseService.findEmpById(map);
			law.setSystemApprovalId(empId);
			//添加 案件表
			Integer addCaseLaw = caseService.addCaseLaw(law);
			System.out.println(law.getId()+"law主键");
			//在添加服务表添加插入案件信息的id
			cs.setCaselawid(law.getId());
			boolean caseServiceLogAdd = caseService.CaseServiceLogAdd(cs);
			return caseServiceLogAdd?"true":"false";
		}			
		
		
		
		
		
		
		
		
		
		
		
		
		
}
