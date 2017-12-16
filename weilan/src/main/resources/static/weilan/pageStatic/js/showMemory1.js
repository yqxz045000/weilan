$(function(){
	init();
	function init(){
		//初始化菜单
		//初始化memory
		//初始化音乐
		
		//初始化背景
		loadMemory();
	}
	
	
	function loadMemory(){
		
		var reqParam = {};
		
		$.ajax({
			type:"post",
			url:"http://localhost:11090/memory/query",
//			data:reqParam,
			success:function(respData){
				if(respData.code ==1){
					var data =respData.data;
					var memoryList = data.result;
					var $memoryList = $("#memoryList_ul");
//					var $memoryList = $(".memoryList");
					$.each(memoryList, function(index,memory) {
//						$memoryList.append("<div class='memoryContent margin_bottom_20' >"+memory.content+"</div>");	
						$memoryList.append('<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"><i class="layui-icon layui-timeline-axis"></i><div class=" memoryContent  layui-text"><h4 class="layui-timeline-title">'+memory.createTime+'</h4><p>'+memory.content+'</i></p></div></li>');
					});

									
				}else{
					console.log(respData.msg);
				}
			},
			error:function (){
				console.log("error");
			}
		});
		
		
	}
	
	
	
	
});
















































































