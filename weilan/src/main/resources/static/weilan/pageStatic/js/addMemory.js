$(function() {
	init();
});

function init() {
	initCategory();
}

function initCategory() {
	$.ajax({
		url: submitUrlPrefix + "/category/query",
		type: "post",
		success: function(data) {
			if(checkRespData(data)) {
				if(data.code == succes_code) {
					var $categorySle = $("#categorySle");
					$.each(data.data, function(ind, category) {
						$categorySle.append("<option value='" + category.id + "' title = '" + category.description + "' >" + category.name + "</option>");
					});

				}
			} else {
				console.log("fail");
				layer.msg("没有获取到分类，请刷新页面重新加载，谢谢");
			}

		},
		error: function() {
			console.log("连接服务器异常");
		}
	});

}

function addMemory() {

	var content = $("#contentTex").val();
	var categoryId = $("#categorySle").val();

	if(checkParamIsNull(content) || checkParamIsNull(categoryId)) {
		layer.msg("请选择分类并且填写心情");
		return;
	} else if(content.length > 100) {
		layer.msg("文本内容最长为100个文字");
		return;
	}
	var param = {
		"categoryId" : categoryId,
		"content" : content	,
	};
	
	$.ajax({
		url: submitUrlPrefix + "/memory/add",
		type: "post",
		data:param,
		success: function(data) {
			if(checkRespData(data)) {
				if(data.code == succes_code) {				
					layer.msg(data.msg,{time: 2},function(){
						window.location.href = "showMemory1.html";						
					});
				}
			} else {
				console.log("fail");
				
			}

		},
		error: function() {
			console.log("连接服务器异常");
		}
	});

}