$(function () {






    // 多选框全选
    var allMarkNum = 0;
    $('.all_mark').click(function () { 
        allMarkNum++; 
        if (allMarkNum % 2 == 0) {
            $(".table input[type=checkbox]").prop('checked', false);
        } else {
            $(".table input[type=checkbox]").prop('checked', true);
        }
    })




    // 监听页面滚动事件 - 保持表头在视口内
    if (document.getElementById('table')) {   // 判断页面是否存在表格元素

        $("#table").attr('data-table-fixed-head-trigger', $('#table_title').offset().top);
        (function ($) {
            $.fn.tfh = function () {

                var method = (arguments.length === 2) ? arguments[0] : ((arguments.length === 1 && typeof arguments[0] === 'string' ? arguments[0] : undefined));
                var options = $.extend({
                    trigger: 0,
                    top: 0
                }, (arguments.length === 2) ? arguments[1] : ((arguments.length === 1 && typeof arguments[0] === 'object' ? arguments[0] : {})));

                this.width = function () {
                    return this.find('thead').attr('data-tmp-width', parseInt(this.find('thead').css('width'))).find('*').each(function () {
                        $(this).attr('data-tmp-width', parseInt($(this).css('width')));
                    }).end().end();
                };

                this.fix = function () {
                    return this.find('.table-fixed-head-thead').css({
                        'top': options.top + 'px',
                        'position': 'fixed'
                    }).end();
                };

                this.clone = function () {
                    return this.find('thead').clone(true).prependTo(this).addClass('table-fixed-head-thead').end().end().removeAttr('data-tmp-width').find('*').removeAttr('data-tmp-width').end().end();
                };

                this.build = function () {
                    return this.tfh('width').tfh('clone').find('[data-tmp-width]').each(function () {
                        $(this).css({
                            'width': $(this).data('tmp-width') + 'px',
                            'minWidth': $(this).data('tmp-width') + 'px',
                            'maxWidth': $(this).data('tmp-width') + 'px',
                        });
                    }).removeAttr('data-tmp-width').end().tfh('fix', options);
                };

                this.kill = function () {
                    this.find('.table-fixed-head-thead').remove();
                };

                this.show = function () {
                    return this.addClass('fixed').find('thead').css('visibility', 'visible').not('.table-fixed-head-thead').css('visibility', 'hidden').end().end();
                };

                this.hide = function () {
                    return this.removeClass('fixed').find('thead').css('visibility', 'hidden').not('.table-fixed-head-thead').css('visibility', 'visible').end().end();
                };

                if (method !== undefined) {
                    return this[method].call($(this));
                } else {
                    var table = this.build.call($(this), options);
                    var tableWidth = table.css('width');
                    var tableScrollLeft = table.position().left;

                    if ($(document).scrollTop() > options.trigger) {
                        table.tfh('show');
                    } else {
                        table.tfh('hide');
                    }

                    var resizeTimer;
                    $(window).resize(function () {
                        window.clearInterval(resizeTimer);
                        resizeTimer = window.setInterval(function () {
                            window.clearInterval(resizeTimer);
                            if (tableWidth !== table.css('width')) {
                                tableWidth = table.css('width');
                                table.tfh('kill');
                                table.tfh(options);
                            }
                        }, 1000);
                    }).scroll(function () {
                        if ($(document).scrollTop() > options.trigger) {
                            table.tfh('show');
                            table.find('.table-fixed-head-thead').css('left', (tableScrollLeft - $(document).scrollLeft()) + 'px');
                        } else {
                            table.tfh('hide');
                        }
                    });
                }
            }
            $(document).ready(function () {
                $('table.table-fixed-head').each(function () {
                    $(this).tfh({
                        trigger: ($(this).data('table-fixed-head-trigger') !== undefined ? $(this).data('table-fixed-head-trigger') : 0),
                        top: ($(this).data('table-fixed-head-top') !== undefined ? $(this).data('table-fixed-head-top') : $(this).position().top)
                    });
                });
            });
        }(jQuery));
    }
    
    
    

    
    // 表头添加title
    var datasTh = $("#datas th");
    for (var i = 0; i < datasTh.length; i++) {
        datasTh[i].title = datasTh[i].innerText;
    }
    // 表格添加悬停提示信息框（黑色）
    $('#datas .table td').on('mouseover', function (event) {
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





    // 列表操作菜单
    $('tbody , .small_menu').on( 'contextmenu' , false );  // 阻止原右键事件
    $('tbody > tr').on('mouseup', function(e) {
        if (e.which == 3) {
            e.stopPropagation();
            displaySmallMenu(e, 'left', this);
        }
    });

    $(".case_set").click(function (e) {
        e.stopPropagation();
        displaySmallMenu(e, 'right', this);
    });

    function displaySmallMenu(e, position, it) {

        $("tbody > tr").removeClass("focus_tr_click focus_btn_click");

        switch (position) {
            // 时间源在td（右键点击）
            case 'left':
                var elemTr = $(it).parents("tr");
                var obj = $("#set_" + elemTr.context.id);
                $(obj).css({
                    'right': 'auto',
                    'left': e.clientX + "px",
                    'top': e.clientY + "px"
                })
                // 菜单超出视口右侧时位移至视口内
                var num2 = $(window).width() - (e.clientX + $(obj).outerWidth());
                if (num2 < 10) {
                    $(obj).css('left', e.clientX + num2 - 10 + "px")
                }
                $(it).addClass("focus_tr_click"); // 添加点击后样式
                break;

            // 时间源在操作btn（左键点击）
            case 'right':
                var obj = $("#set_" + $(it).attr("data-value"));
                $(obj).css({
                    'left': 'auto',
                    'right': $(window).width() - $(it).offset().left + $(window).scrollLeft() + "px",
                    'top': $(it).offset().top - $(window).scrollTop() + "px"
                })
                var elemTr = $(it).parents("tr");
                $(elemTr).addClass("focus_btn_click"); // 添加点击后样式
                break;
        }

        // 菜单超出视口底部时位移至视口内
        var num1 = $(window).height() - (e.clientY + $(obj).outerHeight());
        if (num1 < 10) {
            $(obj).css('top', e.clientY + num1 - 10 + "px")
        }

        if ($(obj).children("li").length == 0) {
            $(obj).html("<p style='color:#a9a9a9;margin:0 10px;'>没有操作项</p>")
        }
        // 显示菜单
        $('.small_menu').hide(100);
        $(document).unbind();
        $(obj).show(100);
        setTimeout(function () {
            $(document).one('click', function () {
                $('.small_menu').hide(100);
                $('tbody > tr').removeClass("focus_tr_click focus_btn_click");
            })
        }, 10)     
    }






    // 禁止用户拖拽图片和a标签
    $("img").attr("draggable", "false");
    $("a").attr("draggable", "false");


   




});








