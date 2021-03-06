var perVal = "";
function selNames(val){
	if(perVal == val) return;
	perVal = val;
	if(val.split("'").length != 1) return;
	$("#auto_div").html("");
	$.ajax({
		type : "get",
		url : "statistics/prosonFinance/names",
		async : true,
		dataType : "json",
		data : "name=" + val,
		beforeSend:function(XMLHttpRequest){
			$("#auto_div").html("").html("&nbsp;&nbsp;&nbsp;搜索中...");
			$("#auto_div").show();
        },success : function(value) {
        	$("#auto_div").html("");
			var $ul = $("<ul style='margin-top: 5px; margin-bottom: 5px margin-left:0px;padding-left:0px; list-style: none;'></ul>");
			if(value.length == 0) {
				$("#auto_div").html("&nbsp;&nbsp;&nbsp;未找到此律师,律师名称输入不正确");
				$("#auto_div").show();
				return;
			}
			$(value).each(function(len, obj){
				if(obj.empName == val){
					$("#properId").val(obj.id);
					$("#properUp").val(obj.empName);
				}
				$ul.append("<li style='color:red; height: 23px; padding-left:10px;' onclick='onclickName(this);'"  
					+ " onmouseover='setCss(this);' onmouseout='setCssOut(this);' value='" + obj.id + "'>"+obj.empName+"</li>");
			});
			$("#auto_div").html("").append($ul);
			$("#auto_div").show();
		},error:function(XMLHttpRequest,textStatus,errorThrown){
			$("#auto_div").html("").html("&nbsp;&nbsp;&nbsp;网络异常");
			$("#auto_div").show();
        }
	});
}
var lsPerVal = "";
function selLsNames(val){
	if(lsPerVal == val) return;
	lsPerVal = val;
	$("#lsproperId").val("");
	if(val.split("'").length != 1) return;
	$("#lsauto_div").html("");
	$.ajax({
		type : "get",
		url : "statistics/prosonFinance/names",
		async : true,
		dataType : "json",
		data : "name=" + val,
		beforeSend:function(XMLHttpRequest){
			$("#lsauto_div").html("").html("&nbsp;&nbsp;&nbsp;搜索中...");
			$("#lsauto_div").show();
        },success : function(value) {
        	$("#lsauto_div").html("");
			var $ul = $("<ul style='margin-top: 5px; margin-bottom: 5px margin-left:0px;padding-left:0px; list-style: none;'></ul>");
			if(value.length == 0) {
				$("#lsauto_div").html("&nbsp;&nbsp;&nbsp;未找到此律师,律师名称输入不正确");
				$("#lsauto_div").show();
				return;
			}
			$(value).each(function(len, obj){
				if(obj.empName == val){
					$("#lsproperId").val(obj.id);
					$("#lsproperUp").val(obj.empName);
				}
				$ul.append("<li style='color:red; height: 23px; padding-left:10px;' onclick='onclicklsName(this);'"  
					+ " onmouseover='setCss(this);' onmouseout='setCssOut(this);' value='" + obj.id + "'>"+obj.empName+"</li>");
			});
			$("#lsauto_div").html("").append($ul);
			$("#lsauto_div").show();
		},error:function(XMLHttpRequest,textStatus,errorThrown){
			$("#lsauto_div").html("").html("&nbsp;&nbsp;&nbsp;网络异常");
			$("#lsauto_div").show();
        }
	});
}

function setCss(obj){
	$(obj).css("background-color","#dddddd").css("cursor","pointer");
}	
function setCssOut(obj){
	$(obj).css("background-color","#ffffff");
}
function onclickName(obj){
	$("#proper").val($(obj).html());
	$("#properId").val($(obj).attr("value"));
	$("#properUp").val($(obj).html());
	$("#auto_div").hide();
}

function onclicklsName(obj){
	$("#lsproperId").val($(obj).attr("value"));
	$("#lsproperUp").val($(obj).html());
	$("#lsproper").val($(obj).html());
	$("#lsauto_div").hide();
}
$("body").click(function(e) {
	if($(e.target).attr("id") != 'proper' && $(e.target).attr("id") != 'auto_div'){
		$("#auto_div").hide();
		$("#lsfauto_div").hide();
	}
});

getCommission();
getReserved();
getRevenue();

function printRequest(){
	var newHtml = $("#listdiv").html();
	var ordHtml = $("body").html();
	$("body").html(newHtml);
	window.print();
	$("body").html(ordHtml);
	window.location.reload();
}

function formatDate(element, date) {
	var arr = date.split("-");
	element.html(arr[0] + "年" + arr[1] + "月" + arr[2] + "日");
}

function retrieve() {
	if($("#startTime").val() == '' || $("#endTime").val() == ''){
		$("#listdiv").hide();
		$("#butdiv").hide();
		alert("请选择完整的时间段");
		return;
	}
	if($("#properId").val() == '' || $("#properUp").val() != $("#proper").val()){
		$("#listdiv").hide();
		$("#butdiv").hide();
		alert("请选择执业人员");
		return;
	}
	$("#sumSpan").html("0");
	formatDate($("#startTimeShow"), $("#startTime").val());
	formatDate($("#endTimeShow"), $("#endTime").val());
	$("#listdiv").show();
	$("#butdiv").show();
	$("#commission").bootstrapTable('refresh');
	$("#reserved").bootstrapTable('refresh');
	$("#revenue").bootstrapTable('refresh');
	$("#zyName").html("").html($("#properUp").val());
	$("#properIdPlus").val($("#properId").val());
}

function queryCurrentData(num) {
	var dateNew = new Date($.ajax({
		async : false
	}).getResponseHeader("Date"));
	var longDate = num * 30;
	if (longDate == 360)
		longDate = 365;
	var dateLast = new Date(dateNew - longDate * 24 * 60 * 60 * 1000);
	$("#startTime").val(
			dateLast.getFullYear()
					+ "-"
					+ ((dateLast.getMonth() + 1) < 10 ? ("0" + (dateLast
							.getMonth() + 1)) : (dateLast.getMonth() + 1))
					+ "-"
					+ (dateLast.getDate() < 10 ? ("0" + dateLast.getDate())
							: dateLast.getDate()));
	$("#endTime").val(
			dateNew.getFullYear()
					+ "-"
					+ ((dateNew.getMonth() + 1) < 10 ? ("0" + (dateNew
							.getMonth() + 1)) : (dateNew.getMonth() + 1))
					+ "-"
					+ (dateNew.getDate() < 10 ? ("0" + dateNew.getDate())
							: dateNew.getDate()));
	retrieve();
}

function proMoneyFun(money){
	var proMoney = money * 10.63;
	if(proMoney < 100) proMoney = 100;
	if(proMoney > 7000) proMoney = 7000;
	return proMoney;
}

lay('.Time').each(function() {
	laydate.render({
		elem : this,
		trigger : 'click'
	});
});

function showMonthly() {
	$("#showHistory").removeClass("active");
	$("#showMonthly").addClass("active");
	$("#monthly").show();
	$("#butdiv").hide();
	$("#listdiv").hide();
	$("#lsMod").hide();
}

function showHistory() {
	$("#showMonthly").removeClass("active");
	$("#showHistory").addClass("active");
	$("#monthly").hide();
	$("#butdiv").hide();
	$("#lsMod").show();
	$('#lsTable').bootstrapTable('refresh');
}

function getRevenue(){
	$("#revenue").bootstrapTable({
		url : "statistics/prosonFinance/revenue",
		method : 'get',
		dataType : "json",
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				id : $("#properId").val(),
				startTime : $("#startTime").val(),
				endTime : $("#endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "承办律师",
			field : "caseLawyer"
		}, {
			title : "案号",
			formatter : function(val, row, len) {
				if(JSON.stringify(row.caseUmber) == 'null'){
					return "-";
				}else{
					// 跳转至案件详细页面
					return "<a href='javascpit:"+ row.caseLawId +";'  class='a_black' title='"
							+ row.caseUmber
							+ "'>"
							+ row.caseUmber + "</a>";
				}
			}
		}, {
			title : "委托人",
			field : "caseParties"
		}, {
			title : "对方当事人",
			field : "caseOppositeParties"
		}, {
			title : "收款日期",
			formatter : function(val, row, len) {
				var cwInoutDate = new Date(row.cwInoutDate);
				var cwMonth = cwInoutDate.getMonth() + 1;
				var cwDate = cwInoutDate.getDate();
				var returnVal = cwInoutDate.getFullYear()
						+ "-"
						+ (cwMonth < 10 ? ("0" + cwMonth)
								: cwMonth)
						+ "-"
						+ (cwDate < 10 ? ("0" + cwDate)
								: cwDate);
				return returnVal;
			}
		}, {
			title : "收款金额",
			formatter : function(val, row, len) {
				var money = row.cwInoutMoney;
				return money.toFixed(2);
			}
		}, {
			title : "备注",
			formatter:function(val,row,len){
				if(row.cwRemark == null ){
					return row.cwPayType;
				}else{
					return row.cwPayType + "," + row.cwRemark;
				}
			}
		} ],
		onLoadSuccess : function(data) {
			$("#revenueSpan").html("0");
			$("#revenueDiv").attr("on","off");
			if(data.length == 0){
				$("#sumSpan").html((parseFloat($("#sumSpan").html()) + parseFloat($("#revenueSpan").html())).toFixed(2));
				$("#revenueDiv").hide();
				return;
			}
			var moneyNum = 0;
			var moneyNum2 = 0;
			data.forEach(function(val, len, arr) {
				if(val.casePlan != 'C') moneyNum2 += val.cwInoutMoney;
				moneyNum += val.cwInoutMoney;
			});
			var $index = $("#showTable tr").last().attr(
					"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td colspan='7' style>合计:&nbsp;" + moneyNum.toFixed(2) + "元</td>");
			$("#revenue tbody").append($tr);
			$("#revenueSpan").html("").html(moneyNum2);
			$("#sumSpan").html((parseFloat($("#sumSpan").html()) + parseFloat($("#revenueSpan").html())).toFixed(2));
			$("#revenueDiv").show();
			$("#revenueDiv").attr("on","on");
		}
	});
}

function getReserved(){
	$("#reserved").bootstrapTable({
		url : "statistics/prosonFinance/reserved",
		method : 'get',
		dataType : "json",
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				id : $("#properId").val(),
				startTime : $("#startTime").val(),
				endTime : $("#endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "案号",
			formatter : function(val, row, len) {
				console.log(typeof row.caseUmber);
				if(row.caseUmber == undefined){
					return "-";
				}else{
					// 跳转至案件详细页面
					return "<a href='javascpit:"+ row.caseLawId +";'  class='a_black' title='"
							+ row.caseUmber
							+ "'>"
							+ row.caseUmber + "</a>";
				}
			}
		}, {
			title : "总收款金额",
			formatter : function(val, row, len) {
				var money = row.sumMoney;
				return  money.toFixed(2);
			}
		}, {
			title : "归档预留",
			formatter : function(val, row, len) {
				return proMoneyFun(row.sumMoney);
			}
		} ],
		onLoadSuccess : function(data) {
			$("#reservedSpan").html("0");
			$("#reservedDiv").attr("on","off")
			if(data.length == 0){
				$("#sumSpan").html((parseFloat($("#sumSpan").html()) - parseFloat($("#reservedSpan").html())).toFixed(2));
				$("#reservedDiv").hide();
				return;
			}
			var proMoney = 0;
			data.forEach(function(val, len, arr) {
				proMoney+=proMoneyFun(val.sumMoney);
			});
			var $index = $("#showTable tr").last().attr(
					"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td colspan='3' style>合计:&nbsp;" + proMoney.toFixed(2) + "元</td>");
			$("#reserved tbody").append($tr);
			$("#reservedSpan").html("").html(proMoney.toFixed(2));
			$("#sumSpan").html((parseFloat($("#sumSpan").html()) - parseFloat($("#reservedSpan").html())).toFixed(2));
			$("#reservedDiv").show();
			$("#reservedDiv").attr("on","on")
		}
	});
}


function getCommission(){
	$("#commission").bootstrapTable({
		url : "statistics/prosonFinance/commission",
		method : 'get',
		dataType : "json",
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				id : $("#properId").val(),
				startTime : $("#startTime").val(),
				endTime : $("#endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "承办律师",
			field : "caseLawyer"
		}, {
			title : "案号	",
			formatter : function(val, row, len) {
				// 跳转至案件详细页面
				return "<a href='javascpit:"+ row.caseLawId +";'  class='a_black' title='"
						+ row.caseUmber
						+ "'>"
						+ row.caseUmber + "</a>";
			}
		}, {
			title : "委托人",
			field : "caseParties"
		}, {
			title : "对方当事人",
			field : "caseOppositeParties"
		}, {
			title : "创收金额",
			formatter : function(val, row, len) {
				var money = row.sumMoney;
				return money.toFixed(2);
			}
		}, {
			title : "归档金",
			field : "sumMoney"
		} ],
		onLoadSuccess : function(data) {
			$("#commissionSpan").html("0");
			$("#commissionDiv").attr("on","off");
			if(data.length == 0){
				$("#sumSpan").html((parseFloat($("#sumSpan").html()) + parseFloat($("#commissionSpan").html())).toFixed(2));
				$("#commissionDiv").hide();
				return;
			}
			var proMoney = 0;
			data.forEach(function(val, len, row){
				proMoney+=val.sumMoney;
			});
			var $index = $("#showTable tr").last().attr(
					"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td colspan='7' style>合计:&nbsp;" + proMoney.toFixed(2) + "元</td>");
			$("#commission tbody").append($tr);
			$("#commissionSpan").html("").html(proMoney.toFixed(2));
			$("#sumSpan").html((parseFloat($("#sumSpan").html()) + parseFloat($("#commissionSpan").html())).toFixed(2));
			$("#commissionDiv").show();
			$("#commissionDiv").attr("on","on");
		}
	});
}