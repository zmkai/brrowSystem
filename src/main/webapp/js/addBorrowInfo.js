		function exit(){
			window.location.href="rootMain.html";
		}
		/*写入两周之内的时间*/
		/*var date = document.getElementById('date');
		var myTime = new Date();     //获取当前系统时间
		var week = myTime.getDay();    //获取当前时间里的星期
		week++;
		var num = 14 - week;
		var middleTime;
		var finalTime;
		var date = document.getElementById('date');
		var optionDate = '';
		for (var i = 0; i<= num; i++) {
			middleTime = new Date(myTime.getTime() + i*24*60*60*1000);    //当前时间向上加一即到达下一天
			//new Date为重新转换成时间格式
			
			//将时间转换成’年-月-日‘的形式
			finalTime = middleTime.getFullYear() + '-' + (middleTime.getMonth()+1) + '-' +middleTime.getDate();
			//console.log(i,finalTime);
			
			//拼接字符串循环写入
			optionDate = optionDate + '<option value="">' + finalTime + '</option>';
		}
		optionDate = '<option value="" style="display: none;" disabled selected>选择日期</option>' + optionDate;
		date.innerHTML = optionDate;*/
		
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
								console.log(document.getElementById("classList"));
								 classList.innerHTML = ht;
								
								
							}else{
								alert(su.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
		//增加一条借用记录ajax
		function addBorrowInfo(){
			var classList = document.getElementById('classList');
			var class_id = classList.options[classList.selectedIndex].value;
			var user_time = document.getElementById('txtEndDate').value;
			var user = document.getElementById('user').value;
			var peroid = document.getElementById('peroid').options[document.getElementById('peroid').selectedIndex].value;
			var type = document.getElementById('type').options[document.getElementById('type').selectedIndex].text;
			var describe = document.getElementById('describe').value;
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
							}
						}
					}
				}
			}
			$.ajax({
						url:baseurl+"addBorrowInfo",
						data:{
							class_id: class_id,
							user_time: user_time,
							user: user,
							peroid: peroid,
							type: type,
							describe: describe,
						}, 
						method:'post',
						dataType:"json",
						success:function(suc){
							if(suc.code === 0){
								window.location.href="rootMain.html";
							}else{
								alert(suc.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
			}