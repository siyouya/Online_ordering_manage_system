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
						'<div class="answerHead"><img src="/storeMange/img/tou.jpg"/></div>'+
						'<div class="answers"><img class="jiao" src="/storeMange/img/jiao.jpg">'+news+'</div>'+
					'</li>';
			//发送到服务器端
			webSocket.send(str);
			//$('.newsList').append(str);
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
		'<div class="answerHead"><img src="/storeMange/img/6.jpg"/></div>'+
		'<div class="answers"><img class="jiao" src="/storeMange/img/20170926103645_03_02.jpg"><img class="Expr" src="'+imgSrc+'"></div>'+
		'</li>';
	$('.newsList').append(str);
	$('.emjon').hide();
	$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
})