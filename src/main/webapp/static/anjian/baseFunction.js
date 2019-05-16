// 获取可视窗口宽高
function getViewportOffset(){
	if(window.innerWidth){
		return {
			w : window.innerWidth,
			h : window.innerHeight				
		}
	}else{
		if(document.compatMode === "BackCompat"){
			return {
				w : document.body.clientWidth,
				h : document.body.clientHeight
			}
		}else{
			return {
				w : document.documentElement.clientWidth,
				h : document.documentElement.clientHeight
			}
		}
	}
}

// 获取滚动条X，Y轴
function getScrollOffset(){
	if(window.pageXOffset || window.pageXOffset == 0){
		return {
			x : window.pageXOffset,
			y : window.pageYOffset
		}
	}else{
		return {
			x : document.body.scrollTop + document.documentElement.scorllTop,
			y : document.body.scrollLeft + document.documentElement.scorllLeft
		}
	}
}

// 获取元素最终显示样式
function getStyle(elem, prop){
	if(window.getComputedStyle){
		return window.getComputedStyle(elem, null)[prop];
	}else{
		return elem.currentStyle[prop];
	}
}

// 元素绑定事件（this指向自身）
function addEvent(elem, type, handle){
	if(elem.addEventListener){
		elem.addEventListener(type, handle, false);
	}else if(elem.attachEvent){
		elem.attachEvent('on' + type, function(){
			handle.call(elem);
		})
	}else{
		elem['on' + type] = handle;
	}
}

// 取消元素绑定事件
function removeEvent(elem, type, handle){
	if(elem.removeEventListener){
		elem.removeEventListener(type, handle, false);
	}else if(elem.detachEvent){
		elem.detachEvent('on' + 'type', handle);
	}else{
		elem['on' + type] = null;
	}
}

// 取消冒泡事件
function stopBubble(event){
	if(event.stopPropagation){
		event.stopPropagation();
	}else{
		event.cancelBubble = true;
	}
}

// 取消右键菜单显示
function cancelHandler(event){
	if(event.preventDefault){
		event.preventDefault();
	}else{
		event.returnValue = false;
	}
}

//显示原图
//picUrl:图片相对路径
function ShowOriginalPictures(picUrl) { 
    if (picUrl != null && picUrl != "") {
        var imgStr = "<div style='width: 100%;height: 100%;text-align: center;line-height: 458px;'><img src='/FileView/ImagePath?Path=" + picUrl + "' style='max-width:100%;max-height:100%'/></div>";
        layer.open({
            type: 1,
            shade: false,
            title: false, //不显示标题    
            //area: ['auto', 'auto'],
            area: ['40%', '55%'],
            content: imgStr, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响    
            cancel: function () {
                //layer.msg('图片查看结束！', { time: 5000, icon: 6 });    
            }
        });
    } else {
        layer.msg("暂无图片", { time: 1000 });
    } 
}


function ShowImgListPictures(picUrl) {
    if (picUrl != null && picUrl != "") {
        var imgStr = "<div style='width: 100%;height: 100%;text-align: center;line-height: 458px;'><img src='/FileView/ImgListPath?Path=" + picUrl + "' style='max-width:100%;max-height:100%' /></div>";
        layer.open({
            type: 1,
            shade: false,
            title: false, //不显示标题    
            //area: ['auto', 'auto'],
            area: ['40%', '55%'],
            content: imgStr, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响    
            cancel: function () {
                //layer.msg('图片查看结束！', { time: 5000, icon: 6 });    
            }
        });
    } else {
        layer.msg("暂无图片", { time: 1000 });
    } 
}

function ShowImgFullPath(picUrl) {
    if (picUrl != null && picUrl != "") {
        var imgStr = "<div style='width: 100%;height: 100%;text-align: center;line-height: 458px;'><img src='" + picUrl + "' style='max-width:100%;max-height:100%' /></div>";
        layer.open({
            type: 1,
            shade: false,
            title: false, //不显示标题    
            //area: ['auto', 'auto'],
            area: ['40%', '55%'],
            content: imgStr, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响    
            cancel: function () {
                //layer.msg('图片查看结束！', { time: 5000, icon: 6 });    
            }
        });
    } else {
        layer.msg("暂无图片", { time: 1000 });
    }
}

//下载原文件
//obj:对象
//fileUrl:文件相对路径
//fileName:文件名称
function DownloadOriginalFile(obj,fileUrl,fileName) { 
    obj.href = "/FileView/DownFile?FilePath=" + fileUrl + "&DownName=" + fileName;
}