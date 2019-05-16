$("#lsTable").bootstrapTable({
	url : "finance/income/lstj",
	method : 'get',
	dataType : "json",
	striped : true, // 是否显示行间隔色
	pageNumber : 1, // 初始化加载第一页
	pagination : true, // 是否分页
	sidePagination : 'server', // server:服务器端分页|client：前端分页
	pageSize : 10, // 单页记录数
	pageList : [5, 10, 15, 20 ], // 可选择单页记录数
	queryParams : function(params) { // 上传服务器的参数
		var temp = {
			limit : params.limit, // 每页显示数量
			offset : params.offset, // SQL语句起始索引
			id : $("#lsproperId").val()
		};
		return temp;
	},
	columns : [ {
		title : "收支人",
		field : "emp_name"
	}, {
		title : "开始日期",
		formatter : function(val, row, len) {
			var cwInoutDate = new Date(row.cw_begin_date);
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
		title : "截止日期",
		formatter : function(val, row, len) {
			var cwInoutDate = new Date(row.cw_end_date);
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
		title : "总收入",
		field : "cw_income_all"
	}, {
		title : "总支出",
		field : "cw_expend_all"
	}, {
		title : "实际应提",
		field : "cw_actual"
	}, {
		title : "操作",
		formatter: function(val, row, len){
			return '<div class="btn-group btn-group-xs" role="group">'
		      + '<button type="button" class="btn btn-default show" hisid="'+ row.hr_emp_id +'">查看详情</button>'
		      + '<button type="button" class="btn btn-default del" hisid="'+ row.id +'">删除</button>'
		      + '</div>';
		}
	} ],
	onLoadSuccess : function(data) {
		$(".del").on("click",function(e){
			var $hisid = $(e.target).attr("hisid");
			if($hisid == 0 || $hisid == undefined || $hisid == null){
				alert("删除失败,请重试");
				return;
			}
			$.ajax({
				type:"post",
				url:"statistics/prosonFinance/delHis",
				async:true,
				data : "_method=DELETE&id=" + $hisid,
				success : function(msg){
					if(msg.status == "yes") $('#lsTable').bootstrapTable('refresh');
					if(msg.status == "no") alert("删除失败,请重试");
				}
			});
		});
		$(".show").on("click",function(e){
			var $tr = $(e.target).parent().parent().parent();
			
			var $hisid = $(e.target).attr("hisid");
			var $name = $($tr.find("td")[0]).text();
			var $start = $($tr.find("td")[1]).text();
			var $end = $($tr.find("td")[2]).text();
			window.location.href = "finance/income/showIncome?id=" + $hisid 
				+ "&name=" + $name + "&start=" + $start + "&end=" + $end;
		});
	}
});