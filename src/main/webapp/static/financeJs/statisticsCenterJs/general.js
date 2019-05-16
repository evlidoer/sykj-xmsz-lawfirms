lay('.times').each(function(){
  laydate.render({
    elem: this
    ,trigger: 'click'
    ,type: 'month'
  });
}); 

$("#list1A").on("click", function(e){
	removeCll(e.target);
	list1Show();
	list2Hide();
	list3Hide();
	list4Hide();
	list5Hide();
});

$("#list2A").on("click", function(e){
	removeCll(e.target);
	list1Hide();
	list2Show();
	list3Hide();
	list4Hide();
	list5Hide(); 
});

$("#list3A").on("click", function(e){
	removeCll(e.target);
	list1Hide();
	list2Hide();
	list3Show();
	list4Hide();
	list5Hide();
});

$("#list4A").on("click", function(e){
	removeCll(e.target);
	list1Hide();
	list2Hide();
	list3Hide();
	list4Show();
	list5Hide();
});

$("#list5A").on("click", function(e){
	removeCll(e.target);
	list1Hide();
	list2Hide();
	list3Hide();
	list4Hide();
	list5Show();
});


function removeCll(obj){
	$(".nav li").each(function(len, val){
		$(val).removeClass("active");
	});
	if(obj.tagName == "A") obj = $(obj).parent();
	$(obj).addClass("active");
}