lay('.times').each(function(){
  laydate.render({
    elem: this,
    trigger: 'click',
    calendar: true
  });
}); 

function search(){
	if($("#properUp").val() != $("#proper").val()){
		alert("重新选择执业人员");
		return;
	}
	$("#showShouJieAn").bootstrapTable('refresh');
}

function cTypeEach(lower, id, arr) {
	arr.forEach(function(val, len, array) {
		if (id == val.typeId) {
			var ssid = val.id;
			$("#cType").append(
					'<option value="' + val.id + '">' + lower
							+ "&nbsp;-&nbsp;&nbsp;-&nbsp;" + val.caseTypeName
							+ '</option>');
			delete arr[len];
			cTypeEach(lower + '&nbsp;-&nbsp;&nbsp;-&nbsp;', ssid, arr);
		}
	});
}

$.ajax({
	type : "get",
	url : "statistics/shoujiean/lawType",
	async : true,
	dataType : "json",
	success : function(data) {
		data.forEach(function(val, len, arr) {
			var sid = val.id;
			$("#cType").append(
					'<option value="' + val.id + '">' + val.caseTypeName
							+ '</option>');
			delete arr[len];
			cTypeEach('&nbsp;&nbsp;', sid, arr);
		});
	}
});

$("#showShouJieAn").bootstrapTable({
	url : "statistics/shoujiean/data",
	method : 'get',
	dataType : "json",
	striped : true, // 是否显示行间隔色
	pageNumber : 1, // 初始化加载第一页
	pagination : true, // 是否分页
	sidePagination : 'server', // server:服务器端分页|client：前端分页
	pageSize : 10, // 单页记录数
	pageList : [5, 10, 15, 20 ], // 可选择单页记录数
	queryParams : function(params) { // 上传服务器的参数
		var temp = {
			limit : params.limit, // 每页显示数量
			offset : params.offset, // SQL语句起始索引
			properId : $("#properId").val(),
			cType : $("#cType").val(),
			ssjd : $("#ssjd").val(),
			jaStatus : $("#jaStatus").val(),
			sffs : $("#sffs").val(),
			startTime : $("#startTime").val(),
			endTime : $("#endTime").val(),
			dagd : $("#dagd").val()
		};
		return temp;
	},
	columns : [ {
		title : "案号",
		field : "case_propernum"
	}, {
		title : "案由",
		field : "case_cause"
	}, {
		title : "收案日期",
		formatter : function(val, row, len) {
			var cwInoutDate = new Date(row.case_subtime);
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
		title : "委托人",
		field : "case_parties"
	}, {
		title : "对方当事人",
		field : "case_opposite_parties"
	}, {
		title : "承办律师",
		field : "emp_name"
	}, {
		title : "受理单位",
		field : "case_accept"
	} , {
		title : "标的(万元)",
		formatter : function(val, row, len) {
			if(row.case_lawsuitobj == null) return "";
			var obk = parseFloat(row.case_lawsuitobj);
			return (obk/10000).toFixed(2);
		}
	}, {
		title : "收费(万元)",
		formatter : function(val, row, len) {
			if(row.agencyfee == null) return "";
			var obk = parseFloat(row.agencyfee);
			return (obk/10000).toFixed(2);
		}
	} , {
		title : "已付款(元)",
		field : "sumInout"
	} , {
		title : "已开票(元)",
		field : "sumInvoice"
	} , {
		title : "结案日期",
		formatter : function(val, row, len) {
			if(row.case_settle_date == null) return "未结案";
			var cwInoutDate = new Date(row.case_settle_date);
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
	} , {
		title : "结案方式",
		formatter : function(val, row, len) {
			if(row.case_settle_way == null) return "";
			return row.case_settle_way;
		}
	} , {
		title : "归档状态",
		formatter : function(val, row, len) {
			return row.case_clash == null ? "未归档" : row.case_clash == "N" ? "未归档" : "已归档";
		}
	} , {
		title : "归档号",
		formatter : function(val, row, len) {
			if(row.case_filenumber == null) return "";
			return row.case_filenumber;
		}
	} ],
	onLoadSuccess : function(data) {
		$("#heji").html("0").html(data.total);
		var sumBiaode = 0;
		var sumDaili = 0;
		var sumInout = 0;
		var sumInvoice = 0;
		$(data.rows).each(function(len, val){
			if(val.case_lawsuitobj != null) sumBiaode += (parseFloat(val.case_lawsuitobj)/10000);
			if(val.agencyfee != null) sumDaili += (parseFloat(val.agencyfee)/10000);
			sumInout += val.sumInout;
			sumInvoice += val.sumInvoice;
		});
		var $index = $("#showShouJieAn tr").last().attr(
				"data-index");
		var $tr = $("<tr data-index='" + (parseInt($index) + 1)
				+ "'></tr>");
		/*var $td = "<td style></td>";*/
		$tr.append("<td style colspan='15'>&nbsp;&nbsp;&nbsp;&nbsp;标的合计：" + sumBiaode.toFixed(4) + "万元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收费合计：" + sumDaili.toFixed(4) + "万元" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已收款合计：" + sumInout + "元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已开票合计：" + sumInvoice + "元</td>");
		$("#showShouJieAn tbody").append($tr);
	}
});