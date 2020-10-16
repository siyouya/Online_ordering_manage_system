$('.conLeft li').on('click',function(){
	$(this).addClass('bg').siblings().removeClass('bg');
	var intername=$(this).children('.liRight').children('.intername').text();
	$('.headName').text(intername);
	$('.newsList').html('');
})
$('.sendBtn').on('click',function(){

	var news=$('#dope').val();
	if(news==''){
		alert('不能为空');
	}else{
		$('#dope').val('');
		var str='';
		str+=

			'<li>'+
			'<div class="nesHead"><img src="/storeMange/img/6.jpg"/></div>'+
			'<div class="news"><img class="jiao" src="/storeMange/img/20170926103645_03_02.jpg">'+news+'</div>'+
			'</li>';
		//发送到服务器端
		webSocket.send(str);

		//$('.newsList').append(str);

		//自动回复加入判断，如果是字符串包含商家则显示在右边？骑手也显示在右边？
		//setTimeout(answers,1000);
		//左显示？
		//$('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
		//右显示？
		//$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	}

})
$('.ExP').on('mouseenter',function(){
	$('.emjon').show();
})
$('.emjon').on('mouseleave',function(){
	$('.emjon').hide();
})
$('.emjon li').on('click',function(){
	var imgSrc=$(this).children('img').attr('src');
	var str="";
	str+='<li>'+
		'<div class="nesHead"><img src="/storeMange/img/6.jpg"/></div>'+
		'<div class="news"><img class="jiao" src="/storeMange/img/20170926103645_03_02.jpg"><img class="Expr" src="'+imgSrc+'"></div>'+
		'</li>';
	$('.newsList').append(str);
	$('.emjon').hide();
	$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
})