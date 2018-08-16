		function exit(){
			window.location.href="./visitMain.html";
		}

/*ajax部分*/
		var baseurl= "http://localhost:8080/brrowSystem/";
		//获取教室列表ajax
		$.ajax({
			url: baseurl +"getClassroomList",
						data:{
							
						}, 
						method:'get',
						dataType:"json",
						success:function(su){
							if(su.code === 0){
								var classList=document.getElementById("classList");
								var ht='';
								 for(var i=0; i<su.data.length; i++){
								 	ht +='<option value="'
								 		+su.data[i].class_id
								 		+'">'
								 		+su.data[i].class_name
								 		+'</option>';
						 		localStorage.setItem('class_id',su.data[i].class_id);
								 }
								 ht = '<option value="" style="display: none;" disabled selected>选择教室</option>' + ht;
								 classList.innerHTML = ht;
							}else{
								alert(su.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
		//增加一条申请记录ajax
		function addApplyRecord(){
			var classList = document.getElementById('classList');
			var class_id = classList.options[classList.selectedIndex].value;
			var user_time = document.getElementById('txtEndDate').value;
			var user = document.getElementById('user').value;
			var email = document.getElementById('email').value;
			var peroid = document.getElementById('peroid').options[document.getElementById('peroid').selectedIndex].value;
			var type = document.getElementById('type').options[document.getElementById('type').selectedIndex].text;
			var describe = document.getElementById('describe').value;
			var account = localStorage.getItem('account');
			/*判空*/
			if(classList == null) {
				alert("使用教室不能为空");
			} else {
				if(user_time == null) {
					alert("使用时间不能为空");
				} else {
					if(user == null) {
						alert("使用人不能为空");
					} else {
						if(peroid == null) {
							alert("使用节次不能为空");
						}else{
							if(type == null) {
								alert("使用类型不能为空");
							}else{
								if(email == null){
									alert("联系邮箱不能为空");
								}
							}
						}
					}
				}
			}
			$.ajax({
						url:baseurl+"addApplyRecord",
						data:{
							class_id: class_id,
							user_time: user_time,
							username: user,
							period: peroid,
							type: type,
							describe: describe,
							email: email,
							account: account,
						}, 
						type:"POST",
						dataType:"json",
						success:function(suc){
							if(suc.code === 0){
								alert("申请提交成功，审核信息会发送至您的邮箱。");
								window.location.href="visitMain.html";
							}else{
								alert(suc.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
			}
