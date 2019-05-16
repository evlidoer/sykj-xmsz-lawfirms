function list2Hide(){
	$("#list2Data").hide();
	$("#list2But").hide();
	$("#list2").hide();
}

function list2Show(){
	$("#list2").show();
	$("#list2Data").hide();
	$("#list2But").hide();
}

function list2Export(){
	if($("#list2startTime").val() == "" || $("#list2endTime").val() == ""){
		alert("请选择日期");
		$("#list2Data").hide();
		$("#list2But").hide();
		return;
	}
	var dwonFrm = document.list1dwon;
	dwonFrm.action = "statistics/center/list2Exprot";
	$("input[name='startTime']").val($("#list2startTime").val());
	$("input[name='endTime']").val($("#list2endTime").val());
	dwonFrm.submit();
}

function showList2(){
	if($("#list2startTime").val() == "" || $("#list2startTime").val() == ""){
		alert("请选择日期");
		$("#list2Data").hide();
		$("#list2But").hide();
		return;
	}
	$("#showList2").bootstrapTable("refresh");
	$("#showList2").bootstrapTable({
		url : "statistics/center/list2Data",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				startTime : $("#list2startTime").val(),
				endTime : $("#list2endTime").val()
			};
			return temp;
		},
		columns : [ {
			title: '序号',
			formatter: function (value, row, index) {
				return index+1;
			}
		}, {
			title : "姓名",
			field : "emp_name"
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
			$("#list2Data").show();
			$("#list2But").show();
			var sumInvoice = 0;
			var sumInout = 0;
			var sumGui = 0;
			$(data).each(function(len, val){
				sumInvoice += val.sumInvoice;
				sumInout += val.sumInout;
				sumGui += val.sumGui;
			});
			var $index = $("#showList2 tr").last().attr(
				"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td style>合计</td>");
			$tr.append("<td style></td>");
			$tr.append("<td style>" + sumInvoice + "</td>");
			$tr.append("<td style>" + sumInout + "</td>");
			$tr.append("<td style>" + sumGui + "</td>");
			$("#showList2 tbody").append($tr);
		}
	});
}