function Function(){
			getClassroomList();
		}
		//从地址栏得到从详情页传过来的id
		var url = window.location.href;
		var middleOne = url.split("?")[1];
		var record_id = middleOne.split("=")[1];
		//周梦凯修改
		document.getElementById("sure").setAttribute("name", record_id);
		
		var baseurl= "http://localhost:8080/brrowSystem/";
		//获取显示的时间
		/*var date = document.getElementById('date');
		var myTime = new Date();
		var week = myTime.getDay();
		week++;
		var num = 14 - week;
		var middleTime;
		var finalTime;
		var date = document.getElementById('date');
		var optionDate = '';
		for (var i = 0; i<= num; i++) {
			middleTime = new Date(myTime.getTime() + i*24*60*60*1000);
			finalTime = middleTime.getFullYear() + '-' + (middleTime.getMonth()+1) + '-' +middleTime.getDate();
			//console.log(i,finalTime);
			optionDate = optionDate + '<option value="">' + finalTime + '</option>';
		}
		optionDate = '<option value="" style="display: none;" disabled selected>选择日期</option>' + optionDate;
		date.innerHTML = optionDate;*/
		
		/*ajax部分*/
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
		
		//更新一条借用记录ajax
		function updateBorrowInfo(record){
			var classList = document.getElementById('classList');
			var class_id = classList.options[classList.selectedIndex].value;
			var user_time = document.getElementById('txtEndDate').value;
			var user = document.getElementById('user').value;
			var peroid = document.getElementById('peroid').options[document.getElementById('peroid').selectedIndex].value;
			var type = document.getElementById('type').options[document.getElementById('type').selectedIndex].text;
			var describe = document.getElementById('describe').value;
			var record_id = record.name;
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
						url:baseurl+"updateBorrowInfo",
						data:{
							record_id:record_id,
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