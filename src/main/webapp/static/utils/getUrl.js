function gotoUrlAttr(){
	var url = location.search;
	var map = new Map();
	var arrUrl = url.split("?")[1].split("&");
	arrUrl.forEach(function(val,len,arr){
		var arrAttr = val.split("=");
		map.set(arrAttr[0],arrAttr[1]);
	});
	return map;
}

function urlAttrToUtf8(e){
	return decodeURI(e);
}