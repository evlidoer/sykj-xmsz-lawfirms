package com.jt.lawfirm.controller.administration;


import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRequest {
	/**
	 * 2019年4月17日下午2:37:33
	 * @User 许威
	 * @Desc 公告通知表的数据加载,以及模糊查询,返回到 : /lawfirms/administration/Notice.html
	 * @return
	 */
	@RequestMapping("goto/administration/Notice")
	@RequiresPermissions(value = {"administrative:Notice","admin","test"},logical = Logical.OR)
	public String Notice() {
		return "/administration/Notice";
	}

	/**
	 * 	跳转至通讯录页面内
	 * 2019年4月17日下午6:33:35
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"administrative:Attorney","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/Attorney") 
	public String GotoAttorney(){ 
		return "/addressBook/Attorney"; 
	}
	/**
	 * 	跳转至外部联系人界面
	 * @return
	 */
	@RequiresPermissions(value = {"administrative:External","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/External") 
	public String GotoExternal(){ 
		return "/addressBook/External"; 
	}
	/**
	 * Attorney 查看详情 页面
	 * 2019年4月18日下午5:53:04
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@RequiresPermissions(value = {"administrative:Attorney","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/AttorneylInfo") 
	public String GotoSelAttorneyInfo(){ 
		return "addressBook/AttorneylInfo"; 
		
	}
	/**
	 * External 查看详情
	 * 2019年4月18日上午11:17:30
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	/*
	 * @RequestMapping("goto/addressBook/Externalnfo/{id}") public String
	 * GotoSelExternalInfo(@PathVariable("id") int id){ SaveIdUtil.saveID(id);
	 * return "addressBook/Externalnfo"; }
	 */
	@RequiresPermissions(value = {"administrative:External","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/Externalnfo") 
	public String GotoSelExternalInfo2(){
		return "addressBook/Externalnfo"; 
	}
	
	/*
	 *  	转修改页面
	 */
	@RequiresPermissions(value = {"administrative:External","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/updExternal")
	public String updExternal() {
		return "addressBook/updExternal";
	}
	
	@RequiresPermissions(value = {"administrative:External","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/addExternal")
	public String addExternal() {
		return "addressBook/addExternal";
	}
	
	
	/**
	 * 高级管理下所有请求
	 */
	@RequiresPermissions(value = {"administrative:ManagerNotice","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/ManagerNotice")
	public String goto_Advanced_Function_ManagerNotice() {
		return "administration/ManagerNotice";
	}
	
	/**
	 * 查看 
	 */
	@RequiresPermissions(value = {"administrative:ManagerNotice","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/SelNoticeInfo")
	public String goto_Advanced_Function_ManagerNotice222() {
		return "administration/SelNoticeInfo";
	}
	
	/**
	 * 修改  公告
	 */
	@RequiresPermissions(value = {"administrative:ManagerNotice","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/UpdNoticeInfo")
	public String UpdNoticeInfo() {
		return "administration/updNotice";
	}
	/**
	 * 	去添加页面
	 * 2019年4月20日下午4:12:20
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@RequiresPermissions(value = {"administrative:ManagerNotice","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/AddNoticeInfo")
	public String goto_administration_AddNoticeInfo() {
		return "administration/addNotice";
	}
	
	
	/**
	 *  go  签到 管理页面  
	 *  	许威 
	 */
	@RequiresPermissions(value = {"administrative:SigninrecorGL","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/SigninrecorGL")
	public String goto_administration_SigninrecorGL() {
		return "administration/SigninrecorGL";
	}
	
	/**
	 *  go  签到  统计    页面  
	 *  	许威 
	 */
	@RequiresPermissions(value = {"administrative:SigninrecorTJ","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/SigninrecorTJ")
	public String goto_administration_SigninrecorTJ() {
		return "administration/SigninrecorTJ";
	}
	
	/**
	 *  go  Complain.html 去噶管理投诉页面
	 */
	@RequiresPermissions(value = {"administrative:Complain","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/Complain")
	public String goto_administration_Complain() {
		return "administration/Complain";
	}
	
	
	

	/**
	 * index 点击跳转至快递等级默认页面
	 */
	@RequiresPermissions(value = {"administrative:Expressage","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/Expressage")
	public String goto_administration_Expressage() {
		return "administration/Expressage";
	}
	
	/**
	 * 跳转至发件
	 */
	@RequiresPermissions(value = {"administrative:FJExpressage","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/administration/FJExpressage")
	public String goto_administration_FJExpressage() {
		return "administration/FJExpressage";
	}
	/**
	 * 添加 Expressage
	 * 2019年4月23日下午11:33:36
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequiresPermissions(value = {"administrative:Expressage","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/sel_ExpressageByID_id")
	public String goto_administration_ExpressageByID_id() {
		return "administration/SelExpressage";
	}
	/**
	 * 	 修改该请求
	 */
	@RequiresPermissions(value = {"administrative:Expressage","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/addressBook/upd_ExpressageByID_id")
	public String goto_addressBook_upd_ExpressageByID_id() {
		return "administration/UpdExpressage";
	}
	/**
	 * 	添加内部的选择user页面跳转
	 * 2019年4月24日上午10:01:16
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping("goto/addressBook/upd_ExpressageByID_id/selUer")
	public String goto_addressBook_upd_ExpressageByID_id_goto_selUer() {
		return "administration/AddExpressage_SelUser";
	}
	@RequestMapping("goto/addressBook/upd_ExpressageByID_id/selUer_2")
	public String goto_addressBook_upd_ExpressageByID_id_goto_selUer2() {
		return "administration/AddExpressage_SelUser2";
	}
	
	/**
	 * 	快件公司查询 
	 * 2019年4月24日下午7:49:49
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping("goto/addressBook/upd_ExpressageByID_id/Kuaisel")
	public String goto_addressBook_upd_ExpressageByID_id_goto_Kuaisel() {
		return "administration/AddExpressage_KuaidiSel";
	}
	/**
	 *  	快件类型查询
	 */
	@RequestMapping("goto/addressBook/upd_ExpressageByID_id/typeSel")
	public String goto_addressBook_upd_ExpressageByID_id_goto_typeSel() {
		return "administration/AddExpressage_TypeSel";
	}
	/**
	 * 	案件查询 goto/addressBook/upd_ExpressageByID_id/lawSel
	 */
	@RequestMapping(" goto/addressBook/upd_ExpressageByID_id/lawSel")
	public String goto_addressBook_upd_ExpressageByID_id_goto_lawSel() {
		return "administration/AddExpressage_lawEmp";
	}
	
	
	
	
	
	
	
	
	
	/**'
	 * 	添加请求
	 * 2019年4月24日上午9:06:13
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping("goto/addressBook/add_ExpressageByID_id")
	public String goto_addressBook_add_ExpressageByID_id() {
		return "administration/AddExpressage";
	}
	/**
	 * 	跳转至修修改或者添加快递类型表中
	 */
	@RequestMapping("goto/administration/updOrAddKD")
	public String goto_administration_updOrAddKD() {
		return "administration/Kuaidigongsi";
	}
	@RequestMapping("goto/administration/updOrAddKDTYpe")
	public String goto_administration_updOrAddKDTYpe() {
		return "administration/Kuaidigongsi_type";
	}
	
	
	/**
	 *  	发件
	 */
	
	@RequestMapping("goto/addressBook/add_ExpressageByID_id_FJ")
	public String goto_administration_add_ExpressageByID_id_FJ() {
		return "administration/F_AddExpressage2";
	}
	
	/**
	 * 	查看页面
	 * 2019年4月28日上午12:09:36
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping("goto/addressBook/sel_ExpressageByID_id_FJ")
	public String goto_administration_sel_ExpressageByID_id_FJ() {
		return "administration/SelExpressageF";
	}
	
	@RequestMapping("goto/addressBook/F_ExpressageByID_upd")
	public String goto_administration_F_ExpressageByID_upd() {
		return "administration/UpdF_AddExpressage2";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------电子归档
	/**
	 * 电子归档
	 */
	
	@RequestMapping("goto/record/ElectronicFiling")
	public String goto_administration_ElectronicFiling() {
		return "record/ElectronicFiling";
	}
	
	
	/**
	 * 	我的电子归档
	 */
	@RequiresPermissions(value = {"administrative:MyDocument","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/record/MyDocument")
	public String goto_administration_MyDocument() {
		return "record/MYDocument";
	}
	/**
	 * 	查看我的电子文档
	 */
	@RequiresPermissions(value = {"record:MyDocument","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/record/MyDocumentinfo")
	public String goto_administration_MyDocumentinfo() {
		return "record/MYDocumentinfo";
	}
	/**
	 * 全所电子档案
	 */
	@RequiresPermissions(value = {"record:ElectronicRecordsAll","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/record/ElectronicRecordsAll")
	public String goto_administration_ElectronicRecordsAll() {
		return "record/ElectronicRecordsAll";
	}
	/**
	 * 档案借阅
	 */
	@RequiresPermissions(value = {"record:ArchivesLibrary","admin","test"},logical = Logical.OR)
	@RequestMapping("goto/record/ArchivesLibrary")
	public String goto_administration_ArchivesLibrary() {
		return "record/ArchivesLibrary";
	}
	/**
	 * 	添加归档
	 */
	@RequestMapping("goto/record/addGuidang")
	public String goto_administration_addGuidang() {
		return "record/AddGuiDang";
	}
	
}
