		/*获取到申请消息的id*/
		var url = window.location.href;
		var data;
		
		var middleOne = url.split("?")[1];
		var id = middleOne.split("=")[1];
		
		//document.getElementById("edit").setAttribute("href", "updateBorrowInfo.html?record_id="+record_id);
		
		var baseurl= "http://localhost:8080/brrowSystem/";
		/*详情页面Ajax*/
		$.ajax({
			url:baseurl+"getApplyDetail",
			data:{
				 id: id,
			}, 
			method:'post',
			dataType:"json",
			success:function(su){
				data = su;
				if(su.code === 0){
					var ulDetails = document.getElementById("ul");
					var ht='';
					 	ht += '<li style="margin-left: 10px;">'
					 		+ '<span class="firstLine">已用信息</span>'
					 		+ '<span class="firstLine">'
					 		+ '<svg class="icon" style="width: 1em; height: 1em;vertical-align: middle;fill: currentColor;overflow: hidden;" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="514"><path d="M312.888889 995.555556c-17.066667 0-28.444444-5.688889-39.822222-17.066667-22.755556-22.755556-17.066667-56.888889 5.688889-79.644445l364.088888-329.955555c11.377778-11.377778 17.066667-22.755556 17.066667-34.133333 0-11.377778-5.688889-22.755556-17.066667-34.133334L273.066667 187.733333c-22.755556-22.755556-28.444444-56.888889-5.688889-79.644444 22.755556-22.755556 56.888889-28.444444 79.644444-5.688889l364.088889 312.888889c34.133333 28.444444 56.888889 73.955556 56.888889 119.466667s-17.066667 85.333333-51.2 119.466666l-364.088889 329.955556c-11.377778 5.688889-28.444444 11.377778-39.822222 11.377778z" p-id="515"></path></svg>'
					 		+ '</span>'
					 		+ '<span class="firstLine" style="background-color: rgba(110, 178, 143, 1); height: 30px; width: 70px; margin-top: 14px; line-height: 26px;">'
					 		+ '<font color="#FFFFFF">详情</font>'
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li></li>'
					 		+ '<li style="background-color: rgba(230, 230, 230, 1);">'
					 		+ '<span class="firstSpan">教室名称：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.class_name
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li>'
					 		+ '<span class="firstSpan">使用时间：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.user_time
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li style="background-color: rgba(230, 230, 230, 1);">'
					 		+ '<span class="firstSpan">使用人：</span>'
					 		+ '<span class="lastSpan" style="margin-left: 220px;">'
					 		+ su.data.username
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li>'
					 		+ '<span class="firstSpan">使用节次：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.period
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li style="background-color: rgba(230, 230, 230, 1);">'
					 		+ '<span class="firstSpan">使用类型：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.type
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li>'
					 		+ '<span class="firstSpan">备注：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.my_describe
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li></li>';
					ulDetails.innerHTML = ht;
				}else{
					alert(su.msg);
				}
			},
			error:function(xhr,s,e){
				console.log(xhr,s,e);
			}
		})
		
	/*通过一条申请信息Ajax*/
	function passApplyRecord(){
		//console.log(data);
		$.ajax({
			url:baseurl+"passApplyRecord",
			data:{
				class_id: data.data.class_id,
				user_time: data.data.user_time,
				user: data.data.username,
				peroid: data.data.period,
				type: data.data.type,
				describe: data.data.my_describe,
			}, 
			method:'post',
			dataType:"json",
			success:function(suc){
				if(suc.code === 0){
					sendemail(data.data.email,0);
					window.location.href = "applyList.html";
				}else{
					alert(suc.msg);
				}
			},
			error:function(xhr,s,e){
				console.log(xhr,s,e);
			}
		})
	}
	
	/*不通过一条申请信息Ajax*/
	function deleteApplyRecord(){
		$.ajax({
			url:baseurl+"deleteApplyRecord",
			data:{
				id: id,
			}, 
			method:'GET',
			dataType:"json",
			success:function(succ){
				if(succ.code === 0){
					sendemail(data.data.email,1);
					window.location.href = "applyList.html";
				}else{
					alert(succ.msg);
				}
			},
			error:function(xhr,s,e){
				console.log(xhr,s,e);
			}
		})
	}
	/*发邮件ajax*/
	function sendemail(applyemail,flag){
		$.ajax({
			url:baseurl+"sendemail",
			data:{
				applyemail: applyemail,
				flag: flag,
			}, 
			method:'GET',
			dataType:"json",
			success:function(succ){
				if(succ.code === 0){
					alert("邮件已发送成功");
				}else{
					alert(succ.msg);
				}
			},
			error:function(xhr,s,e){
				console.log(xhr,s,e);
			}
		})
	}
