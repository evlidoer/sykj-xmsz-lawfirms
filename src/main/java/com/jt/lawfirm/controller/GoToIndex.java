package com.jt.lawfirm.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GoToIndex {
	
	
		@RequestMapping("goto/loginto")
		public String loginto(){
			return "shouye/login";
		}
		
		//首页
		@RequestMapping("gotohomepage")
		public String gotohomepage(){
			return "shouye/homepage";
		}
		@RequestMapping("gotoindex")
		public String GoTo() {
			return "shouye/index";
		}
		
		@RequiresPermissions(value = {"shenpi:wdsq","admin","test"},logical = Logical.OR)
		@RequestMapping("gotomyapply")
		public String GO(){
			return "approval/myapply";
		}
		@RequestMapping("gotobuni")
		public String gotobubi(){
			return "approval/buni";
		}
		@RequestMapping("gotoseal")
		public String gotoseal(){
			return "approval/seal";
		}
		@RequiresPermissions(value = {"approval:approval","admin","test"},logical = Logical.OR)
		@RequestMapping("gotomyapplyok")
		public String gotomyapplyok(){
			return "approval/myapplyok";
		}
		@RequestMapping("gotobuniok")
		public String gotobuniok(){
			return "approval/buniok";
		}
		@RequestMapping("gotosealok")
		public String gotosealok(){
			return "approval/sealok";
		}
		@RequiresPermissions(value = {"client:myclient","admin","test"},logical = Logical.OR)
		@RequestMapping("gotomyclient")
		public String gotomyclient(){
			return "client/Myclient";
		}
		@RequiresPermissions(value = {"client:dfdsr","admin","test"},logical = Logical.OR)
		@RequestMapping("gotocounterparty")
		public String gotocounterparty(){
			return "client/counterparty";
		}
		@RequiresPermissions(value = {"client:allclient","admin","test"},logical = Logical.OR)
		@RequestMapping("gotoclient")
		public String gotoclient(){
			return "client/client";
		}
		//跳转添加客户页面
		
		@RequestMapping("gotoadd")
		public String gotoadd(){
			return "client/addclient";
		}
		
		
		//李阳
		//显示
		@RequestMapping(value="xiaotable")
		public String xiaotable() {
			return "anjian/xiaotable";
		}
		//显示小table
		@RequestMapping(value="detailsXXXX")
		public String detailsXXXX() {
			return "anjian/detailsXXXX";
		}
		
		//张鑫卓
		//查看案件详情
		@RequestMapping("gotolawdetailToUrl")
		public String gotolawdetailToUrl(){
			return "finance/lawdetailToUrl";
		}
}	

