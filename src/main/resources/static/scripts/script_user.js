//사용자 페이지 공용 스크립트
var username="{{username}}";
if(username!=""){
    nav_status=document.getElementById("nav-loginstatus")
    nav_status.textContent=username;
    nav_status.href="/mypage"
}