

// 顶部跳转页面(无左侧菜单)
function toContentPage3(url, it, id) {
    //allVar.iframeBox.src = prefix + url;
    window.location.href = '/Home/Content?fid=' + id + "&type=1";


    var allButton = allVar.homeNav2.getElementsByTagName('button');
    for (var i = 0; i < allButton.length; i++) {
        allButton[i].className = 'btn';
    }
    if (it) {
        if (it.className == 'btn') {
            it.className = 'btn home_btn_on';
        }
    }
}

// 顶部跳转页面
function toContentPage(url, it, id) {
    document.getElementById("iframeContent").src = '/Home/Content?fid=' + id + "&url=" + url;
    $(".navbar-default .navbar-nav > li > a").removeClass("nav_on");
    $(it).addClass("nav_on");
}
// 顶部跳转网站
function toContentWebPage(url, it) {
    document.getElementById("iframeContent").src = url;
    $(".navbar-default .navbar-nav > li > a").removeClass("nav_on");
    $(it).addClass("nav_on");
}
// 顶部栏目选中状态初始化
$(".navbar-default .navbar-nav > li > a:eq(0)").addClass("nav_on");


// 禁止用户拖拽图片和a标签
$("img").attr("draggable", "false");
$("a").attr("draggable", "false");


// 二级菜单收缩快捷键
$(window).on("keydown", function (e) {
    if (e.which == 9) {
        if (typeof (tabSwitchHomeNav2) != "undefined") {
            tabSwitchHomeNav2();
        } else if (typeof (parent.tabSwitchHomeNav2) != "undefined") {
            parent.tabSwitchHomeNav2();
        } else {
            try {
                $("#iframeContent")[0].contentWindow.tabSwitchHomeNav2();
            } catch (error) {
                alert("手速太快了，页面还没有反应过来！");
            }
        };
        return false;
    }
})




// 全局变量声明
var prefix = ''; //所有跳转链接的前缀
var allVar = {
    logo: document.getElementById('main_logo'),
    iframeBox: document.getElementById('iframeBox'),
    homeNav2: document.getElementById('home_nav2'),
    homeNav2Elem: (document.getElementById('home_nav2') == null) ? null : (document.getElementById('home_nav2').getElementsByTagName('ul')[0].getElementsByTagName('li')),
    homeNav2Switch: document.getElementById('home_nav2_switch'),
    homeNav2SwitchP: (document.getElementById('home_nav2_switch') == null) ? null : (document.getElementById('home_nav2_switch').getElementsByTagName('p')[0])
}
var homeBtnFlex = {
    btn: document.getElementById('home_btn_flex'),
    body: document.getElementById('home_nav'),
    span: (document.getElementById('home_nav') == null) ? null : (document.getElementById('home_nav').getElementsByTagName('span')),
    li: (document.getElementById('home_nav') == null) ? null : (document.getElementById('home_nav').getElementsByTagName('li')),
    secondli: (document.getElementById('home_nav2') == null) ? null : (document.getElementById('home_nav2').getElementsByTagName('li')),
    svg: (document.getElementById('home_btn_flex') == null) ? null : (document.getElementById('home_btn_flex').getElementsByTagName('svg')),
    key: true
}




// 左侧跳转页面
function toThisPage2(url, it) {
    $("#iframeContent").src = prefix + url;

}
// 左侧跳转页面 - 只有一级菜单
function toThisPage3(url, it) {
    document.getElementById('iframeBox').src = prefix + url;

    $(".btn1_hover").removeClass("home_btn_on");

    $(it).addClass("home_btn_on");

}


// 一级导航宽度伸缩
if (homeBtnFlex.btn != null) {
    homeBtnFlex.btn.onclick = function () {
        var get = homeBtnFlex;
        if (!get.key) {
            get.body.style.width = '134px';
            for (var i = 0; i < get.span.length; i++) {
                get.span[i].style.display = 'block';
            }
            $('.home_menu li').tooltip('destroy');  // 隐藏提示文字
            get.svg[0].style.display = 'none';
            get.svg[1].style.display = 'inline';
            get.key = true;
        }
        else {
            get.body.style.width = '60px';
            for (var i = 0; i < get.span.length; i++) {
                get.span[i].style.display = 'none';
            }
            $('.home_menu li').tooltip();  // 显示提示文字
            get.svg[0].style.display = 'inline';
            get.svg[1].style.display = 'none';
            get.key = false;
        }
    }
}

// 开启提示信息
$(function () {
    //$('[data-toggle="tooltip"]').tooltip();  // 开启所有提示信息
    //$('.home_menu li').tooltip();  // 一级导航提示信息
    $('.home_nav2_switch').tooltip();  // 二级菜单收缩按钮提示
});
(function () {
    var get = homeBtnFlex;
    if (get.li != null) {
        for (var i = 0; i < get.li.length; i++) {
            get.li[i].title = get.span[i].innerText;
        }
    }
}())





// 左侧跳转页面 (无一级菜单时)
function toThisPage2(url, it) {
    document.getElementById("iframeBox").src = url;
    var allButton = allVar.homeNav2.getElementsByTagName('button');
    for (var i = 0; i < allButton.length; i++) {
        allButton[i].className = 'btn';
    }
    if (it) {
        if (it.className == 'btn') {
            it.className = 'btn home_btn_on';
        }
    }
}


// 左侧跳转页面
function toThisPage(url, it) {
    allVar.iframeBox.src = prefix + url;
    var allButton = allVar.homeNav2.getElementsByTagName('button');
    for (var i = 0; i < allButton.length; i++) {
        allButton[i].className = 'btn';
    }
    if (it) {
        if (it.className == 'btn') {
            it.className = 'btn home_btn_on';
        }
    }
}

// 切换菜单
function toThisMenu(it, url) {
    var get = homeBtnFlex;
    var num = $(it).index();
    $(it).addClass('home_btn_on');
    $(it).siblings().removeClass('home_btn_on');

    if (num == 0) {  // 如果为0，则表示当前按钮是首页按钮
        allVar.iframeBox.src = prefix + url;
        allVar.homeNav2.style.width = '0px';
        allVar.homeNav2Switch.style.display = 'none';
        var allButton = allVar.homeNav2.getElementsByTagName('button');
        for (var i = 0; i < allButton.length; i++) {  // 遍历去除二级菜单下所有button的选中状态
            allButton[i].className = 'btn';
        }
    } else {
        allVar.homeNav2.style.width = '180px';
        allVar.homeNav2Switch.style.display = 'block';
        allVar.homeNav2Switch.getElementsByTagName('img')[0].className = 'home_nav2_close';
        $(get.secondli).eq(num - 1).siblings().removeClass("now");
        $(get.secondli).eq(num - 1).addClass("now");
    }
}


// homeNav2高度auto
if (allVar.homeNav2Elem != null) {
    for (var i = 0; i < allVar.homeNav2Elem.length; i++) {
        allVar.homeNav2Elem[i].style.height = getViewportOffset().h - 80 + 'px';
    }
}

// 二级导航显示隐藏
if (allVar.homeNav2Switch != null) {
    allVar.homeNav2Switch.onclick = function () {
        var get = allVar.homeNav2.style;
        var getImg = allVar.homeNav2Switch.getElementsByTagName('img')[0];
        if (get.width != '0px') {
            get.width = '0px';
            getImg.className = 'home_nav2_open';
        } else {
            get.width = '180px';
            getImg.className = 'home_nav2_close';
        }
    }
}


// 修改界面颜色
var newView2 = {
    view: document.getElementById('ui_color'),
    close: document.getElementById('ui_color').getElementsByTagName('a')[0],
    li: document.getElementById('ui_color').getElementsByTagName('li')
}
var mainView = document.getElementById('view');
function changeColor() {
    mainView.className = 'view_filter';
    newView2.view.style.display = 'block';
    var num = 0;
    newView2.view.style.opacity = num;
    var slow = setInterval(function () {
        if (num != 1) {
            num += 0.2;
            newView2.view.style.opacity = num;
        } else {
            clearInterval(slow);
        }
    }, 20)
}
function newView2Close() {
    mainView.className = 'view';
    newView2.view.style.display = 'none';

}
addEvent(newView2.close, 'click', newView2Close);
addEvent(newView2.view, 'click', newView2Close);



function mainColor(color, it) {
    if (color) {
        $.ajax({
            url: '/Home/AjaxUpdateSkinColor',
            method: 'get',
            data: { Color: color },
            type: 'json',
            success: function (response) {
                response = JSON.parse(response);
                if (response.Result) {
                    var url = "/Content/css/main_" + color + ".css";
                    var get = newView2.li;
                    for (var i = 0; i < get.length; i++) {
                        get[i].classname = 'btn';
                    }
                    it.classname = 'btn new_view2_on';
                    location.reload();
                    newView2Close();
                } else {
                    layer.msg("更换皮肤失败,请联系行政！", {
                        time: 1500
                    }, function () {

                    });
                }
            }
        })
    } else {
        layer.msg("皮肤颜色未设置或设置出错！", {
            time: 1500
        }, function () {

        });
    }
}


// 兼容火狐浏览器下一级导航滚动
if (navigator.userAgent.indexOf('Firefox') >= 0) {

    var homeNav = $("#home_nav");
    homeNav.css('overflow-y', 'visible');
    homeNav.css('margin-top', '0');

    homeNav.on('DOMMouseScroll', function (e) {

        var t = -e.originalEvent.detail * 50;

        homeNav.css('margin-top', parseInt(homeNav.css('margin-top')) + t + 'px');

        if (parseInt(homeNav.css('margin-top')) > 0) {
            homeNav.css('margin-top', '0')
        }


        if (parseInt(homeNav.css('margin-top')) < (-parseInt($(".home_menu").css('height')) + $(window).height() - 100)) {
            console.log()
            homeNav.css('margin-top', (-parseInt($(".home_menu").css('height')) + $(window).height() - 100))
        }

    })
}





// 非模态消息提示框
var cueFn = {
    tip: null,
    add: function (title, info, link) {  // 添加消息
        var txt =
        "<li class='notmode-cue'>" +
            "<div class='top'>" +
		        "<h4 class='title'>" + title + "</h4>" +
	        "</div><hr>" +
            "<p class='info'>" + info + "</p>" +
            "<a href='" + link + "' class='btn btn_solid'>详情</a>" +
            "<button class='btn iknow' onclick='cueFn.iKnow(this)'>我已知晓</button>" +
        "</li>";
        $(".notmode-cue-shell > .list").prepend(txt);
        cueFn.switchFn();
        var now = $(".notmode-cue-shell > .list > .notmode-cue:eq(0)");
        setTimeout(function () {
            $(now).addClass("now");
        }, 20);
        
        setTimeout(function () {
            $(now).removeClass("now");
        }, 8000);
        $(".notmode-cue-shell > .bgm-newmsg")[0].play();
        
        if (cueFn.tip == null) {
            cueFn.tip = setInterval(function () { // title闪烁提示
                $("title:eq(0)").text("您有新消息!");
                setTimeout(function () {
                    $("title:eq(0)").text("E律师");
                }, 1000);
            }, 2000)
            $(window).one("mousemove", function () {
                clearInterval(cueFn.tip);
                cueFn.tip = null;
            });
        }
    },
    pack: function () { // 收起/展开菜单
        if ($(".notmode-cue-shell").hasClass("pack")) {
            cueFn.open();
        } else {
            cueFn.close();
        }
    },
    open: function(){ // 展开菜单
        $(".notmode-cue-shell").removeClass("pack");
        $(".notmode-cue-shell > .fn > .switch").text("收起");
    },
    close: function () { // 关闭菜单
        $(".notmode-cue-shell").addClass("pack");
        $(".notmode-cue-shell > .fn > .switch").text("展开");
    },
    iKnow: function (it) {
        // 对接后台

        $(it).parents(".notmode-cue").slideUp(150);
        cueFn.switchFn()
    },
    allRead: function () {
        // 对接后台

        $(".notmode-cue").slideUp(150);
        cueFn.switchFn()
    },
    switchFn: function () {
        setTimeout(function () {
            if ($(".notmode-cue").not(':hidden').length < 1) {
                $(".notmode-cue-shell > .fn").removeClass("show");
                cueFn.close();
            } else {
                $(".notmode-cue-shell > .fn").addClass("show");
            }
        }, 240);
    },
    ScrollPush: function (id, title, url, make) { //下拉加载
        var txt =
        "<li class='notmode-cue'>" +
            "<div class='top'>" +
		        "<h4 class='title'>" + title + "</h4>" +
	        "</div><hr>" +
            "<p class='info'>" + make + "</p>" +
            "<a  onclick='DetailShow(this," + id + ",\""+url+"\");' class='btn btn_solid'>详情</a>" +
            "<button class='btn iknow' onclick='NeverNoticeRead(this," + id + ")'>我已知晓</button>" +
        "</li>";
        $(".notmode-cue-shell .nomore").before(txt);
        cueFn.switchFn();
    }
}




$(function () {
    
    //新功能模块+角标
    $(".navbar-default .navbar-nav > li > a").each(function () {
        var arr = ['推荐有礼'];
        if (arr.indexOf($(this).text()) > -1) {
            $(this).addClass("newfn");
        }
    })

    //新功能模块+角标
    $(".navbar-nav .dropdown > p").each(function () {
        var arr = ['推荐有礼'];
        if (arr.indexOf($(this).text()) > -1) {
            $(this).addClass("newfn2");
        }
    })
    //新功能知识库+角标
    //$(".navbar-default .navbar-nav > li > a").each(function () {
    //    if ($(this).text() == "知识库") {
    //        $(this).addClass("newfn");
    //    }

    //})
    //if ($(this).text() == "协作") {
    //    $(this).addClass("newfn");
    //}

})










   












