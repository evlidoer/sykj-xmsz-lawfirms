package com.jt.lawfirm.controller.approval;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.casea.CaseApproval;
import com.jt.lawfirm.service.approval.IApprovalService;
import com.jt.lawfirm.service.approval.ISealApprovalService;

@Controller
public class ControllerSealApproval {
	@Autowired
	private ISealApprovalService sealApproval;
	
	@Autowired
	private IApprovalService ApprovalService ;
	
	@RequestMapping("applyforSel")
	@ResponseBody
	public PageBean sealapproval(Map<String,Object> map,Integer offset,Integer limit,HttpServletRequest request){
		Map<String,Object> SMap  = new HashMap<String, Object>();
		PageBean pb  = new PageBean();
		String parameter = request.getParameter("casePropernum");
		String caseApproveStatus = request.getParameter("caseApproveStatus");
		String StartcaseSubtime = request.getParameter("StartcaseSubtime");
		String caseSubmitter = request.getParameter("caseSubmitter");
		String scaseTypeId = request.getParameter("caseTypeId");
		if(caseSubmitter!=null&&caseSubmitter!=""){
			SMap.put("caseSubmitter","%"+caseSubmitter+"%");
		}
		if(scaseTypeId!=null&&scaseTypeId!=""){
			SMap.put("caseTypeId",scaseTypeId);
		}
		String EndcaseSubtime = request.getParameter("EndcaseSubtime");
		if(parameter!=null&&parameter!=""){
			int casePropernum = Integer.parseInt(parameter);	
			SMap.put("casePropernum", "%"+casePropernum+"%");
		}
		if(caseApproveStatus!=null&&caseApproveStatus!=""){
			SMap.put("caseApproveStatus",caseApproveStatus);
		}
		if(StartcaseSubtime!=null&&StartcaseSubtime!=""){
			SMap.put("StartcaseSubtime",StartcaseSubtime);
		}
		if(EndcaseSubtime!=null&&EndcaseSubtime!=""){
			SMap.put("EndcaseSubtime",EndcaseSubtime);
		}
		if(limit!=null&&limit!=0){
			pb.setLimit(limit);
		}
		if(offset!=null&&offset!=0){
			pb.setOffset(offset);
		}
		SMap.put("pb",pb);
		List<Map<String, Object>> selectAll = sealApproval.SelectAll(SMap);
		System.err.println(selectAll);
		return pb;
	}
	//跳入我的申请流程查看
	@RequestMapping("gotolawdetail")
	public String gotolawdetail(){
		return "approval/lawdetail";
	}
	@ResponseBody
	@RequestMapping("sealSelect/{id}")
	public List<Map<String,Object>> sealSel(@PathVariable("id") Integer id){
		List<Map<String,Object>> seal =  sealApproval.SelectSeal(id);
		return seal;
	}
	@RequestMapping("gotoviewdetailed")
	public String gotoviewdetail(){
		return "approval/viewdetailed";
	}
	
	@ResponseBody
	@RequestMapping("viewdetailed/{id}")
	public List<Map<String,Object>> viewdetailed(@PathVariable("id") Integer id){
		System.err.println(id);
		List<Map<String,Object>> view = sealApproval.SelectLawById(id);
		
		System.err.println("view==="+view);
		return view;
	}
	
	@ResponseBody
	@RequestMapping("sealLawById/{id}")
	public List<Map<String,Object>> SealLaw(@PathVariable("id") Integer id){
		System.err.println(id);
		List<Map<String,Object>> Seal =  sealApproval.selectSealLawById(id);
		
		System.err.println("Seal==="+Seal);
		return Seal;
	}
	@ResponseBody
	@RequestMapping("LawEmpById/{id}")
	public List<Map<String,Object>> EmpById(@PathVariable("id")Integer id){
		List<Map<String,Object>> SelectEmp =  sealApproval.SelectEmp(id);
		return SelectEmp;
	}
	//跳转入收案审批 approveLaw
	@RequestMapping("gotoapproveLaw")
	public String gotoapprove(){
		return "approval/approveLaw";
	}
	//案件审批提交流程
	@ResponseBody
	@RequestMapping("approveLaw")
	public int apprpveLaw(CaseApproval lawApproval,HttpServletRequest request){
		int num = 0;
		String approvalStaus = request.getParameter("approvalStaus");
		String lawId =	request.getParameter("lawId");
		Integer law_id = Integer.parseInt(lawId);
		String username = request.getSession(false).getAttribute("userName").toString();
		//进行审批查看 若行政审批状态为N，执行审批流程1 若为Y，执行审批流程2
		String Status = ApprovalService.StatusSel(1,law_id);
		System.err.println(Status);
		if(Status.equals("N")){
			System.out.println("一级审批进入");
			//查看审批人是否可以审批 返回审批人ID
			int id = ApprovalService.userSel(username,law_id);
			System.out.println(username);
			System.err.println("审批人为==="+id);
			if(id==1){
				//可以审批，进行审批流程1，进行行政审批	
				if(approvalStaus.equals("O")){
					int updatelaw = ApprovalService.approvallaw(approvalStaus,law_id);
					num = updatelaw;
				}else if(approvalStaus.equals("Y")){
					num = ApprovalService.ApprovalLawone(approvalStaus,id,law_id);

				}	
			}else{
				num = 0;
			}
		}else if(Status.equals("Y")){
			System.out.println("二级审批进入");
			//执行审批流程2 查看现登录账号的id 查看是否为管理员
			int id = ApprovalService.userSel(username,law_id);

			if(id==2){
				//id为2 可以进行流程2管理员审批
				if(approvalStaus.equals("O")){
					int updatelaw = ApprovalService.approvallaw(approvalStaus,law_id);
					num = updatelaw;
				}else if(approvalStaus.equals("Y")){
					num = ApprovalService.ApprovalLawtwo(approvalStaus,id,law_id);
					num = ApprovalService.approvallaw(approvalStaus, law_id);
				}
			}else{
				num = 0;
			}
		}else{
			num = 0;
		}

		Date time = new Date();
		lawApproval.setApprovalDate(time);
		return num;

}
	//是否归档
	@ResponseBody
	@RequestMapping("record/{id}")
	public int record(@PathVariable("id")Integer id){
		System.err.println(id);
		int count = sealApproval.recordnum(id);
		return count;
	}
	//用印审批页面跳转
	@RequestMapping("gotoapproveseal")
	public String gotoapproveseal(){
		return "approval/approveseal";
	}
	
	//用印审批页面数据
	@ResponseBody
	@RequestMapping("sealSel/{id}")
	public List<Map<String,Object>> sealLaw(@PathVariable("id") Integer id){
		List<Map<String,Object>>  listmap=	sealApproval.SelectLawById(id);
		return listmap;
	}

	//用印审批
	@ResponseBody
	@RequestMapping("SealApprovalById")
	public int SealApprovalById(HttpServletRequest request){
		int num =0;
		String sealId = request.getParameter("id");
		String applyfor_approval_status = request.getParameter("applyfor_approval_status");
		Integer seal_id = Integer.parseInt(sealId);
		String username = request.getSession(false).getAttribute("userName").toString();
		//进行审批查看 若行政审批状态为N，执行审批流程1 若为Y，执行审批流程2
		String Status = ApprovalService.StatusSelSeal(1,seal_id);
		System.err.println(Status);
		if(Status.equals("N")){
			System.out.println("一级审批进入");
			//查看审批人是否可以审批 返回审批人ID
			int id = ApprovalService.userSelSeal(username,seal_id);
			System.out.println(username);
			System.err.println("审批人为==="+id);
			if(id==1){
				//可以审批，进行审批流程1，进行行政审批	
				if(applyfor_approval_status.equals("O")){
					int updatelaw = ApprovalService.approvalSeal(applyfor_approval_status,seal_id);
					num = updatelaw;
				}else if(applyfor_approval_status.equals("Y")){
					num = ApprovalService.ApprovalSealone(applyfor_approval_status,id,seal_id);

				}	
			}else{
				num = 0;
			}
		}else if(Status.equals("Y")){
			System.out.println("二级审批进入");
			//执行审批流程2 查看现登录账号的id 查看是否为管理员
			int id = ApprovalService.userSelSeal(username,seal_id);

			if(id==2){
				//id为2 可以进行流程2管理员审批
				if(applyfor_approval_status.equals("O")){
					int updatelaw = ApprovalService.approvalSeal(applyfor_approval_status,seal_id);
					num = updatelaw;
				}else if(applyfor_approval_status.equals("Y")){
					num = ApprovalService.ApprovalSealtwo(applyfor_approval_status,id,seal_id);
					num = ApprovalService.approvalSeal(applyfor_approval_status, seal_id);
					num = ApprovalService.updateSealStatus("管理员",seal_id);
				}
			}else{
				num = 0;
			}
		}else{
			num = 0;
		}
		return num;
	}
	//用印审批文件查询
	@ResponseBody
	@RequestMapping("SealFile/{id}")
	public List<Map<String,Object>> File(@PathVariable("id")Integer id){
		List<Map<String,Object>> listmap =	sealApproval.SelectSealFileById(id);
		System.out.println(listmap);
		return listmap;
	}
	
}
