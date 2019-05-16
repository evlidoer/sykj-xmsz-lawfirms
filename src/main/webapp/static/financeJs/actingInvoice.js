$.ajax({
	type : "get",
	url : "finance/acting/f",
	dataType : "json",
	success : function(data) {
		$(data).each(function(len,val){
			$("#wuliuCompany").append("<option value='" + val.id + "'>" + val.gs_name + "</option>");
		});
	}
});

$.ajax({
	type : "get",
	url : "finance/acting/kb",
	dataType : "json",
	success : function(data) {
		$(data).each(function(len,val){
			$("#wuliuType").append("<option value='" + val.id + "'>" + val.kd_type + "</option>");
		});
	}
});

function showOptional(obj){
	var on = $(obj).attr("on");
	if(on == 'off'){
		$(obj).attr("on","on");
		$(obj).find("span").attr("class", "glyphicon glyphicon-resize-small");
		$(obj).find("font").html("收起");
		$("#showOptional").show();
	}else{
		$(obj).attr("on","off");
		$(obj).find("span").attr("class", "glyphicon glyphicon-resize-full");
		$(obj).find("font").html("展开");
		$("#showOptional").hide();
	}
}

function clickSubmit(){
	var bol = true;
	if($("#lawName").val() == "" || $("#lawNameId").val() == ""){
		$("#lawNameSpan").html("").html("请选择案件");
		bol = false;
	}
	if($("#lawName").val() == "" || $("#lawNameId").val() == ""){
		$("#lawNameSpan").html("").html("请选择案件");
		bol = false;
	}
	if($("#properUp").val() != $("#proper").val()){
		$("#properSpan").html("").html("请输入正确的申请人");
		bol = false;
	}
	if($("#proper").val() == ""){
		$("#properSpan").html("").html("请输入申请人");
		bol = false;
	}
	if($("#cw_taitouPerson").val() == ""){
		$("#cw_taitouPersonSpan").html("").html("请填写发票抬头");
		bol = false;
	}
	if($("#kaipiaoMoney").val() == ""){
		$("#kaipiaoMoneySpan").html("").html("请填写开票金额");
		bol = false;
	}
	if($("#kaipiaoProject").val() == "-1"){
		$("#kaipiaoProjectSpan").html("").html("请选择开票项目");
		bol = false;
	}
	if($("#identityNumber").val() == ""){
		$("#identityNumberSpan").html("").html("请填写纳税人识别号");
		bol = false;
	}
	if($("#invoiceNumber").val() == ""){
		$("#invoiceNumberSpan").html("").html("请填写发票号");
		bol = false;
	}
	if($("#kaipiaoDate").val() == ""){
		$("#kaipiaoDateSpan").html("").html("请选择开票日期");
		bol = false;
	}
	if(bol) clickSubmitAjax();
}

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if(o[this.name]) {
			if(!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}

function clickSubmitAjax(){
	var $formData = new FormData();
	$formData.append("mypath",$("#suiFile")[0].files[0]);
	var params = $("#putForm").serializeObject(); //将表单序列化为JSON对象
	$formData.append("kdManagerF",JSON.stringify(params));
	$.ajax({
		type : "post",
		url : "finance/acting/updata",
		dataType : "json",
		data: $formData,
		contentType: false, //禁止设置请求类型
		processData: false, //禁止jquery对Data数据的处理,默认会处理,禁止的原因是,FormData已经帮我们做了处理
		success : function(value) {
			console.log(value);
			if(value.status == "no") alert("提交失败");
			if(value.status == "yes"){
				alert("提交成功");
				location = location;
			}
		}
	});
}

function clickLaw(obj){
	$.ajax({
		type : "get",
		url : "finance/acting/invoiceNumber/" + $($($(obj).find("td")[0]).find("input")[0]).val(),
		async : true,
		dataType : "json",
		success : function(value) {
			if(value.length == 0){
				$("#identityNumber").val("");
				$("#invoiceNumber").val("");
				return;
			}
			$(value).each(function(len, val){
				$("#identityNumber").val(val.identityNumber);
				$("#invoiceNumber").val(val.invoiceNumber);
				$("#identityNumberSpan").html("");
				$("#invoiceNumberSpan").html("");
			});
		}
	});
	$("#lawName").val($($(obj).find("td")[1]).html());
	$("#lawNameId").val($($($(obj).find("td")[0]).find("input")[0]).val());
	$("#weituPerson").html("").html($($(obj).find("td")[2]).html());
	$("#cw_taitouPerson").val($($(obj).find("td")[2]).html());
	$("#cw_taitouPersonSpan").html("");
	$("#dailiMoney").html("").html($($(obj).find("td")[4]).html() + "元");
	$("#yidaoMoney").html("").html($($(obj).find("td")[5]).html() + "元");
	$("#yikaiInvoice").html("").html($($(obj).find("td")[6]).html() + "元");
	$("#bananLaw").html("").html($($(obj).find("td")[7]).html());
	$("#cause").html("").html($($($(obj).find("td")[0]).find("input")[0]).attr("cause"));
	$("#lawNameSpan").html("");
	$("#showModal").modal("hide");
}

var perVal = "";
function selNames(val){
	$("#properSpan").html("");
	if(perVal == val) return;
	perVal = val;
	if(val.split("'").length != 1) return;
	$("#auto_div").html("");
	$.ajax({
		type : "get",
		url : "finance/acting/names",
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
$("body").click(function(e) {
	if($(e.target).attr("id") != 'proper' && $(e.target).attr("id") != 'auto_div'){
		$("#auto_div").hide();
	}
});
