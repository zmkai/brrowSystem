var baseurl= "http://localhost:8080/brrowSystem/";
		var myTime = new Date();
		var week = myTime.getDay();
		if(week == 0){
			week+=7;
		}
		var middleTime = new Date(myTime.getTime() - (week-1) * 24 * 60 * 60 * 1000);
		var fourteenDate = '';
		var dateString = myTime.getFullYear() + '-' + (myTime.getMonth()+1) + '-' + myTime.getDate();
		//得到两周的日期
			for(var p = 0; p < 14; p++) 
			{
				var finalTime = new Date(middleTime.getTime() + p * 24 * 60 * 60 * 1000);
				var time = (finalTime.getMonth() + 1) + "月" + finalTime.getDate() + "日";
				fourteenDate = fourteenDate + '<td><font color="#399b69">' + time + '</font></td>';
			}
			fourteenDate = '<td></td>' +fourteenDate;
			document.getElementById('innerDate').innerHTML = fourteenDate;
		//获取教室信息列表并写入页面内必要信息
	$.ajax({
			url: baseurl +"getClassroomList",
						data:{
							
						}, 
						method:'get',
						dataType:"json",
						success:function(suList){
							if(suList.code === 0){
								var innerTable=document.getElementById('innerTable');
								var ht='';
								 for(var i=0; i<suList.data.length; i++){
								 	ht +='<table border="" cellspacing="" cellpadding="" style="border-collapse: collapse;">'
								 		+'<tr ><th style="width: 1020px; height: 40px; background-color: #399b69;" colspan="15"><font color="#FFFFFF">'
								 		+suList.data[i].class_name
								 		+'</font></th></tr>'
								 		+'<tr style="width: 1020px; height: 35px;">'
								 		+'<td></td>'
								 		+'<td colspan="7" style="text-align: center;">本周教室使用情况</td>'
								 		+'<td colspan="7" style="text-align: center;">下周教室使用情况</td>'
								 		+'</tr>'
								 		+'<tr style="height: 30px;" id="innerDate">'
								 		+fourteenDate
								 		+'</tr>'
								 		+'<tr style="height: 30px;">'
								 		+'<td></td>'
								 		+'<td>周一</td>'
								 		+'<td>周二</td>'
								 		+'<td>周三</td>'
								 		+'<td>周四</td>'
								 		+'<td>周五</td>'
								 		+'<td>周六</td>'
								 		+'<td>周天</td>'
								 		+'<td>周一</td>'
								 		+'<td>周二</td>'
								 		+'<td>周三</td>'
								 		+'<td>周四</td>'
								 		+'<td>周五</td>'
								 		+'<td>周六</td>'
								 		+'<td>周天</td>'
								 		+'</tr>'
							 		//第一节字符串拼接
								 		+'<tr class="course" style="background-color: rgba(231, 231, 231, 1);">'
								 		+'<td>第一大节</td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-1"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-2"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-3"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-4"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-5"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-6"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-7"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-8"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-9"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-10"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-11"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-12"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-13"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-1-14"></td>'
								 		+'</tr>'
						 			//第二节字符串拼接
								 		+'<tr class="course">'
								 		+'<td>第二大节</td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-1"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-2"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-3"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-4"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-5"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-6"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-7"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-8"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-9"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-10"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-11"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-12"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-13"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-2-14"></td>'
								 		+'</tr>'
							 		//第三节字符串拼接
								 		+'<tr class="course" style="background-color: rgba(231, 231, 231, 1);">'
								 		+'<td>第三大节</td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-1"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-2"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-3"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-4"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-5"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-6"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-7"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-8"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-9"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-10"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-11"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-12"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-13"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-3-14"></td>'
								 		+'</tr>'
							 		//第四节字符串拼接
								 		+'<tr class="course">'
								 		+'<td>第四大节</td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-1"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-2"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-3"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-4"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-5"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-6"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-7"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-8"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-9"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-10"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-11"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-12"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-13"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-4-14"></td>'
								 		+'</tr>'
							 		//第五节字符串拼接
								 		+'<tr class="course" style="background-color: rgba(231, 231, 231, 1);">'
								 		+'<td>第五大节</td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-1"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-2"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-3"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-4"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-5"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-6"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-7"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-8"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-9"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-10"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-11"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-12"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-13"></td>'
								 		+'<td id="'
								 		+suList.data[i].class_name
								 		+'-5-14"></td>'
								 		+'</tr>'
								 		+'</table>';
								 	}
								innerTable.innerHTML = ht;
							}else{
								alert(suList.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})
			//获取两周内教室借用信息
	$.ajax({
						url:baseurl+"getBorrowInfo",
						data:{
							dateString: dateString,
						}, 
						method:'get',
						dataType:"json",
						success:function (suc){
							if(suc.code == 0){
								for (var q=0; q<suc.data.length; q++) {
									var class_name = suc.data[q].class_name;
									var user_time = suc.data[q].user_time;
									var user = suc.data[q].username;
									var period = suc.data[q].period;
									var nowDate = middleTime.getDate();
									var userTimeDate = user_time.split("-")[2];
									var difference = userTimeDate - nowDate;
									var dtt = new Date(user_time.replace("-g-/", ""));
									var week = dtt.getDay();
									if(week == 0){
										week += 7;
									}
									if (difference >= 7) {
										week = week +7;
									}
									var finalId = class_name + "-" + period + "-" +week;
									document.getElementById(finalId).innerText = user;
								}
							}else{
								alert(suc.msg);
							}
						},
						error:function(xhr,s,e){
							console.log(xhr,s,e);
						}
					})