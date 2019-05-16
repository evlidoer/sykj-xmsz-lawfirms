package com.jt.lawfirm.controller.approval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.approval.IBuniApprovalService;

@Controller
public class ControllerBuniApproval {
	
	@Autowired
	private IBuniApprovalService buniApprovalService;
	
	@RequestMapping("relief")
	@ResponseBody
	public PageBean relief(Map<String,Object> smap, Integer offset,Integer limit,HttpServletRequest request){
		PageBean pb = new PageBean();
		String parameter = request.getParameter("casePropernum");
		String caseApproveStatus = request.getParameter("caseApproveStatus");
		String StartcaseSubtime = request.getParameter("StartcaseSubtime");
		String EndcaseSubtime = request.getParameter("EndcaseSubtime");
		Map<String,Object> map = new HashMap<String, Object>();
		
		
		if(parameter!=null&&parameter!=""){
			int casePropernum = Integer.parseInt(parameter);
			map.put("casePropernum", "%"+casePropernum+"%");
		}
		if(caseApproveStatus!=null&&caseApproveStatus!=""){
			map.put("caseApproveStatus",caseApproveStatus);
		}
		if(StartcaseSubtime!=null&&StartcaseSubtime!=""){
			map.put("StartcaseSubtime",StartcaseSubtime);
		}
		if(EndcaseSubtime!=null&&EndcaseSubtime!=""){
			map.put("EndcaseSubtime",EndcaseSubtime);
		}
		
		
		
		if(offset!=null&&offset!=0){
			map.put("offset",offset);
		}
		if(limit!=null&&limit!=0){
			map.put("limit",limit);
		}
		
		map.put("pb",pb);
		List<Map<String, Object>> selectBuni = buniApprovalService.SelectBuni(map);
		return pb;
	}
	@RequestMapping("settle")
	@ResponseBody
	public PageBean settle(Map<String,Object> smap, Integer offset,Integer limit,HttpServletRequest request){
		PageBean pb = new PageBean();
		String parameter = request.getParameter("casePropernum");
		String caseApproveStatus = request.getParameter("caseApproveStatus");
		String StartcaseSubtime = request.getParameter("StartcaseSubtime");
		String EndcaseSubtime = request.getParameter("EndcaseSubtime");
		Map<String,Object> map = new HashMap<String, Object>();
		if(parameter!=null&&parameter!=""){
			int casePropernum = Integer.parseInt(parameter);
			map.put("casePropernum", "%"+casePropernum+"%");
		}
		if(caseApproveStatus!=null&&caseApproveStatus!=""){
			map.put("caseApproveStatus",caseApproveStatus);
		}
		if(StartcaseSubtime!=null&&StartcaseSubtime!=""){
			map.put("StartcaseSubtime",StartcaseSubtime);
		}
		if(EndcaseSubtime!=null&&EndcaseSubtime!=""){
			map.put("EndcaseSubtime",EndcaseSubtime);
		}
		
		
		
		if(offset!=null&&offset!=0){
			map.put("offset",offset);
		}
		if(limit!=null&&limit!=0){
			map.put("limit",limit);
		}
		
		map.put("pb",pb);
		List<Map<String, Object>> selectBuni = buniApprovalService.SelectSettle(map);
		return pb;
	}
	@RequestMapping("refund")
	@ResponseBody
	public PageBean refund(Map<String,Object> smap, Integer offset,Integer limit,HttpServletRequest request){
		PageBean pb = new PageBean();
		String parameter = request.getParameter("casePropernum");
		String caseApproveStatus = request.getParameter("caseApproveStatus");
		String StartcaseSubtime = request.getParameter("StartcaseSubtime");
		String EndcaseSubtime = request.getParameter("EndcaseSubtime");
		Map<String,Object> map = new HashMap<String, Object>();
		if(parameter!=null&&parameter!=""){
			int casePropernum = Integer.parseInt(parameter);
			map.put("casePropernum", "%"+casePropernum+"%");
		}
		if(caseApproveStatus!=null&&caseApproveStatus!=""){
			map.put("caseApproveStatus",caseApproveStatus);
		}
		if(StartcaseSubtime!=null&&StartcaseSubtime!=""){
			map.put("StartcaseSubtime",StartcaseSubtime);
		}
		if(EndcaseSubtime!=null&&EndcaseSubtime!=""){
			map.put("EndcaseSubtime",EndcaseSubtime);
		}
		
		
		
		if(offset!=null&&offset!=0){
			map.put("offset",offset);
		}
		if(limit!=null&&limit!=0){
			map.put("limit",limit);
		}
		
		map.put("pb",pb);
		List<Map<String, Object>> selectBuni = buniApprovalService.SelectRefund(map);
		return pb;
	}
	
	@RequestMapping("gotoreliefSel")
	public String gotoreliefSel(){
		return "approval/relief";
	}
	//费用减免申请
	@ResponseBody
	@RequestMapping("reliefSel/{id}")
	public List<Map<String,Object>> reliefSel(@PathVariable("id") Integer id){
		System.err.println(id);
		List<Map<String,Object>> listmap =	buniApprovalService.reliefSelById(id);
		return listmap;
	}
	@RequestMapping("gotoSettleSel")
	public String gotoSettleSel(){
		return "approval/settle";
	}
	
	@ResponseBody
	@RequestMapping("SettleSel/{id}")
	public List<Map<String,Object>> SettleSel(@PathVariable("id") Integer id){
		List<Map<String,Object>> listmap =	buniApprovalService.SettleSelById(id);
		return listmap;
	}
	@RequestMapping("gotoRefundSel")
	public String gotoRefundSel(){
		return "approval/refund";
	}
	
	@ResponseBody
	@RequestMapping("RefundSel/{id}")
	public List<Map<String,Object>> RefundSel(@PathVariable("id") Integer id){
		List<Map<String,Object>> listmap =	buniApprovalService.RefundSelById(id);
		return listmap;
	}
	@ResponseBody
	@RequestMapping("recordLawById/{id}")
	public int recordLawById(@PathVariable("id") Integer id){
		int count = 0;
		String str =  buniApprovalService.record(id);
		if(str!=null&&str!=""){
			count  = Integer.parseInt(str);
		}
		return count;
	}
	
	@RequestMapping("gotoreliefapprove")
	public String gotoreliefapprove(){
		return "approval/reliefapprove";
	}
	
	@RequestMapping("gotoSettleapprove")
	public String gotoSettleapprove(){
		return "approval/settleapprove";
	}
	
	@RequestMapping("gotoRefundSelapprove")
	public String gotoRefundSelapprove(){
		return "approval/refundapprove";
	}
	
	//结案审批
		@ResponseBody
		@RequestMapping("settleApproval")
		public int SealApprovalById(HttpServletRequest request){
			int num =0;
			String settleId = request.getParameter("settle_id");
			String applyfor_approval_status = request.getParameter("approvalStaus");
			Integer settle_id = Integer.parseInt(settleId);
			String username = request.getSession(false).getAttribute("userName").toString();
			//进行审批查看 若行政审批状态为N，执行审批流程1 若为Y，执行审批流程2
			String Status = buniApprovalService.StatusSelsettle(1,settle_id);
			System.err.println(Status);
			if(Status.equals("N")){
				System.out.println("一级审批进入");
				//查看审批人是否可以审批 返回审批人ID
				int id = buniApprovalService.userSelsettle(username,settle_id);
				System.out.println(username);
				System.err.println("审批人为==="+id);
				if(id==1){
					//可以审批，进行审批流程1，进行行政审批	
					if(applyfor_approval_status.equals("O")){
						int updatelaw = buniApprovalService.approvalsettle(applyfor_approval_status,settle_id);
						num = updatelaw;
					}else if(applyfor_approval_status.equals("Y")){
						num = buniApprovalService.Approvalsettleone(applyfor_approval_status,id,settle_id);

					}	
				}else{
					num = 0;
				}
			}else if(Status.equals("Y")){
				System.out.println("二级审批进入");
				//执行审批流程2 查看现登录账号的id 查看是否为管理员
				int id = buniApprovalService.userSelsettle(username,settle_id);

				if(id==2){
					//id为2 可以进行流程2管理员审批
					if(applyfor_approval_status.equals("O")){
						int updatelaw = buniApprovalService.approvalsettle(applyfor_approval_status,settle_id);
						num = updatelaw;
					}else if(applyfor_approval_status.equals("Y")){
						num = buniApprovalService.Approvalsettletwo(applyfor_approval_status,id,settle_id);
						num = buniApprovalService.approvalsettle(applyfor_approval_status, settle_id);
					}
				}else{
					num = 0;
				}
			}else{
				num = 0;
			}
			return num;
		}
	//费用减免审批
	@ResponseBody
	@RequestMapping("reliefApproval")
	public int reliefApproval(HttpServletRequest request){
		int num =0;
		String reliefId = request.getParameter("relief_id");
		String applyfor_approval_status = request.getParameter("approvalStaus");
		Integer relief_id = Integer.parseInt(reliefId);
		String username = request.getSession(false).getAttribute("userName").toString();
		//进行审批查看 若财政审批状态为N，执行审批流程1 若为Y，执行审批流程2
		String Status = buniApprovalService.StatusSelrelief(3,relief_id);
		System.err.println(Status);
		if(Status.equals("N")){
			System.out.println("一级审批进入");
			//查看审批人是否可以审批 返回审批人ID
			int id = buniApprovalService.userSelrelief(username,relief_id);
			System.out.println(username);
			System.err.println("审批人为==="+id);
			if(id==3){
				//可以审批，进行审批流程1，进行财务审批	
				if(applyfor_approval_status.equals("O")){
					int updatelaw = buniApprovalService.approvalrelief(applyfor_approval_status,relief_id);
					num = updatelaw;
				}else if(applyfor_approval_status.equals("Y")){
					num = buniApprovalService.Approvalreliefone(applyfor_approval_status,id,relief_id);

				}	
			}else{
				num = 0;
			}
		}else if(Status.equals("Y")){
			System.out.println("二级审批进入");
			//执行审批流程2 查看现登录账号的id 查看是否为管理员
			int id = buniApprovalService.userSelrelief(username,relief_id);

			if(id==2){
				//id为2 可以进行流程2管理员审批
				if(applyfor_approval_status.equals("O")){
					int updatelaw = buniApprovalService.approvalrelief(applyfor_approval_status,relief_id);
					num = updatelaw;
				}else if(applyfor_approval_status.equals("Y")){
					num = buniApprovalService.Approvalrelieftwo(applyfor_approval_status,id,relief_id);
					num = buniApprovalService.approvalrelief(applyfor_approval_status, relief_id);
				}
			}else{
				num = 0;
			}
		}else{
			num = 0;
		}
		return num;
	}
	
	//退费审批
		@ResponseBody
		@RequestMapping("refundApproval")
		public int refundApproval(HttpServletRequest request){
			int num =0;
			String refundId = request.getParameter("refund_id");
			String applyfor_approval_status = request.getParameter("approvalStaus");
			Integer refund_id = Integer.parseInt(refundId);
			String username = request.getSession(false).getAttribute("userName").toString();
			//进行审批查看 若财政审批状态为N，执行审批流程1 若为Y，执行审批流程2
			String Status = buniApprovalService.StatusSelrefund(3,refund_id);
			System.err.println(Status);
			if(Status.equals("N")){
				System.out.println("一级审批进入");
				//查看审批人是否可以审批 返回审批人ID
				int id = buniApprovalService.userSelrefund(username,refund_id);
				System.out.println(username);
				System.err.println("审批人为==="+id);
				if(id==3){
					//可以审批，进行审批流程1，进行财务审批	
					if(applyfor_approval_status.equals("O")){
						int updatelaw = buniApprovalService.approvalrefund(applyfor_approval_status,refund_id);
						num = updatelaw;
					}else if(applyfor_approval_status.equals("Y")){
						num = buniApprovalService.Approvalrefundone(applyfor_approval_status,id,refund_id);

					}	
				}else{
					num = 0;
				}
			}else if(Status.equals("Y")){
				System.out.println("二级审批进入");
				//执行审批流程2 查看现登录账号的id 查看是否为管理员
				int id = buniApprovalService.userSelrefund(username,refund_id);

				if(id==2){
					//id为2 可以进行流程2管理员审批
					if(applyfor_approval_status.equals("O")){
						int updatelaw = buniApprovalService.approvalrefund(applyfor_approval_status,refund_id);
						num = updatelaw;
					}else if(applyfor_approval_status.equals("Y")){
						num = buniApprovalService.Approvalrefundtwo(applyfor_approval_status,id,refund_id);
						num = buniApprovalService.approvalrefund(applyfor_approval_status, refund_id);
					}
				}else{
					num = 0;
				}
			}else{
				num = 0;
			}
			return num;
		}
}
