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
						'<div class="answerHead"><img src="img/tou.jpg"/></div>'+
						'<div class="answers"><img class="jiao" src="img/jiao.jpg">'+news+'</div>'+
					'</li>';
			//发送到服务器端
			webSocket.send(str);

			//$('.newsList').append(str);



		}

	})