


function SelectAll(tempControl) {
    //将除头模板中的其它所有的CheckBox取反 

    var theBox = tempControl;
    xState = theBox.checked;

    elem = theBox.form.elements;
    for (i = 0; i < elem.length; i++)
        if (elem[i].type == "checkbox" && elem[i].id != theBox.id) {
            if (elem[i].checked != xState)
                elem[i].click();
        }
}


function STrim(str) {
    return str.replace(/^\s+/, '').replace(/\s+$/, '');
}
function $$(a) {
    return document.getElementById(a);
}
function GetDataStr(StrUrl) {
    var oHttpReq = null;
    if (window.XMLHttpRequest) {
        oHttpReq = new XMLHttpRequest();
    }
    else {
        oHttpReq = new ActiveXObject("MSXML2.XMLHTTP");
    }
    oHttpReq.open("POST", StrUrl, false);
    oHttpReq.send("");
    result = oHttpReq.responseText;
    return result;
}

function CheckUpFile(NextCol, Fid) {
    var IsTrue = false;
    var filev = Fid.value;
    filev = filev.substring(filev.lastIndexOf("."), filev.length);
    var filev = filev.toLowerCase();
    var NextList = NextCol.toLowerCase().split(',');
    for (var i = 0; i < NextList.length; i++) {
        if (NextList[i] == filev)
            IsTrue = true;
    }
    if (!IsTrue) {
        Fid.outerHTML = Fid.outerHTML;
        //alert("请上传正确的格式，仅限：" + NextCol);
        layer.msg("请上传正确的格式，仅限：" + NextCol, function () {
            //关闭后的操作
        });
        return false;
    }
}



function SetLenth() {
    $('div.divmatnrdesc').live('mouseover', function (e) {
        _text = $(this).text();
        _tooltip = "<div id='tooltipdiv'><font style='font-size:14px'> " + _text + "</font></div>";
        $("body").append(_tooltip);
        $("#tooltipdiv").show();
        $("#tooltipdiv")
        .css({
            "top": (e.pageY + 10) + "px",
            "left": (e.pageX + 10) + "px"
        }).show("fast");
    });

    $('div.divmatnrdesc').live('mouseout', function (e) {
        $("#tooltipdiv").remove();
    });


    $('div.divmatnrdesc').live('mousemove', function (e) {
        $("#tooltipdiv")
        .css({
            "top": (e.pageY + 10) + "px",
            "left": (e.pageX + 10) + "px"
        }).show();
    });
}

function SetLenth2() {
    var MaxCount = $("div.divmatnrdesc").length;
    for (var i = 0; i < MaxCount; i++) {
        var VPut = $("div.divmatnrdesc").eq(i);
        if (STrim(VPut.text()) == "") {
            _text = STrim(VPut.attr('des'));
            _length = parseInt(VPut.attr('length'));
            if (_length > _text.length)
                VPut.text(_text);
            else
                VPut.text(_text.substring(0, _length) + "…");
        }
    }

    $('div.divmatnrdesc').live('mouseover', function (e) {
        _text = STrim($(this).attr('des'));
        _length = $(this).attr('length');
        _Dtxt = STrim($(this).text());

        if (_text != "") {
            _tooltip = "<div id='tooltipdiv'><font style='font-size:14px'> " + _text + "</font></div>";
            $("body").append(_tooltip);
            $("#tooltipdiv").show();
            $("#tooltipdiv").css({
                "top": (e.pageY + 10) + "px",
                "left": (e.pageX + 10) + "px"
            }).show("fast");
        }
    });

    $('div.divmatnrdesc').live('mouseout', function (e) {
        $("#tooltipdiv").remove();
    });


    $('div.divmatnrdesc').live('mousemove', function (e) {
        $("#tooltipdiv")
        .css({
            "top": (e.pageY + 10) + "px",
            "left": (e.pageX + 10) + "px"
        }).show();
    });
}


function SetInputDouble(Vid, VLenth) {
    Vid.value = Vid.value.replace(/[^\d.]/g, '');
    if (Vid.value != "") {
        if (Vid.value.indexOf(".") == -1)
            Vid.value = (parseFloat(Vid.value).toFixed(0)).toString();
        else
            Vid.value = (parseFloat(Vid.value).toFixed(VLenth)).toString();
    }
}

//可以输入负数
function SetInputDoubleNegative(Vid, VLenth) {
    if (Vid.value != "") {
        //Vid.value = Vid.value.replace(/[^\-?\d.]/g, '');
        if (Vid.value.indexOf(".") == -1) {
            Vid.value = Vid.value.replace(/[^\-?\d.]/g, '');
            Vid.value = parseFloat(Vid.value).toFixed(0).toString();
        } else {
            Vid.value = Vid.value.replace(/[^\-?\d.]/g, ''); 
            Vid.value = parseFloat(Vid.value).toFixed(VLenth).toString();
        }
    }
}

function SetInputInt(Vid) {
    Vid.value = Vid.value.replace(/[^\d.]/g, '');
    if (Vid.value != "")
        Vid.value = (parseFloat(Vid.value).toFixed(0)).toString();
}



/*判断输入是否为合法的手机号码*/
function IsPhoneMobile(inputString) {
    var reg = new RegExp('^((((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8})|((0\\d{2,3}\\-?)?\\d{7,8}))$');
    if (reg.test(inputString)) {
        //alert('是手机或电话');
        return true;
    }
    else {
        return false;
        //alert('不是手机或电话');
    }
}


/*
两种格式：
一、title="手机号码";
二、title="手机号码|Mobile|0 or 1";  手机号码格式判断，【0  or 1】说明：0不能为空，1可为空，当填写内容后判断 
格式判断：PhoneMobile：电话或手机；  Phone：电话；   Mobile：手机； idcardno：身份证号；  Price:金额
*/
function PostIsNull() {

    var ValidaCode_Phone = /^((0\d{2,3}\-?)?\d{7,8})$/;
    var ValidaCode_Mobile = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var ValidaCode_idcardno = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
    var ValidaCode_Price = /^(-|)(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;

    var IsTrue = true;
    var FormList = $("input,select,textarea");
    for (var i = 0; i < FormList.length; i++) {
        var VInput = FormList.eq(i);
        var VInputValue = VInput.val();
        if (VInput.attr("title") != "") {
            var VTitleList = VInput.attr("title").split('|');
            var VTitle = VTitleList[0];
            var VCols = "";
            var IsNull = "0";
            if (VTitleList.length > 2) {
                IsNull = VTitleList[2];
                VCols = VTitleList[1];
            }
            if (IsNull == "0" && VInputValue == "") {
                if (VTitle.indexOf("请") == -1)
                    alert("请填写" + VTitle);
                else
                    alert(VTitle);
                IsTrue = false;
                break;
            }
            else {
                if (VInputValue != "") {
                    if (VCols == "PhoneMobile") {
                        if (IsPhoneMobile(VInputValue) == false) {
                            alert(VTitle + "格式不正确");
                            IsTrue = false;
                            break;
                        }
                    }
                    else if (VCols == "Phone") {
                        if (!ValidaCode_Phone.test(VInputValue)) {
                            alert(VTitle + "格式不正确");
                            IsTrue = false;
                            break;
                        }
                    }
                    else if (VCols == "Mobile") {
                        if (!(VInputValue.length == 11 && ValidaCode_Mobile.test(VInputValue))) {
                            alert(VTitle + "格式不正确");
                            IsTrue = false;
                            break;
                        }
                    }
                    else if (VCols == "idcardno") {
                        if (!ValidaCode_idcardno.test(VInputValue)) {
                            alert(VTitle + "格式不正确");
                            IsTrue = false;
                            break;
                        }
                    }
                    else if (VCols == "Price") {
                        if (!ValidaCode_Price.test(VInputValue)) {
                            alert(VTitle + "格式不正确");
                            IsTrue = false;
                            break;
                        }
                    }
                }
            }
        }
    }
    return IsTrue;
}


function ClickWebPost() {
    var a1 = PostIsNull();
    if (!a1) {
        return false;
    }
    if (a1)
        document.getElementById("Button2").click();
}

var rowCount = 1;  //行数默认4行  


//添加行  

function addRow_Lawyer() {
    if (rowCount <= 10) {
        rowCount++;
        var VHtml = '<li id="option_tempid"><div class="down_box2"><select id="TLawyerCols_tempid" name="TLawyerCols_tempid"></select></div> <input id="TLawyer_tempid" name="TLawyer_tempid"  type="text" class="form-control" style="display:inline;width:200px;margin-right:8px;" onkeyup="MousePiPei(this,3);" onfocus="MousePiPei(this,3);" title=\"第_tempid行律师姓名\"   placeholder=\"律师姓名\" /> 业绩分成：<input id="TLawyerPrice_tempid"  name="TLawyerPrice_tempid" type="text" class="form-control" style="display:inline;width:200px;"  onblur="SetInputDouble(this,2);"  placeholder=\"业绩分成\" title=\"第_tempid行业绩分成\"/> <div class="down_box2"><select id="TPriceCols_tempid"  name="TPriceCols_tempid"  ><option value="1" >百分比</option><option value="2">固定金额</option></select></div> <a class="delete" onclick=delRow_Lawyer(_tempid)>删除</a></li>';
        VHtml = VHtml.replace(/_tempid/g, rowCount);

        $('#optionContainer').append(VHtml);

        $.ajax({
            type: "POST",
            url: "/Case/LawyerCols",
            data: {},
            async: false,
            success: function (result) {
                for (var i = 0; i < result.length; i++) {
                    $("#TLawyerCols" + rowCount).append("<option value='" + result[i]["ID"] + "'>" + result[i]["Title"] + "</option>");
                }
            }
        });
    } else {
        layer.msg("办案律师最多10个", function () {
            //关闭后的操作
        });
    }

}

//删除行  
function delRow_Lawyer(rowIndex) {
    $("#option" + rowCount).remove();
    //$("#option" + rowIndex).remove();
    rowCount--;
}