var perVal = "";
function selNames(val){
	$("#properSpan").html("");
	if(perVal == val) return;
	$("#properUp").val("");
	$("#properId").val("");
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