	/**
	 * 首页菜单显示关闭
	 */
	function fn(e){
				var a = $("#LAY_app").attr("class");
				if(a == "layadmin-side-shrink"){
					$("#LAY_app").removeClass("layadmin-side-shrink");
				}else{
					$("#LAY_app").addClass("layadmin-side-shrink")
				}
		}

	
	/**
	 * 利益冲突审查
	 */
    $(function () {
    	$("#onetable").bootstrapTable({
			method:'post',
			dataType:'json',
			contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			url:'ConflictOfInterestReview',
			pagination:true,//显示分页
			pageSize:4,//每页数据数
			pageList:[3,4,5],//设置页面可显示的数据条数
			pageNumber:1,//首页页码
			sidePagination:'server',//设置为服务器端分页
			//sidePagination: 'client', 
			 queryParams:function(params){//向后台传值
				return{
					limit: params.limit, // 每页要显示的数据条数
		            offset: params.offset, // 每页显示数据的开始行号
					Wtr:$("#Wtr").val(),
					DWtr:$("#DWtr").val()
				 }
			}, 
			columns:[{
				title:'序号',
				formatter:function(value,row,index){
					return index+1
				}
			},{
				align: 'center', // 左右居中
				title:'案号',
				field:'case_propernum'
			},{
				align: 'center', // 左右居中
				title:'当事人/委托人',
				field: 'case_parties'
			},{
				align: 'center', // 左右居中
				title:'收案日期',
				formatter:function(value,row,index){
					return new Date(row.case_subtime).format("yyyy-MM-dd")
				}
			},{
				align: 'center', // 左右居中
				title:'对方当事人',
				field: 'case_opposite_parties'
			},{
				align: 'center', // 左右居中
				title:'结案',
				width:'60px',
				formatter:function(value,row,index){
						if(row.case_settle_status == 'Y') return '已结案';
						if(row.case_settle_status == 'N') return '未结案';
				}
			},{
				align: 'center', // 左右居中
				title:'代理费',
					field: 'case_agencyfee'
			},{
				align: 'center', // 左右居中
				title:'已付款(元)',
				field: 'case_paidsal'
			},{
				align: 'center', // 左右居中
				title:'诉讼标的',
				field: 'case_lawsuitobj'
			},{
				align: 'center', // 左右居中
				title:'收案审批人',
				field: 'emp_name'
			}]
		})
    		
		//查询(刷新表格)
		$("#btn").on("click",function(e){
			var Wtr = $("#Wtr").val();
			var DWtr = $("#DWtr").val();
			if(Wtr.trim() == ''  || DWtr.trim() == ''){
				alert("当事人/对方当事人不能为空")
				return;
			}
			$("#onetable").bootstrapTable('refresh');//刷新
			
		});
	    
    });
    	
  
/*
 * *******************************************************************
 		 我的案件
 * *****************************************************************
 * */

$(function () {
    	$("#twotable").bootstrapTable({
			method:'post',
			dataType:'json',
			contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			url:'ajaxlaw',
			pagination:true,//显示分页
			pageSize:8,//每页数据数
			pageList:[3,5,8],//设置页面可显示的数据条数
			pageNumber:1,//首页页码
			sidePagination:'server',//设置为服务器端分页
			//sidePagination: 'client',
			 queryParams:function(params){//向后台传值
				return{
					offset:params.offset,
					limit:params.limit,
					"casePropernum":$("#casePropernum").val(),
					"caseApproveStatus":$("#caseApproveStatus").val(),
					"caseSettleStatus":$("#caseSettleStatus").val(),
					"caseCaseTypeId":$("#caseCaseTypeId").val(),
					"caseAssign":$("#caseAssign").val(),
					
					"btn1":$("#btn01").val(),
					"btn2":$("#btn02").val(),
					"btn3":$("#btn03").val(),
					"btn4":$("#btn04").val(),
					"btn5":$("#btn05").val(),
					"btn6":$("#btn06").val(),
					"btn7":$("#btn07").val(),
				 }
			}, 
			columns:[{
				title:'序号',
				width:'20px',
				formatter:function(value,row,index){
					return index+1
				}
			},{
				align: 'center', // 左右居中
				title:'案号',
				width:'200px',
				field:'case_propernum'
			},{
				align: 'center', // 左右居中
				title:'接案日期',
				width:'95px',
				formatter:function(value,row,index){
					if(row.case_subtime!=null)return new Date(row.case_subtime).format("yyyy-MM-dd")
					else return null
				}
				
			}/*,{
				align: 'center', // 左右居中
				title:'委托人',
				width:'60px',
				field: 'case_third_party'
			}*/,{
				align: 'center', // 左右居中
				title:'对方当事人',
				field: 'case_opposite_parties'
			},{
				align: 'center', // 左右居中
				title:'承办律师',
				field: 'emp_name'
			},{
				align: 'center', // 左右居中
				title:'结案',
				width:'60px',
				formatter:function(value,row,index){
						if(row.case_settle_status == 'Y') return '已结案';
						if(row.case_settle_status == 'N') return '未结案';
				}
			},{
				align: 'center', // 左右居中
				title:'代理费',
				width:'60px',
				field: 'case_agencyfee'
			},{
				align: 'center', // 左右居中
				title:'已付款(元)',
				width:'60px',
				field: 'case_paidsal'
			},{
				align: 'center', // 左右居中
				title:'当事人',
				width:'60px',
				field: 'case_parties'
			},{
				align: 'center', // 左右居中
				title:'收案审批',
				width:'80px',
				formatter:function(value,row,index){
						if(row.case_approve_status == 'Y') return '已审批';
						if(row.case_approve_status == 'N') return '未审批';
				}
			},{
				align: 'center', // 左右居中
				title:'收案审批人',
				width:'77px',
				field: 'emp_name'
			},{
				align: 'center', // 左右居中
				title:'档案',
				width:'60px',
				formatter:function(value,row,index){
					if(row.case_clash == 'Y') return '已归档';
					if(row.case_clash == 'N') return '未归档';
				}
			},{
				align:"center",
				title:"操作",
				formatter:function(value,row,index){
					var div = "<div class=\"btn_hollow case_set\">操作</div>";
						div+="<ul class=\"small_menu\" id=\"set_20190100161\" >";
						div+="<li><a href=\"myCaseSkip/"+row.id+"/"+new Date().getTime()+"\">修改</a></li>";
						div+="<li><a href=\"myCaseSkip2/"+row.id+"/"+new Date().getTime()+"\" draggable=\"false\">费用减免申请</a></li>";
						div+="<li><a href=\"myCaseSkip3/"+row.id+"/"+new Date().getTime()+"\">付款方式</a></li>";
						if(row.case_settle_status=='Y'){
							div+="<li>已结案</li>";
						}else{
							div+="<li><a href=\"myCaseSkip4/"+row.id+"/"+new Date().getTime()+"\">结案</a></li>";
						}
						div+="<li><a href='javascript:addCase5_1("+JSON.stringify(row)+")'>批量生成文书</a></li>";
						div+="<li><a href='javascript:WholeCaseCZ2("+JSON.stringify(row)+")'>申请发票</a></li>";
						if(row.case_clash == 'Y'){
							div+=    "<li><a href='javascript:WholeCaseCZ4("+JSON.stringify(row)+")' draggable='false' id='DAGD'>取消档案归档</a></li>";
					     }else if(row.case_clash == 'N'){
					    	 div+=    "<li><a href='javascript:WholeCaseCZ4("+JSON.stringify(row)+")' draggable='false' id='DAGD'>档案归档</a></li>";
					     }
						div+="<li><a href=\"javascript:DrawBack('20190100161')\" draggable=\"false\">申请退费</a></li>";
						div+="<li><a href='javascript:CaseShare(this)'>共享案件</a></li>"; 
						div+="<li><a href=\"javascript:JobLog('20190100161')\" draggable=\"false\">工作日志</a></li>"; 
						div+="<li><a href='javascript:kaitingMsgAdd("+JSON.stringify(row)+")' >法院提醒</a></li>"; 
						div+="<li><a href='javascript:ZhenCha("+JSON.stringify(row)+")' >侦查机关</a></li>"; 
						div+="<li><a href='javascript:JianCha("+JSON.stringify(row)+")' >检察机关</a></li>";
						div+="<li><a href=\"javascript:CaseJobLog('20190100161')\" draggable=\"false\">案件进度表</a></li>";
						div+="<li><a href=\"javascript:ClickBaoHan('20190100161')\" draggable=\"false\">在线申请保函</a></li>";
						div+="</ul>";
					return div;
				}
				
			}]
		})

    		//查询(刷新表格)
			$("form").on("click","#myCasebtn,#btn1,#btn2,#btn3,#btn4,#btn5,#btn6,#btn7",function(e){
				if(this=="javascript:void(1);"){
					$("#btn01").val("")
				}else if(this=="javascript:void(2);"){
					$("#btn02").val("N") //在办案件//未结案
				}else if(this=="javascript:void(3);"){
					$("#btn03").val("Y") //已结案件
				}else if(this=="javascript:void(4);"){
					$("#btn04").val("Y")  //caseAssign
				}else if(this=="javascript:void(5);"){
					$("#btn05").val("Y")	//caseAssign
				}else if(this=="javascript:void(6);"){
					$("#btn06").val("N") //caseSettleStatus
				}else if(this=="javascript:void(7);"){
					$("#btn07").val("")
				}
				
				$(this).addClass("tab_on")
				$(this).siblings(this).removeClass("tab_on")
				$("#twotable").bootstrapTable('refresh');//刷新
				//把值设为空
				$("#btn01").val("")
				$("#btn02").val("")
				$("#btn03").val("")
				$("#btn04").val("")
				$("#btn05").val("")
				$("#btn06").val("")
				$("#btn07").val("")
				$("#casePropernum").val("")
			});
    	
    	
    	
    	//点击操作显示
    	$("table").on("click",".case_set",function(){
    		var a = $(this).siblings().css("display");
    		if(a == "none"){
    			$(this).siblings().css("display","block")
    		}
    	})
    	//操作 移除消失
    	$("table").on("mouseleave","ul",function(){
    		var a = $(this).css("display");
    		if(a == "block"){
    			$(this).css("display","none")
    		}
    	})
    	
    });

		//批量生成文书
		//跳转页面addCase5_1
		function addCase5_1(row){
			$.cookie("anhao",row.case_propernum)
			window.location.href="addCase5_1/"+new Date().getTime()
		}

		//申请发票
		function WholeCaseCZ2(row) {
			$.cookie("id",row.id);
			$.cookie("case_propernum",row.case_propernum);
			$.cookie("case_agencyfee",row.case_agencyfee);
			$.cookie("case_paidsal",row.case_paidsal);
			$.cookie("caseInvoiced",row.caseInvoiced);
			$.cookie("client",row.client);		//客户
			window.location.href='WholeCaseCZ2';
		} 
		//---------------------------------------------------
		//案件档案归档 状态 case_clash
	    function DAGDAjax(id, v) {
	       $.ajax({
	            type: "POST",
	            url: "WholeCaseCZ4",
	            data: { "id": id, "case_clash": v },
	            success: function (result) {
	                    //关闭后的操作
	                    if (result == true) {
	                    	$("table").bootstrapTable('refresh');//刷新
	                        alert("设置成功")
	                    }
	            }
	        });
	    }
	    
	    function WholeCaseCZ4(row) {
	    	if(row.case_clash == 'Y'){
	    		DAGDAjax(row.id, 'N');
	    	}else{
	    		DAGDAjax(row.id, 'Y');
	    	}
	    }
	//---------------------------------------------------	
	    //共享案件
	    function CaseShare(e){
	    	alert("共享成功")
	    }
	    
	  //开庭
	    function kaitingMsgAdd(row){
	    	$.cookie("kaitingCase_propernum",row.case_propernum)
	    	$.cookie("kaitingId",row.id)
	    	window.location.href='kaitingMsgAdd';
	    } 
	    //侦查
	    function ZhenCha(row){
	    	$.cookie("ZhenChaCase_propernum",row.case_propernum)
	    	$.cookie("ZhenChaId",row.id)
	    	window.location.href='scoutAdd';
	    }   
	    //建查JianCha
	    function JianCha(row){
	    	$.cookie("JianChaCase_propernum",row.case_propernum)
	    	$.cookie("JianChaId",row.id)
	    	window.location.href='examineAdd';
	    }  
	    
Date.prototype.format = function(fmt) { 
     var o = { 
        "M+" : this.getMonth()+1,                 //月份 
        "d+" : this.getDate(),                    //日 
        "h+" : this.getHours(),                   //小时 
        "m+" : this.getMinutes(),                 //分 
        "s+" : this.getSeconds(),                 //秒 
        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
        "S"  : this.getMilliseconds()             //毫秒 
    }; 
    if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
     for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
         }
     }
    return fmt; 
}   









