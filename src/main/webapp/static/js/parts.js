$(function () {



    // 页面加载loading事件
    $('#loading').fadeOut(400);


    // body padding-bottom 自适应 (页面底部内宽)
    $("body").css('paddingBottom', $("footer").css("height"));
    // 监听footer高度动态auto
    var footerNum = $("footer").css("height")
    $(window).resize(function () {
        if ($("footer").css("height") != footerNum) {
            footerNum = $("footer").css("height");
            $("body").css('paddingBottom', $("footer").css("height"));
        }

    })






    // 页面置顶
    function toTop() {
        if (window.scrollY) {
            var toTop = setInterval(function () {
                var toHeight = scrollY / 7;
                if (scrollY > 0) {
                    scrollBy(0, (-toHeight - 1));

                } else {
                    clearInterval(toTop);

                }
            }, 10)
        } else {
            window.scroll(0, 0);
        }
    }




    // 提示信息
    if ( $('[data-toggle="tooltip"]').length != 0 ) {
        $('[data-toggle="tooltip"]').tooltip();
    }
    
    




    // 页面padding-top根据header的高度自适应
    $("body").css('paddingTop', $("header").css("height"));




    // tab栏目切换
    $("#content .tab2 a, #content .tab3 a").click(function () {
        $("#content .tab a, #content .tab2 a, #content .tab3 a").removeClass('tab_on');
            $(this).addClass('tab_on');
    })



    // input3 展开隐藏功能
    $(".input_display").click(function () {
        $(".input3_other").slideToggle(200);
        setTimeout(function () {
            if ($(".input3_other").css("display") == "block") {
                $(".input_display").text("收起");
            } else {
                $(".input_display").text("展开");
            }
        }, 240);

    });




    // 禁止用户拖拽图片和a标签
    $("img").attr("draggable", "false");
    $("a").attr("draggable", "false");





    // 二级菜单收缩快捷键
    $(window).on("keydown", function (e) {
        if (e.which == 9) {
            if (typeof(tabSwitchHomeNav2) != "undefined") {
                tabSwitchHomeNav2();
            } else if (typeof (parent.tabSwitchHomeNav2) != "undefined") {
                parent.tabSwitchHomeNav2();
            }
            return false;
        }
    })




    // 表头添加title
    var allTh = $("th").not("#datas th");
    for (var i = 0; i < allTh.length; i++) {
        allTh[i].title = allTh[i].innerText;
    }
    // 表格添加悬停提示信息框（黑色）
    $('.table td, .my_grid > .text_box > p').not("#datas td").on('mouseover', function (event) {
        var titleBox = document.createElement('div');
        var num = parseInt($(this).css('width'));
        var dds = $(this).html();
        var dd = dds.replace(/<\/?.+?>/g, "");
        var endValue = $.trim(dd.replace(/ /g, "")); //dds为得到后的内容
        var textNum = endValue.length;
        if (textNum > 10 && num > 70) {
            document.body.appendChild(titleBox);
            titleBox.className = 'td_title';
            $('.td_title:eq(0)').text(endValue);
            $('.td_title:eq(0)').css({
                'top': event.clientY,
                'left': event.clientX
            })
            this.title = '';
            $(this).on('mousemove', function (event) {
                $('.td_title:eq(0)').css({
                    'top': event.clientY,
                    'left': event.clientX
                });
            });
            $(this).on('mouseout', function () {
                this.title = titleBox.innerText;
                if (titleBox.remove) {
                    titleBox.remove()
                } else {
                    titleBox.removeNode(true);
                }
            });
        }
    });


    
    







});








