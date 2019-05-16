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


lay('.Time').each(function() {
	laydate.render({
		elem : this,
		trigger : 'click'
	});
});

function getCtype() {
	$.ajax({
		type : "get",
		url : "finance/budget/Ctype",
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
}

getCtype();
getVal();

function getVal(){
	$("#showInvoice").bootstrapTable({
		url : "finance/invoice/getVal",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		pageNumber : 1, // 初始化加载第一页
		pagination : true, // 是否分页
		sidePagination : 'server', // server:服务器端分页|client：前端分页
		pageSize : 11, // 单页记录数
		pageList : [ 5, 11, 17, 23 ], // 可选择单页记录数
		queryParams : function(params) { // 上传服务器的参数
				var temp = { // 如果是在服务器端实现分页，limit、offset这两个参数是必须的
				limit : params.limit, // 每页显示数量
				offset : params.offset, // SQL语句起始索引
				caseId : $("#caseId").val(),
				caseIdNum : $("#caseIdNum").val(),
				kStatus : $("#kStatus").val(),
				kType : $("#kType").val(),
				kProject : $("#kProject").val(),
				cType : $("#cType").val(),
				startTime : $("#startTime").val(),
				endTime : $("#endTime").val()
			};
			return temp;
		},
		columns : [{
			title : "案号",
			formatter : function(val, row, len) {
				// 跳转至案件详细页面
				return "<a href='javascpit:"+ row.lawId +";'  class='a_black' title='"
						+ row.propernum
						+ "'>"
						+ row.propernum + "</a>";
			}
		},{
			title : "发票抬头",
			field : "iTitle"
		},{
			title : "发票金额(元)",
			field : "invoicemoney"
		},{
			title : "申请日期",
			formatter : function(val, row, len) {
				var cwEnteringdate = new Date(
						row.appDate);
				var cwMonth = cwEnteringdate.getMonth() + 1;
				var cwDate = cwEnteringdate.getDate();
				var returnVal = cwEnteringdate
						.getFullYear()
						+ "-"
						+ (cwMonth < 10 ? ("0" + cwMonth)
								: cwMonth)
						+ "-"
						+ (cwDate < 10 ? ("0" + cwDate)
								: cwDate);
				return returnVal;
			}
		},{
			title : "开票日期",
			formatter : function(val, row, len) {
				var cwEnteringdate = new Date(
						row.invoiceDate);
				var cwMonth = cwEnteringdate.getMonth() + 1;
				var cwDate = cwEnteringdate.getDate();
				var returnVal = cwEnteringdate
						.getFullYear()
						+ "-"
						+ (cwMonth < 10 ? ("0" + cwMonth)
								: cwMonth)
						+ "-"
						+ (cwDate < 10 ? ("0" + cwDate)
								: cwDate);
				return returnVal;
			}
		},{
			title : "开票状态",
			formatter : function(val, row, len) {
				var status = row.iStatus;
				return status == 'Y' ? '已开' : '未开';
			}
		}, {
			title : "操作",
			formatter : function(val, row, len) {
				return '查看';
			}
		}],
		onLoadSuccess : function(data) {
		}
	});
}