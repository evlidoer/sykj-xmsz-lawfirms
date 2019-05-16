	$(function(){
		$(document).on("mouseenter","#myul li",function(e){
			$(this).children("ol").show(100);
		})
		$(document).on("mouseleave","#myul li",function(e){
			$(this).children("ol").hide();
		})
		
		$(document).on("click","#myul li a",function(e){
			$("iframe").show();
			$("#daimg").hide();
		})
		$(document).on("click","#myul li ol li a",function(e){
			$("iframe").show();
			$("#daimg").hide();
		})
	})
									