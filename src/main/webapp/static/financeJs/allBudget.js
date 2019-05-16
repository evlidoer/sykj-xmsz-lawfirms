$("#showTable")
		.bootstrapTable(
				{
					url : "finance/allBudget/allBudget",
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
							// page : (params.offset / params.limit) + 1, //当前页码
							// 查询参数
							caseId : $("#caseId").val(),
							caseIdNum : $("#caseIdNum").val(),
							inType : $("#inType").val(),
							payment : $("#payment").val(),
							cType : $("#cType").val(),
							startTime : $("#startTime").val(),
							endTime : $("#endTime").val()
						};
						return temp;
					},
					columns : [
							{
								title : "收支类别",
								field : "cwInoutTypeName"
							},
							{
								title : "日期",
								formatter : function(val, row, len) {
									var cwInoutDate = new Date(row.cw_inout_date);
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
							},
							{
								title : "收入(元)",
								formatter : function(val, row, len) {
									if(row.put == null) return 0;
									return Math.abs(parseFloat(row.put));
								}
							},{
								title : "支出(元)",
								formatter : function(val, row, len) {
									if(row.get == null) return 0;
									return Math.abs(parseFloat(row.get));
								}
							},
							{
								title : "支付方式",
								field : "cw_pay_type"
							},
							{
								title : "案号",
								formatter : function(val, row, len) {
									if(row.caseUmber == undefined){
										return "-";
									}else{
										// 跳转至案件详细页面
										return "<a href='javascpit:"+ row.case_law_id +";'  class='a_black' title='"
												+ row.caseUmber
												+ "'>"
												+ row.caseUmber + "</a>";
									}
								}
							},{
								title : "收支人",
								field : "emp_name"
							},{
								title : "付款人",
								field : "cw_payer"
							}, {
								title : "备注",
								field : "cw_remark"
							}, {
								title : "操作",
								formatter: function(val, row, len){
									return '<div class="btn-group btn-group-xs" role="group">'
								      + '<button type="button" class="btn btn-default del" cwid="'+ row.cwId +'">删除</button></div>';
									//起个class, 把这一行的id自定义个属性放进去
								}
							}],
					onLoadSuccess : function(data) {
						$(".del").on("click",function(event){//绑定点击事件到刚刚起名的class
							var $obj = $(event.target);//获取你现在点的是哪个按钮
							if($obj.attr("cwid") == null || $obj.attr("cwid") == '' || $obj.attr("cwid") == undefined){
								alert("删除失败");
							}
							$.ajax({
								type : "post",
								url : "finance/allBudget/inout/" + $obj.attr("cwid"),
								async : true,
								dataType : "json",
								data: "_method=DELETE",//发送DELETE请求
								success : function(val) {
									if(val.status == 'no') alert("删除失败");
									if(val.status == 'yes') $("#showTable").bootstrapTable("refresh");
								}
							});
						});
						var moneyNum = 0;
						var moneyNum2 = 0;
						data.rows.forEach(function(val, len, arr) {
							if(val.put != null) moneyNum += val.put;
							if(val.get != null) moneyNum2 += val.get;
						});
						var $index = $("#showTable tr").last().attr(
								"data-index");
						var $tr = $("<tr data-index='" + (parseInt($index) + 1)
								+ "'></tr>");
						var $td = "<td style></td>";
						$tr.append("<td style>合计</td>");
						$tr.append($td);
						$tr.append("<td style>" + moneyNum + "元</td>");
						$tr.append("<td style>" + Math.abs(moneyNum2) + "元</td>");
						$tr.append($td + $td + $td + $td + $td);
						$("#showTable tbody").append($tr);
					}
				});
lay('.Time').each(function() {
	laydate.render({
		elem : this,
		trigger : 'click'
	});
});

function iTypeEach(lower, id, arr) {
	arr.forEach(function(val, len, array) {
		if (id == val.cwPid) {
			var ssid = val.id;
			$("#inType").append(
					'<option value="' + val.id + '">' + lower
							+ "&nbsp;-&nbsp;&nbsp;-&nbsp;" + val.cwName
							+ '</option>');
			delete arr[len];
			iTypeEach(lower + '&nbsp;-&nbsp;&nbsp;-&nbsp;', ssid, arr);
		}
	});
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
$(function() {
	$.ajax({
		type : "get",
		url : "finance/budget/Itype",
		async : true,
		dataType : "json",
		success : function(data) {
			data.forEach(function(val, len, arr) {
				var sid = val.id;
				$("#inType").append(
						'<option value="' + val.id + '">' + val.cwName
								+ '</option>');
				delete arr[len];
				iTypeEach('&nbsp;&nbsp', sid, arr);
			});
			getCtype();
		}
	});
});
