var map = gotoUrlAttr();
$("#zyName").html("").html(urlAttrToUtf8(map.get("name")));
formatDate($("#startTimeShow"), map.get("start"));
formatDate($("#endTimeShow"), map.get("end"));

$("#revenue").bootstrapTable({
	url : "statistics/prosonFinance/revenue",
	method : 'get',
	dataType : "json",
	queryParams : function(params) { // 上传服务器的参数
		var temp = {
			id : map.get("id"),
			startTime : map.get("start"),
			endTime : map.get("end")
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

function proMoneyFun(money){
	var proMoney = money * 10.63;
	if(proMoney < 100) proMoney = 100;
	if(proMoney > 7000) proMoney = 7000;
	return proMoney;
}

$("#reserved").bootstrapTable({
	url : "statistics/prosonFinance/reserved",
	method : 'get',
	dataType : "json",
	queryParams : function(params) { // 上传服务器的参数
		var temp = {
			id : map.get("id"),
			startTime : map.get("start"),
			endTime : map.get("end")
		};
		return temp;
	},
	columns : [ {
		title : "案号",
		formatter : function(val, row, len) {
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

$("#commission").bootstrapTable({
	url : "statistics/prosonFinance/commission",
	method : 'get',
	dataType : "json",
	queryParams : function(params) { // 上传服务器的参数
		var temp = {
			id : map.get("id"),
			startTime : map.get("start"),
			endTime : map.get("end")
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

function formatDate(element, date) {
	var arr = date.split("-");
	element.html("").html(arr[0] + "年" + arr[1] + "月" + arr[2] + "日");
}