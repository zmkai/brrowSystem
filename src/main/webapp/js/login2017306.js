function exit(){
			window.location.href="./index.html";
		}
var baseurl= "http://localhost:8080/brrowSystem/";
document.getElementById('login').onclick=function(){
     login();
	}
function login(){
	var username=document.getElementById('username').value;
	var password=document.getElementById('password').value;
	$.ajax({
		url:baseurl+"login",
		data:{
			username: username,
			password: password,
		},
		method:'post',
		dataType:"json",
		success:function(su){
			if(su.code === 0){
				localStorage.setItem('username',username);
				localStorage.setItem('password',password);
				window.location.href="rootMain.html";
			}else{
				alert(su.msg);
			}
		},
		error:function(xhr,s,e){
			//console.log(xhr,s,e);
		}
	})
}