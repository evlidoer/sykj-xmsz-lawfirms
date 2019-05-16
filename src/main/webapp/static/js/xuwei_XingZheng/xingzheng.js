$(document).on("click","#XZ_father_Li a",function(){
	alert($(this).next().attr("name"))
	//$(this).attr("href",$(this).prev().attr("href"));
});