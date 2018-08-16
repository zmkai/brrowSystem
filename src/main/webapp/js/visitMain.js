/*ajax部分*/
		var baseurl= "http://localhost:8080/brrowSystem/";
		var account = localStorage.getItem('account');
		//获取借用信息记录ajax
			$.ajax({
						url:baseurl+"getyoukeList",
						data:{
							account: account,
						}, 
						method:'POST',
						dataType:"json",
						success:function(su){
							var ht = '';
							if(su.code === 0){
								var getyoukeList = document.getElementById('getyoukeList');
								console.log(su);
								for(var i = 0; i<su.data.length; i++){
									ht = ht+'<li>'
										+'<span style="width: 200px; float: left;">'
										+su.data[i].class_name
										+'</span>'
										+'<span style="float: left; margin-left: 60px;">'
										+su.data[i].user_time
										+'</span>'
										+'<span style="float: left; margin-left: 100px;">'
										+su.data[i].username
										+'</span>'
										+'<span style="float: left; margin-left: 100px;">'
										+su.data[i].period
										+'</span>'
										+'<span style="float: left; margin-left: 100px;">'
										+su.data[i].type
										+'</span>'
										+'</li>';
								}
								getyoukeList.innerHTML = ht;
							}else{
								alert(su.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})