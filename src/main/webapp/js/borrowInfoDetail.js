function exit(){
			window.location.href="./index.html";
		}
		/*获取到record_id*/
		var url = window.location.href;
		
		var middleOne = url.split("?")[1];
		var record_id = middleOne.split("=")[1];
		//周梦凯修改的代码-
		document.getElementById("edit").setAttribute("href", "updateBorrowInfo.html?record_id="+record_id);
		
		var baseurl= "http://localhost:8080/brrowSystem/";
		/*详情页面Ajax*/
		$.ajax({
			url:baseurl+"getBorrowInfoDetail",
			data:{
				 record_id : record_id,
			}, 
			method:'post',
			dataType:"json",
			success:function(su){
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
					 		+ su.data.usetype
					 		+ '</span>'
					 		+ '</li>'
					 		+ '<li>'
					 		+ '<span class="firstSpan">备注：</span>'
					 		+ '<span class="lastSpan">'
					 		+ su.data.describe_info
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