/*获得记录总数Ajax*/
var baseurl= "http://localhost:8080/brrowSystem/";
var count;
$.ajax({
		url:baseurl+"getRecordCount",
		data:{
			
		}, 
		type:'GET',
		dataType:"json",
		success:function(success){
			if(success.code === 0){
				count = success.count;
			}else{
				alert(success.msg);
			}
		},
		error:function(xhr,s,e){
			alert("fail");
			//console.log(xhr,s,e);
		}
})
var pageMax = Math.ceil(count);
var page = 1;
var selectPage = document.getElementById('selectPage');
selectPage.value = page;
getBorrowInfoList();
function pages(canshu){
	page = canshu;
	getBorrowInfoList();
}
function lastPage(){
	if(page<=1){
		alert("没有上一页了");
		/*document.getElementById('lastPage').disabled = true;*/
	}else{
		page = page - 1;
		selectPage.value = page;
		getBorrowInfoList();
	}
}
function nextPage(){
	if(page<pageMax){
		page++;
		selectPage.value = page;
		getBorrowInfoList();
	}else{
		alert("没有上一页了");
		/*document.getElementById('nextPage').disabled = true;*/
	}
}

	/*ajax部分*/

		//获取借用信息记录ajax

	function getBorrowInfoList(){
		$.ajax({
					url:baseurl+"getBorrowInfoList",
					data:{
						page: page,
					}, 
					method:'get',
					dataType:"json",
					success:function(su){
						var ht = '';
						if(su.code === 0){
							var getBorrowInfoList = document.getElementById('getBorrowInfoList');
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
								+'<button name="'
								+su.data[i].record_id
								+'" onclick=deleteThisList(this);>删除</button>'
								+'</span>'
								+'<span style="float: right; width: 120px; height: 60px; line-height: 65px !important;">'
								+'<a name="'
								+su.data[i].record_id
								+'" href="borrowInfoDetail.html?name='+su.data[i].record_id+'">查看详情</a>'
								+'</span>'
								+'</li>';
							}
							getBorrowInfoList.innerHTML = ht;
						}else{
							alert(su.msg);
						}
					},
					error:function(xhr,s,e){
						//console.log(xhr,s,e);
					}
				})
		}
			
	function deleteThisList(de){
		var record_id = de.name;
		/*删除一条借用记录Ajax*/
		$.ajax({
					url:baseurl+"deleteBorrowInfo",
					data:{
						record_id: record_id,
					}, 
					method:'post',
					dataType:"json",
					success:function(suDelete){
						if(suDelete.code === 0){
							window.location.href = "rootMain.html"
						}else{
							
							alert(suDelete.msg);
						}
					},
					error:function(xhr,s,e){
						console.log(xhr,s,e);
					}
			})
	}
	
/*获取申请消息总数Ajax*/
	$.ajax({
					url:baseurl+"getApplyCount",
					data:{
						
					}, 
					method:'GET',
					dataType:"json",
					success:function(suc){
						if(suc.code === 0){
							//alert(suc.data.applycount);
							document.getElementById("applyCount").innerHTML=suc.data.applycount;
							
						}else{
							alert(suc.msg);
						}
					},
					error:function(xhr,s,e){
						console.log(xhr,s,e);
					}
			})