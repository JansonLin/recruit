
/**
 * 从列表页面进入编辑页面后返回列表页面，封装所有查询条件参数
 * @author chenliang
 */
function toFormPar(fName,flat){
	var obj=$(fName).serializeArray();
	var s ="";
	 $.each(obj,function(index,param){  
	        if(!(param.name in obj)){  
	            obj[param.name]=param.value;  
	            s+=param.name+"="+param.value+"&";
	        }  
	    });
	 var str = encode64(s);
	 if(flat==0){
		 return "?obj="+str;
	 }else{
		 
		 return "&obj="+str;
	 }
}

/**
 * 从列表页面进入编辑页面后返回列表页面，解析所有查询条件参数
 * @author chenliang
 */

function forFormPar(s,form){
	var par=decode64(s);
	var pars=par.split("&");
	var obj ={};
	$.each(pars,function(){
		var filedName=this.split('=')[0];
		var filedVlaue=this.split('=')[1];
		if(filedVlaue!=""){
			obj[filedName]= filedVlaue;
			//alert("obj["+filedName+"]="+filedVlaue);
		}
		
	});
	
	loadFrom(form,obj);
}

/**
 * 从列表页面进入编辑页面后返回列表页面，解析所有查询条件参数
 * @author chenliang
 */

function getObj(s){
	var par=decode64(s);
	return par;
}

/**
 * 格式化时间:尾部多0
 */
function created_time(value,row,index){
	if (row.created_time){
		return row.created_time.substring(0,row.created_time.length-2);
	} else {
		return value;
	}
}
/**
 * 格式化时间:尾部多0
 */
function date_format(value,row,index){
	if(value){
		return value.substring(0,value.length-2);
	}
}
function modified_time(value,row,index){
	if (row.modified_time){
		return row.modified_time.substring(0,row.modified_time.length-2);
	} else {
		return value;
	}
}

/*
 *  EUI Library 1.0
 */
EUI = { 
	Version: '1.0',
	IsMSIE: (null!=window.ActiveXObject),
	IsDebug: false,
	util:{
		loadFrom:function(fm,node){
			var obj ={};
			var data =$.evalJSON($.toJSON(node));
			var name='';
			var namespace='';
			var _fm=fm
			 $(fm+' input,select').each(function(){ 
			        name=$(this).attr('name');
			        if(typeof(name) == "undefined"||!name)return true;
			        if($(_fm).find('input[comboname='+name+']').hasClass('easyui-datetimebox')){
			        		obj[name]= formatDatebox(data[name]);
			        }else{
			        	obj[name]= data[name];
			        }
			 });
			$(fm).form('load',obj);
			
		},
		openPropWindows:function(config){
			var className = config.className;
			var Prop_Name=config.propName;
			var href="/web/common/baseprop.jsp?cn="+className;
			$(Prop_Name).window($.extend(true,config, {
		           content: '<iframe scrolling="yes" frameborder="0"  src="' + href + '" style="width:100%;height:99%;"></iframe>',
		           shadow: false,
		           cache: false,
		           closed: false,
		           collapsible: false,
		           resizable: false,
		           loadingMessage: '正在加载数据，请稍等片刻......'
		        }));
			$(Prop_Name).window('open');  // open a window
		},
		openUploadWindows:function(config){
			var className = config.className;
			var href="/web/common/upload.jsp?cn="+className;
			var f = document.createElement("div");
			f.id="uploadDocProp";
			 document.body.appendChild(f);
			$("#uploadDocProp").window($.extend(true,config, {
		           content: '<iframe scrolling="no" frameborder="0"  src="' + href + '" style="width:100%;height:98%;"></iframe>',
		           shadow: false,
		           cache: false,
		           closed: false,
		           collapsible: false,
		           width:420,
				   height:150,
		           loadingMessage: '正在加载数据，请稍等片刻......'
		        }));
			$("#uploadDoc").window('open');  // open a window
		}
	}

}
 





/**
 * 格式化时间
 */
 

function formatDatebox(value) {
        if (value == null || value == '') {
            return '';
        }
    var dt;
    if (value.constructor == Date) {
        dt = value;
    }else if (value.constructor ==String){
    	return value;
    }else {
        dt = new Date(value);
        if (isNaN(dt)) {
            value = value.replace(/\/Date\((-?\d+)\)\//, '$1'); //标红的这段是关键代码，将那个长字符串的日期值转换成正常的JS日期格式
            dt = new Date();
            dt.setTime(value);
        }
    }

    return dt.format("yyyy-MM-dd hh:mm:ss");   //这里用到一个javascript的Date类型的拓展方法，这个是自己添加的拓展方法，在后面的步骤3定义
}

function formatDatetimebox(value) {
    if (value == null || value == '') {
        return '';
    }
    if (value == '小计' || value == '合计'||value == '期初') {
        return value;
    }
var dt;
if (value.constructor == Date) {
    dt = value;
}else if (value.constructor ==String){
	return value;
}
else {
    dt = new Date(value);
    if (isNaN(dt)) {
        value = value.replace(/\/Date\((-?\d+)\)\//, '$1'); //标红的这段是关键代码，将那个长字符串的日期值转换成正常的JS日期格式
        dt = new Date();
        dt.setTime(value);
    }
}

return dt.format("yyyy-MM-dd");   //这里用到一个javascript的Date类型的拓展方法，这个是自己添加的拓展方法，在后面的步骤3定义
}

$.extend(
	    $.fn.datagrid.defaults.editors, {
	        datebox: {
	            init: function (container, options) {
	                var input = $('<input type="text">').appendTo(container);
	                input.datebox(options);
	                return input;
	            },
	            destroy: function (target) {
	                $(target).datebox('destroy');
	            },
	            getValue: function (target) {
	                return $(target).datebox('getValue');
	            },
	            setValue: function (target, value) {
	                $(target).datebox('setValue', formatDatebox(value));
	            },
	            resize: function (target, width) {
	                $(target).datebox('resize', width);
	            }
	        }
 });
Date.prototype.format = function (format) 
{
    var o = {
        "M+": this.getMonth() + 1, //month 
        "d+": this.getDate(),    //day 
        "h+": this.getHours(),   //hour 
        "m+": this.getMinutes(), //minute 
        "s+": this.getSeconds(), //second 
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter 
        "S": this.getMilliseconds() //millisecond 
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
      RegExp.$length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {  
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};

$.alert = function(msg,title){
	if(!title)title='提示';
	$.messager.alert(title,msg);
}  
 
$.openProgress = function(title,msg){
	 $.messager.progress({
			title : '提示',
			text : '数据处理中，请稍后....'
		});
}  
$.closeProgress = function(msg){
	 $.messager.progress('close');
} 

function loadFrom(fm,node){
	
	EUI.util.loadFrom(fm,node);
	
}

function getRootPath() {
    //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/ems
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return(localhostPath);
}
/**
 * 获取当前时间，0000-00-00 00:00:00
 */
function getNowTime(){
	var d = new Date()
	var y = d.getFullYear()
	var m = d.getMonth() + 1
	var r = d.getDate()
	var h = d.getHours(); 
	var f = d.getMinutes(); 
	var s = d.getSeconds(); 
	t=y+"-"+(m<10 ? "0" + m : m)+"-"+(r<10 ? "0"+ r : r)+" "+(h<10 ? "0"+ h : h)+":"+(f<10 ? "0" + f : f)+":"+(s<10 ? "0" +s : s);
	return t;
}








