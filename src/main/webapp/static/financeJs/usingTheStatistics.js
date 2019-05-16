function search(){
	if($("#properUp").val() != $("#proper").val()){
		alert("重新选择执业人员");
		return;
	}
	$("#showShouJieAn").bootstrapTable('refresh');
}

lay('.times').each(function(){
  laydate.render({
    elem: this,
    trigger: 'click',
    calendar: true
  });
}); 

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
	url : "statistics/using/lawType",
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
	url : "statistics/using/data",
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
			yyType : $("#yyType").val(),
			spStatus : $("#spStatus").val(),
			startTime : $("#startTime").val(),
			endTime : $("#endTime").val()
		};
		return temp;
	},
	columns : [ {
		title : "函号",
		field : "sanum"
	}, {
		title : "案号",
		field : "case_propernum"
	}, {
		title : "领用日期",
		formatter : function(val, row, len) {
			var cwInoutDate = new Date(row.applyfor_receive);
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
		title : "审批状态",
		field : "applyfor_approval_status"
	}, {
		title : "领用人",
		field : "emp_name"
	}, {
		title : "用印事项",
		field : "applyfor_using_the_item"
	}],
	onLoadSuccess : function(data) {
		$("#heji").html("0").html(data.total);
	}
});