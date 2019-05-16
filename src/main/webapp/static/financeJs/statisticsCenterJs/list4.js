function list4Hide(){
	$("#list4Data").hide();
	$("#list4But").hide();
	$("#list4").hide();
}

function list4Show(){
	$("#list4").show();
	$("#list4Data").hide();
	$("#list4But").hide();
}

function list4Export(){
	if($("#list4startTime").val() == "" || $("#list4endTime").val() == ""){
		alert("请选择日期");
		$("#list4Data").hide();
		$("#list4But").hide();
		return;
	}
	var dwonFrm = document.list1dwon;
	dwonFrm.action = "statistics/center/list4Exprot";
	$("input[name='startTime']").val($("#list4startTime").val());
	$("input[name='endTime']").val($("#list4endTime").val());
	dwonFrm.submit();
}

function showList4(){
	if($("#list4startTime").val() == "" || $("#list4endTime").val() == ""){
		alert("请选择日期");
		$("#list4Data").hide();
		$("#list4But").hide();
		return;
	}
	$("#showList4").bootstrapTable("refresh");
	$("#showList4").bootstrapTable({
		url : "statistics/center/list4Data",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				startTime : $("#list4startTime").val(),
				endTime : $("#list4endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "收费方式",
			field : "cw_pay_type"
		}, {
			title : "收费金额",
			field : "money"
		}],
		onLoadSuccess : function(data) {
			$("#list4Data").show();
			$("#list4But").show();
			var moneyNum = 0;
			data.forEach(function(val, len, arr) {
				moneyNum+=val.money;
			});
			var $index = $("#showList4 tr").last().attr(
					"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td style>合计</td>");
			$tr.append("<td style>" + moneyNum + "元</td>");
			$("#showList4 tbody").append($tr);
		}
	});
}