// JavaScript Document

var _InputID_ = "";
function _ShowCityList_(ID) {
    try {
        _InputID_ = ID;

        var ListObj = document.getElementById("_CityList_");

        var TextTop = 0;
        var TextLeft = 0;
        var TextID = document.getElementById(ID);
        var TextHeight = TextID.clientHeight;
        while (TextID && TextID.tagName != "body") {
            TextTop = TextTop + TextID.offsetTop;
            TextLeft = TextLeft + TextID.offsetLeft;
            TextID = TextID.offsetParent;
        }
        ListObj.style.top = TextTop + TextHeight + 3 + "px";
        ListObj.style.left = TextLeft + "px";
        ListObj.style.display = "inline";
    }
    catch (Err) {
        //alert(Err.description);
    }
}

function _HideList_() {
    document.getElementById("_CityList_").style.display = "none";
    _InputID_ = "";
}
function _DelayHide_() {
    _CloseAdmit_ = true;
    setTimeout("_HideList_()", 200);
}


function MouseBiaoDe(VBiaoDe) {
    var VTxtId = VBiaoDe.id;
    var VTxtValue = VBiaoDe.value;

    if (VTxtValue != "") {
        $.ajax({
            type: "POST",
            url: "/AutoComplate/BiaoDe",
            data: { "BiaoDe": encodeURI(VTxtValue) },
            success: function (result) { 
                if (result.R.length > 0) {
                    $("#_CityList_").show();
                    $$("Div_Txt").innerHTML = result.R;
                    _ShowCityList_(VTxtId);
                }
            }
        });
    }
}
function ClickValue(STitle) {
    $$(_InputID_).value = STitle;
    _HideList_();
}