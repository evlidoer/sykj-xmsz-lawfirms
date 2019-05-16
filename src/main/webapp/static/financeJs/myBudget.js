function Select(id){
	window.location.href="gotolawdetailToUrl?id=" + id;
}
$("#showTable")
		.bootstrapTable(
				{
					url : "finance/budget/getData",
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
								title : "发生日期",
								formatter : function(val, row, len) {
									var cwInoutDate = new Date(row.cwInoutDate);
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
								title : "收支金额(元)",
								formatter : function(val, row, len) {
									var money = row.cwInoutMoney;
									var moneyAbs = Math.abs(money);
									return money == moneyAbs ? ("+&nbsp;" + moneyAbs
											.toFixed(2))
											: ("-&nbsp;&nbsp;" + moneyAbs
													.toFixed(2));
								}
							},
							{
								title : "支付方式",
								field : "cwPayType"
							},
							{
								title : "案号",
								formatter : function(val, row, len) {
									if(JSON.stringify(row.caseUmber) == 'null'){
										return "-";
									}else{
										// 跳转至案件详细页面
										return "<a href='javascript:Select("+ row.caseLawId +");'  class='a_black' title='"
												+ row.caseUmber
												+ "'>"
												+ row.caseUmber + "</a>";
									}
								}
							},
							{
								title : "录入日期",
								formatter : function(val, row, len) {
									var cwEnteringdate = new Date(
											row.cwEnteringdate);
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
							}, {
								title : "备注",
								field : "cwRemark"
							} ],
					onLoadSuccess : function(data) {
						var moneyNum = 0;
						data.rows.forEach(function(val, len, arr) {
							moneyNum += val.cwInoutMoney;
						});
						var $index = $("#showTable tr").last().attr(
								"data-index");
						var $tr = $("<tr data-index='" + (parseInt($index) + 1)
								+ "'></tr>");
						var $td = "<td style></td>";
						$tr.append("<td style>合计</td>");
						$tr.append($td);
						$tr.append("<td style>" + moneyNum + "元</td>");
						$tr.append($td + $td + $td + $td);
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