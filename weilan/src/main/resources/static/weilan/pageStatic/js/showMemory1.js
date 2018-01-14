var pageNo = 1;
var pageSize = 5;
$(function() {
	init();

	function init() {
		//初始化菜单
		//初始化memory
		//初始化音乐
		//初始化背景
//		initCanvas();  //这个设置了画布，导致下面的背景元素不能被点击。
		loadMemory();
	}

});

function loadMemory() {
	pageNo = pageNo + 1;
	var $loadMemoryB = $("#loadMemoryB");
	
	var reqParam = {
		"pageNo": pageNo - 1,
		"pageSize": pageSize,
	};

	$.ajax({
		type: "post",
		url: submitUrlPrefix + "/memory/query",
		data: reqParam,
		success: function(respData) {
			if(respData.code == succes_code) {
				var data = respData.data;
				var memoryList = data.result;
				if(memoryList==null || memoryList==undefined || memoryList.length==0){
					//如果已经没有数据，则将加载按钮失效
					console.log("已经没有更多的数据");
					
//					$loadMemoryB.addClass("layui-btn-disabled");
					$loadMemoryB.attr("disabled", true);
					$loadMemoryB.text("已经没有更多的数据");
					
					return ;
				}
				var $memoryList = $("#memoryList_ul");
				//					var $memoryList = $(".memoryList");
				$.each(memoryList, function(index, memory) {
					$memoryList.append("<div class='memoryContent margin_bottom_20' >" + memory.content + "</div>");
					//						$memoryList.append('<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"><i class="layui-icon layui-timeline-axis"></i><div class=" memoryContent  layui-text"><h4 class="layui-timeline-title">'+memory.createTime+'</h4><p>'+memory.content+'</i></p></div></li>');				
				});

			} else {
				console.log(respData.msg);
			}
		},
		error: function() {
			console.log("error");
		}
	});
}

function initCanvas() {
	var canvas = document.getElementById("cas");
	var ctx = canvas.getContext("2d");
	ctx.fillStyle = 'rgba(255, 255, 255, 0)';

	resize();
	window.onresize = resize;

	function resize() {
		canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
		canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
	}

	var RAF = (function() {
		return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(callback) {
			window.setTimeout(callback, 1000 / 60);
		};
	})();

	// 鼠标活动时，获取鼠标坐标
	var warea = {
		x: null,
		y: null,
		max: 20000
	};
	window.onmousemove = function(e) {
		e = e || window.event;
		warea.x = e.clientX;
		warea.y = e.clientY;
	};
	window.onmouseout = function(e) {
		warea.x = null;
		warea.y = null;
	};

	// 添加粒子
	// x，y为粒子坐标，xa, ya为粒子xy轴加速度，max为连线的最大距离
	var dots = [];
	for(var i = 0; i < 300; i++) {
		var x = Math.random() * canvas.width;
		var y = Math.random() * canvas.height;
		var xa = Math.random() * 2 - 1;
		var ya = Math.random() * 2 - 1;

		dots.push({
			x: x,
			y: y,
			xa: xa,
			ya: ya,
			max: 6000
		})
	}

	// 延迟100秒开始执行动画，如果立即执行有时位置计算会出错
	setTimeout(function() {
		animate();
	}, 100);

	// 每一帧循环的逻辑
	function animate() {
		ctx.clearRect(0, 0, canvas.width, canvas.height);

		// 将鼠标坐标添加进去，产生一个用于比对距离的点数组
		var ndots = [warea].concat(dots);

		dots.forEach(function(dot) {

			// 粒子位移
			dot.x += dot.xa;
			dot.y += dot.ya;

			// 遇到边界将加速度反向
			dot.xa *= (dot.x > canvas.width || dot.x < 0) ? -1 : 1;
			dot.ya *= (dot.y > canvas.height || dot.y < 0) ? -1 : 1;

			// 绘制点
			ctx.fillRect(dot.x - 0.5, dot.y - 0.5, 1, 1);

			// 循环比对粒子间的距离
			for(var i = 0; i < ndots.length; i++) {
				var d2 = ndots[i];

				if(dot === d2 || d2.x === null || d2.y === null) continue;

				var xc = dot.x - d2.x;
				var yc = dot.y - d2.y;

				// 两个粒子之间的距离
				var dis = xc * xc + yc * yc;

				// 距离比
				var ratio;

				// 如果两个粒子之间的距离小于粒子对象的max值，则在两个粒子间画线
				if(dis < d2.max) {

					// 如果是鼠标，则让粒子向鼠标的位置移动
					if(d2 === warea && dis > (d2.max / 2)) {
						dot.x -= xc * 0.03;
						dot.y -= yc * 0.03;
					}

					// 计算距离比
					ratio = (d2.max - dis) / d2.max;

					// 画线
					ctx.beginPath();
					ctx.lineWidth = ratio / 2;
					ctx.strokeStyle = 'rgba(0,0,0,' + (ratio + 0.2) + ')';
					ctx.moveTo(dot.x, dot.y);
					ctx.lineTo(d2.x, d2.y);
					ctx.stroke();
				}
			}

			// 将已经计算过的粒子从数组中删除
			ndots.splice(ndots.indexOf(dot), 1);
		});

		RAF(animate);
	}

}


function toAddCategoryPage() {
	layer.open({
		type: 2,
		skin: 'layui-layer-lan',
		scrollbar: false,
		area: ['35%', '35%'],
		title: '增加分类',
		content: ['addCategory.html', 'no'],
		btn: ['确认', '取消'],
		yes: function(index, layero) {

			var name = layero.find('iframe')[0].contentWindow.document.getElementById('categoryName');
			var desc = layero.find('iframe')[0].contentWindow.document.getElementById('categoryDesc');
			var param = {
				'name' : name.value,
				'description' :desc.value
			};
			$.ajax({
				url: submitUrlPrefix + "/category/add",
				type: "post",
				data: param,
				success: function(data) {
					if(checkRespData(data)) {
						if(data.code == succes_code) {
							layer.msg(data.msg);
							layer.close(index); //如果设定了yes回调，需进行手工关闭
						}else{
							layer.msg(data.msg);
						}
					} else {
						console.log("fail");
						layer.msg("异常，请刷新页面重新添加，谢谢");
					}

				},
				error: function() {
					console.log("连接服务器异常");
				}
			});

		},
		btn2: function(index) {
			console.log("取消");
			layer.close(index); //如果设定了yes回调，需进行手工关闭		
		}
	})

}



























