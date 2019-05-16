function list5Hide(){
	$("#list5Data").hide();
	$("#list5But").hide();
	$("#list5").hide();
}

function list5Show(){
	$("#list5").show();
	$("#list5Data").hide();
	$("#list5But").hide();
}

function list5Export(){
	if($("#list5startTime").val() == "" || $("#list5endTime").val() == ""){
		alert("请选择日期");
		$("#list5Data").hide();
		$("#list5But").hide();
		return;
	}
	var dwonFrm = document.list1dwon;
	dwonFrm.action = "statistics/center/list5Exprot";
	$("input[name='startTime']").val($("#list5startTime").val());
	$("input[name='endTime']").val($("#list5endTime").val());
	dwonFrm.submit();
}

function showList5(){
	if($("#list5startTime").val() == "" || $("#list5endTime").val() == ""){
		alert("请选择日期");
		$("#list5Data").hide();
		$("#list5But").hide();
		return;
	}
	$("#showList5").bootstrapTable("refresh");
	$("#showList5").bootstrapTable({
		url : "statistics/center/list5Data",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				startTime : $("#list5startTime").val(),
				endTime : $("#list5endTime").val()
			};
			return temp;
		},
		columns : [ {
			title : "日期",
			field : "date1"
		}, {
			title : "民事案件",
			field : "1001"
		}, {
			title : "刑事案件",
			field : "1002"
		}, {
			title : "行政案件",
			field : "1003"
		}, {
			title : "非诉讼法律事务",
			field : "1004"
		}, {
			title : "法律顾问",
			field : "1005"
		}, {
			title : "法律援助",
			field : "1006"
		}, {
			title : "执行案件",
			field : "1007"
		}, {
			title : "中保案件",
			field : "1008"
		}, {
			title : "仲裁案件",
			field : "1009"
		}, {
			title : "破产案件",
			field : "1010"
		}, {
			title : "咨询代写文书",
			field : "1011"
		}],
		onLoadSuccess : function(data) {
			$("#list5Data").show();
			$("#list5But").show();
			var a1001 = 0;
			var a1002 = 0;
			var a1003 = 0;
			var a1004 = 0;
			var a1005 = 0;
			var a1006 = 0;
			var a1007 = 0;
			var a1008 = 0;
			var a1009 = 0;
			var a1010 = 0;
			var a1011 = 0;
			var arr = [1001];
			$(data).each(function(len, val){
				for(var key in val){
					if(key == 1001) a1001 += val[key];
					if(key == 1002) a1002 += val[key];
					if(key == 1003) a1003 += val[key];
					if(key == 1004) a1004 += val[key];
					if(key == 1005) a1005 += val[key];
					if(key == 1006) a1006 += val[key];
					if(key == 1007) a1007 += val[key];
					if(key == 1008) a1008 += val[key];
					if(key == 1009) a1009 += val[key];
					if(key == 1010) a1010 += val[key];
					if(key == 1011) a1011 += val[key];
				}
			});
			var $index = $("#showList5 tr").last().attr(
					"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td style>合计</td>");
			$tr.append("<td style>" + a1001 + "</td>");
			$tr.append("<td style>" + a1002 + "</td>");
			$tr.append("<td style>" + a1003 + "</td>");
			$tr.append("<td style>" + a1004 + "</td>");
			$tr.append("<td style>" + a1005 + "</td>");
			$tr.append("<td style>" + a1006 + "</td>");
			$tr.append("<td style>" + a1007 + "</td>");
			$tr.append("<td style>" + a1008 + "</td>");
			$tr.append("<td style>" + a1009 + "</td>");
			$tr.append("<td style>" + a1010 + "</td>");
			$tr.append("<td style>" + a1011 + "</td>");
			$("#showList5 tbody").append($tr);
		}
	});
}