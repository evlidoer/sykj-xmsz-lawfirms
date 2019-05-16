function list1Hide(){
	$("#list1Data").hide();
	$("#list1But").hide();
	$("#list1").hide();
}

function list1Show(){
	$("#list1").show();
	$("#list1Data").hide();
	$("#list1But").hide();
}

function list1Export(){
	if($("#list1startTime").val() == "" || $("#list1endTime").val() == ""){
		alert("请选择日期");
		$("#list1Data").hide();
		$("#list1But").hide();
		return;
	}
	var dwonFrm = document.list1dwon;
	dwonFrm.action = "statistics/center/list1Exprot";
	$("input[name='startTime']").val($("#list1startTime").val());
	$("input[name='endTime']").val($("#list1endTime").val());
	dwonFrm.submit();
}

function showList1(){
	if($("#list1startTime").val() == "" || $("#list1endTime").val() == ""){
		alert("请选择日期");
		$("#list1Data").hide();
		$("#list1But").hide();
		return;
	}
	$("#showList1").bootstrapTable("refresh");
	$("#showList1").bootstrapTable({
		url : "statistics/center/list1Data",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				startTime : $("#list1startTime").val(),
				endTime : $("#list1endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "日期",
			field : "times"
		}, {
			title : "合同金额",
			field : "sumHetong"
		}, {
			title : "开票金额",
			field : "sumInvoice"
		}, {
			title : "收款金额",
			field : "sumInout"
		}, {
			title : "归档金额",
			field : "sumGui"
		}],
		onLoadSuccess : function(data) {
			$("#list1Data").show();
			$("#list1But").show();
			var sumHetong = 0;
			var sumInvoice = 0;
			var sumInout = 0;
			var sumGui = 0;
			$(data).each(function(len, val){
				sumHetong += val.sumHetong;
				sumInvoice += val.sumInvoice;
				sumInout += val.sumInout;
				sumGui += val.sumGui;
			});
			var $index = $("#showList1 tr").last().attr(
				"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td style>合计</td>");
			$tr.append("<td style>" + sumHetong + "</td>");
			$tr.append("<td style>" + sumInvoice + "</td>");
			$tr.append("<td style>" + sumInout + "</td>");
			$tr.append("<td style>" + sumGui + "</td>");
			$("#showList1 tbody").append($tr);
		}
	});
}
