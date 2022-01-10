function check(theform){
    if(theform.username1.value==""){
        alert("用户名不能为空！")
        theform.username1.focus();
        return false;
    }
    if(theform.password2.value!=theform.password1.value){
        alert("两次密码不一致，请重新输入！")
        theform.password1.value=="";
        theform.password1.focus();
        return false;
    }
    var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    if(!reg.test(theform.email.value)){
        alert("请填写正确的邮箱格式！")
        theform.email.value=="";
        theform.email.focus();
        return false;
    }

}
function unameFocus(){
    var username=document.getElementById("usernameId");
    username.className="import_prompt";
    username.innerHTML="1、由字母、数字、下划线、点、减号组成<br/>2、只能以数字、字母开头或结尾，且长度为4-18";
}
function unameBlur(){
    var username=document.getElementById("username1");
    var usernameId=document.getElementById("usernameId");
    var reg=/^[0-9a-zA-Z][0-9a-zA-Z_.-]{2,16}[0-9a-zA-Z]$/;
    if(username.value==""){
        usernameId.className="error_prompt";
        usernameId.innerHTML="用户名不能为空，请输入用户名";
        return false;
    }
    if(reg.test(username.value)==false){
        usernameId.className="error_prompt";
        usernameId.innerHTM="1、由字母、数字、下划线、点、减号组成<br/>2、只能以数字、字母开头或结尾，且长度为4-18";
        return false;
    }

    usernameId.className="ok_prompt";
    usernameId.innerHTM="用户名输入正确";
    return true;

}
var cityList=new Array();
cityList['-选择省份-']=['-选择城市-']
cityList['北京市']=['东城区','西城区','朝阳区','丰台区','石景山区','海淀区','顺义区','通州区','大兴区','房山区','门头沟区','昌平区','平谷区','密云区','怀柔区','延庆区'];
function changeCity(){
    var province=document.form1.selProvince;
    var city=document.form1.selCity;
    city.options.length=0;
    for(var i in cityList){
        if(i==province.value){
            for(var j in cityList[i]){
                city.add(new Option(cityList[i][j],cityList[i][j],null))
            }
        }
    }
}
function allCity(){
    var province=document.form1.selProvince;
    for(var i in cityList){
        province.add(new Option(i,i),null);
    }
    changeCity();
}
window.onload=allCity;