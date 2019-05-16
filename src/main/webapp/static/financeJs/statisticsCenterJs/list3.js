function list3Hide(){
	$("#list3Data").hide();
	$("#list3But").hide();
	$("#list3").hide();
}

function list3Show(){
	$("#list3").show();
	$("#list3Data").hide();
	$("#list3But").hide();
}

function list3Export(){
	if($("#list3proper").val() != $("#list3properUp").val() || $("#list3properUp").val() == ""){
		alert("请重新选择执业人");
		$("#list3Data").hide();
		$("#list3But").hide();
		return;
	}
	if($("#list3startTime").val() == "" || $("#list3endTime").val() == ""){
		alert("请选择日期");
		$("#list3Data").hide();
		$("#list3But").hide();
		return;
	}
	var dwonFrm = document.list1dwon;
	dwonFrm.action = "statistics/center/list3Exprot";
	$("input[name='properId']").val($("#list3properId").val());
	$("input[name='startTime']").val($("#list3startTime").val());
	$("input[name='endTime']").val($("#list3endTime").val());
	dwonFrm.submit();
}

function showList3(){
	if($("#list3proper").val() != $("#list3properUp").val() || $("#list3properUp").val() == ""){
		alert("请选择执业人");
		$("#list3Data").hide();
		$("#list3But").hide();
		return;
	}
	if($("#list3startTime").val() == "" || $("#list3startTime").val() == ""){
		alert("请选择日期");
		$("#list3Data").hide();
		$("#list3But").hide();
		return;
	}
	$("#showList3").bootstrapTable("refresh");
	$("#showList3").bootstrapTable({
		url : "statistics/center/list3Data",
		method : 'get',
		dataType : "json",
		striped : true, // 是否显示行间隔色
		queryParams : function(params) { // 上传服务器的参数
			var temp = {
				properId : $("#list3properId").val(),
				startTime : $("#list3startTime").val(),
				endTime : $("#list3endTime").val()
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
			$("#list3Data").show();
			$("#list3But").show();
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
			var $index = $("#showList3 tr").last().attr(
				"data-index");
			var $tr = $("<tr data-index='" + (parseInt($index) + 1)
					+ "'></tr>");
			$tr.append("<td style>合计</td>");
			$tr.append("<td style>" + sumHetong + "</td>");
			$tr.append("<td style>" + sumInvoice + "</td>");
			$tr.append("<td style>" + sumInout + "</td>");
			$tr.append("<td style>" + sumGui + "</td>");
			$("#showList3 tbody").append($tr);
		}
	});
}

var perVal = "";
function selNames(val){
	$("#properSpan").html("");
	if(perVal == val) return;
	$("#list3properUp").val("");
	$("#list3properId").val("");
	perVal = val;
	if(val.split("'").length != 1) return;
	$("#list3auto_div").html("");
	$.ajax({
		type : "get",
		url : "statistics/center/names",
		async : true,
		dataType : "json",
		data : "name=" + val,
		beforeSend:function(XMLHttpRequest){
			$("#list3auto_div").html("").html("&nbsp;&nbsp;&nbsp;搜索中...");
			$("#list3auto_div").show();
        },success : function(value) {
        	$("#list3auto_div").html("");
			var $ul = $("<ul style='margin-top: 5px; margin-bottom: 5px margin-left:0px;padding-left:0px; list-style: none;'></ul>");
			if(value.length == 0) {
				$("#list3auto_div").html("&nbsp;&nbsp;&nbsp;未找到此律师,律师名称输入不正确");
				$("#list3auto_div").show();
				return;
			}
			$(value).each(function(len, obj){
				if(obj.empName == val){
					$("#list3properId").val(obj.id);
					$("#list3properUp").val(obj.empName);
				}
				$ul.append("<li style='color:red; height: 23px; padding-left:10px;' onclick='onclickName(this);'"  
					+ " onmouseover='setCss(this);' onmouseout='setCssOut(this);' value='" + obj.id + "'>"+obj.empName+"</li>");
			});
			$("#list3auto_div").html("").append($ul);
			$("#list3auto_div").show();
		},error:function(XMLHttpRequest,textStatus,errorThrown){
			$("#list3auto_div").html("").html("&nbsp;&nbsp;&nbsp;网络异常");
			$("#list3auto_div").show();
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
	$("#list3proper").val($(obj).html());
	$("#list3properId").val($(obj).attr("value"));
	$("#list3properUp").val($(obj).html());
	$("#list3auto_div").hide();
}
$("body").click(function(e) {
	if($(e.target).attr("id") != 'proper' && $(e.target).attr("id") != 'list3auto_div'){
		$("#list3auto_div").hide();
	}
});