//这个值最后要从域中取出
var submitUrlPrefix = "http://localhost:11090";
var succes_code = "1";
var fail_code = "0"; //业务code未定义

//格式化时间 yyyy-MM-dd hh:mm:ss
function dateFtt(time) { //author: meizz   
	fmt = "yyyy-MM-dd hh:mm:ss";
	date = new Date(time);
	var o = {
		"M+": date.getMonth() + 1, //月份   
		"d+": date.getDate(), //日   
		"h+": date.getHours(), //小时   
		"m+": date.getMinutes(), //分   
		"s+": date.getSeconds(), //秒   
		"q+": Math.floor((date.getMonth() + 3) / 3), //季度   
		"S": date.getMilliseconds() //毫秒   
	};
	if(/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
	for(var k in o)
		if(new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

/**
 * 获取请求参数
 * 使用方法：
 * var a=GetRequest();
	var id=a['e_id'];
 */
function GetRequest() {
	var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if(url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for(var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}

function checkRespData(data) {
	if(data != null && data != undefined && data!='') {
		return true;
	} else {
		return false;
	}
}

function checkParamIsNull(data) {
	if(data == null || data == undefined || data=='') {
		return true;
	} else {
		return false;
	}

}