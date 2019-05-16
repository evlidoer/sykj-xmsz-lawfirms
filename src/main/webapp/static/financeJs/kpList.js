$("#showTable")
		.bootstrapTable(
				{
					url : "finance/kpList/invoice",
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
							kpStatus : $("#kpStatus").val(),
							fpType : $("#fpType").val(),
							kaipiaoProject : $("#kaipiaoProject").val(),
							cType : $("#cType").val(),
							startTime : $("#startTime").val(),
							endTime : $("#endTime").val()
						};
						return temp;
					},
					columns : [
							{
								title : "案号",
								formatter : function(val, row, len) {
									if(row.case_propernum == undefined){
										return "-";
									}else{
										// 跳转至案件详细页面
										return "<a href='javascpit:"+ row.caseId +";'  class='a_black' title='"
												+ row.case_propernum
												+ "'>"
												+ row.case_propernum + "</a>";
									}
								}
							},
							{
								title : "申请人",
								field : "shengqing"
							},
							{
								title : "办案律师",
								field : "banan"
							},{
								title : "发票抬头",
								field : "cw_invoice_title"
							},
							{
								title : "代理费(元)",
								field : "case_agencyfee"
							},
							{
								title : "发票金额",
								field : "cw_invoice_money"
							},{
								title : "已开票金额(元)",
								field : "sumInvoice"
							},{
								title : "已付款(元)",
								field : "sumInout"
							}, {
								title : "开票日期",
								formatter : function(val, row, len) {
									var cwInoutDate = new Date(row.cw_invoice_date);
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
								title : "开票状态",
								formatter : function(val, row, len) {
									return row.cw_invoice_status == "Y" ? "已开" : "未开";
								}
							}, {
								title : "操作",
								formatter: function(val, row, len){
									return '<div class="btn-group btn-group-xs" role="group">'
								      + '<button type="button" class="btn btn-default show" cwid="'+ row.id +'">查看</button>'
								      + '<button type="button" class="btn btn-default del" cwid="'+ row.id +'">删除</button>'
								      + '</div>';
								}
							}],
							onLoadSuccess : function(data) {
								var moneyNum = 0;
								data.rows.forEach(function(val, len, arr) {
									moneyNum+=val.cw_invoice_money;
								});
								var $index = $("#showTable tr").last().attr(
										"data-index");
								var $tr = $("<tr data-index='" + (parseInt($index) + 1)
										+ "'></tr>");
								var $td = "<td style></td>";
								$tr.append("<td style>合计</td>");
								$tr.append($td + $td + $td + $td);
								$tr.append("<td style>" + moneyNum + "元</td>");
								$tr.append($td + $td + $td + $td + $td);
								$("#showTable tbody").append($tr);
								
								$(".del").on("click",function(event){
									console.log();
									$.ajax({
										type : "post",
										url : "finance/kpList/invoice/" + $(event.target).attr("cwid"),
										async : true,
										dataType : "json",
										data: "_method=DELETE",//发送DELETE请求
										success : function(val) {
											if(val.status == 'no') alert("删除失败");
											if(val.status == 'yes') $("#showTable").bootstrapTable("refresh");
										}
									});
								});
							}
				});
lay('.Time').each(function() {
	laydate.render({
		elem : this,
		trigger : 'click'
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

