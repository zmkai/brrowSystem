/*ajax部分*/
		var baseurl= "http://localhost:8080/brrowSystem/";
		//获取申请信息记录ajax
			$.ajax({
						url:baseurl+"getAllyoukeList",
						data:{
							
						}, 
						type:'POST',
						dataType:"json",
						success:function(su){
							var ht = '';
							if(su.code === 0){
								var getAllyoukeList = document.getElementById('getAllyoukeList');
								for(var i = 0; i<su.data.length; i++){
									ht = ht+'<li>'
									+'<span style="width: 200px; float: left;">'
									+su.data[i].class_name
									+'</span>'
									+'<span style="float: left; margin-left: 60px;">'
									+su.data[i].user_time
									+'</span>'
									+'<span style="float: left; margin-left: 160px;">'
									+su.data[i].period
									+'</span>'
									+'<span style="float: right; width: 120px; height: 60px; line-height: 65px !important;">'
									+'<a name="'
									+su.data[i].id
									+'" href="applyDetails.html?id='+su.data[i].id+'">查看详情</a>'
									+'</span>'
									+'</li>';
								}
								getAllyoukeList.innerHTML = ht;
							}else{
								alert(su.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
			