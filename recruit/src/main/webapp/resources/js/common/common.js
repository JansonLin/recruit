"use strict";
/**
 * [Edata 通用类]
 * @type {Object}
 */
var common = {
	/**
	 * 加载脚本
	 * @method LoadScript
	 * @for mamijd
	 * @param string src 加载地址.js
	 * @param function callback 加载完毕回调内容
	 * @param string charset 加载编码
	 * @return {html,json} document
	 */
	LoadScript: function(src, callback, charset) {
		var script = document.createElement('script');
		script.setAttribute('language', 'javascript');
		if (charset) {
			script.setAttribute('charset', charset);
		}
		script.setAttribute('type', 'text/javascript');
		// script.setAttribute('defer',` '');
		script.setAttribute('src', src);
		document.getElementsByTagName("head")[0].appendChild(script);
		if (document.all) {
			script.onreadystatechange = function() {
				if (this.readyState == 4 || this.readyState == 'complete' || this.readyState == 'loaded') {
					if (callback) {
						callback();
					}
				}
			};
		} else {
			script.onload = function() {
				if (callback) {
					callback();
				}
			};
		}
	},
	/**
	 * 打印对象
	 * @method dump_obj
	 * @for mamijd
	 * @param obj 对象
	 * @return string 对象下标
	 */
	dump_obj: function(myObject) {
		var s = "";
		for (var property in myObject) {
			s = s + "\n " + property + ": " + myObject[property];
		}
		alert(s);
	},
	/**
	 * 友好时间格式化
	 * @method jsDateDiff
	 * @for mamijd
	 * @param time unixtime 时间戳
	 * @return string 格式化后的距离天数
	 */
	jsDateDiff: function(unixtime) {
		var d_minutes, d_hours, d_days;
		var timeNow = parseInt(new Date().getTime() / 1000);
		var d;
		d = timeNow - unixtime;
		d_days = parseInt(d / 86400);
		d_hours = parseInt(d / 3600);
		d_minutes = parseInt(d / 60);
		if (d_days > 0 && d_days < 4) {
			return d_days + "天前";
		} else if (d_days <= 0 && d_hours > 0) {
			return d_hours + "小时前";
		} else if (d_hours <= 0 && d_minutes > 0) {
			return d_minutes + "分钟前";
		} else {
			var s = new Date(unixtime * 1000);
			// s.getFullYear()+"年";
			return s.getFullYear() + "年" + (s.getMonth() + 1) + "月" + s.getDate() + "日";
		}
	},
	GetRequest: function() {
		var url = location.search; //获取url中"?"符后的字串 
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			var strs = str.split("&");
			for (var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
			}
		}
		return theRequest;
	},isWeiXin:function(){ 
		var ua = window.navigator.userAgent.toLowerCase(); 
		if(ua.match(/MicroMessenger/i) == 'micromessenger'){ 
			return true; 
		}else{ 
			return false; 
		}
	}
}



/**
 * 全局通用请求
 * @class {ajax}
 *同步请求
 */
var ajaxGetDataSyn = {
    active: false,
    init: function (host,param,type,callback){
        var self;
        if (this.active === false) {
            console.log("1.进入请求11111111111111")
            this.active = true;
            self = this;
            $.ajax({
                url: host,
                type: type,
                dataType: 'json',
                data: param,
                success:function(success){
                    callback(success);
                    console.log(success);
                    console.log("2.返回数据成功，sucess "+self.active);
                },
                complete:function(XHR, textStatus){
                    self.active = false;
                    console.log("3.完成请求，complete "+self.active);
                    console.log(textStatus);
                    if(textStatus=="error"){
                    	window.location.href="/404.jsp";
                    }
                    
                },
                error:function(err){
                    console.log(err);
                    if(err.status==404){
                    	window.location.href="/404.jsp";
                    }
                    if(err.status==401){
                    	window.location.href="/401.jsp";
                    }
                }
            });
        }else{
            console.log("上一次请求还未完成，请稍后")
        }
    }
};
/*普通异步请求*/
function ajaxGetData(host,param,type,callback){
	$.ajax({
		url: host,
		type: type,
		dataType: 'json',
		data: param,
		success:function(success){
			callback(success);
		},
		error:function(err){
			console.log(err);
			if(err.status==404){
            	window.location.href="/404.jsp";
            }
			if(err.status==401){
            	window.location.href="/401.jsp";
            }
            //$m.tips("网络出错请稍候再试");
		}
	});
}


/*异步加载ajax请求封装*/
function wrapPromise( callback ){
    var dtd = $.Deferred(); //在函数内部，新建一个Deferred对象
    callback(dtd);
    return dtd.promise(); // 返回promise对象
    
}
/*通用方法*/
(function(window){
    var c = {};
    //普通的对话框2秒后消失
    c.tips=function(message){
        layer.open({
            content: message,
            shadeClose: false,
            style: 'text-align:center;',
            btn: ['OK'],
            time: 2
        });
    };
    //普通的对话框
    c.loading=function(message){
        layer.open({
             type: 2,
             content: message
            //,time: 5
        });

    };
    
  //关闭所有对话框
    c.close=function(){
        //var i = layer.open({});  	
        layer.closeAll();

    };
    //对话框，点击确定再能进行下一步
    c.dialogTips=function(obj){
        layer.open({
            content: obj.txt
            ,shadeClose: false
            ,btn: [obj.btnTxt?obj.btnTxt:"确定"]
            ,yes:obj.fun?obj.fun:null
        });

    };
    
    //对话框，点击确定，点击取消
    c.dialogTips2=function(obj){
        layer.open({
            content: obj.txt,
            btn: [obj.btnTxt?obj.btnTxt:"确定",obj.nobtnTxt?obj.nobtnTxt:"取消"],
            shadeClose: false,
            yes: obj.fun?obj.fun:null,
            no: obj.nofun?obj.nofun:null
        });

    };
    

    //手机号码验证
    c.mobileVerify=function(obj){
        var mobile;
        if($(obj).is('input')){
        	mobile=$(obj).val();    
        }else{
        	mobile=$(obj).text();       
            
        }
        console.log(obj)
        //var name =$("#customerName").val();
        if(mobile !== null && !/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/i.test(mobile)){
            c.tips('号码有误，请重新输入');
            return false;
        }
        /*//暂时去掉姓名验证
         else if (name==null) {
         tips('请输入您的姓名');
         return;
         }
         */
        else{
            return true
        }

    };
    
    //邮箱验证
    c.emailVerify=function(obj){
    	var email;
    	 if($(obj).is('input')){
    		 email=$(obj).val();    
         }else{
        	 email=$(obj).text();       
             
         }
    	if(email !=null &&  !/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/i.test(email)){
    		c.tips('邮箱有误，请重新输入');
            return false;
    	}else{
    		return true;
    	}
    }

    //邮编验证
    c.postageVerify=function(obj){
    	var postage;
    	 if($(obj).is('input')){
    		 postage=$(obj).val();    
         }else{
        	 postage=$(obj).text();       
             
         }
    	if(postage !=null &&  !/^[1-9][0-9]{5}$/.test(postage)){
    		c.tips('邮编有误，请重新输入');
            return false;
    	}else{
    		return true;
    	}
    }

    //清除客户的电话-本地存储

    //本地存储清除
    c.clearlocalStorage=function(key,val){
        localStorage.clear();
    };
    /*删除指定值*/
    c.removeStorage = function(key){
        if(key){
            localStorage.removeItem(key);
        }
    };
    //获取本地存储
    c.loadlocalStorage=function(key){
        return localStorage.getItem(key);
    };
    //设置本地存储
    c.setlocalStorage=function(key,val){
        localStorage.setItem(key,val)
    };

    

    /*简单的表单验证，输入框和下拉select，增加，修改记录，保存时验证*/
    c.checkForm=function(id,txt){
        var obj=$("#"+id);
        if( obj.is('input') ){
            if(obj.val()=="" || !obj.val() ){
                c.tips(txt);
                return false;
            }
        };

        if( obj.is('select') ){
            if(obj.find("option").eq(0).val()==obj.val()){
                c.tips(txt);
                return false;
            }
        };
        return true;

    };
    //查询时，验证输入框的输入是否符合
    c.verifyPwdInput=function(id,txt){
        var iptTelMaxlength=6;
        var v;
        var curValue=$("#"+id).val();
        var curLength=$("#"+id).val().length;

        if(curLength<iptTelMaxlength){
            //查询操作
            c.tips(txt);
            return ;
        }
        return true;
    };
    
    //检查2个输入框是否相等
    c.verifyPwdEqu=function(id1,id2,txt){
        var curValue1=$("#"+id1).val();
        var curValue2=$("#"+id2).val();
        if(curValue1!=curValue2){
            //查询操作
            c.tips(txt);
            return ;
        }
        return true;
    };
    
    //查询时，验证输入框的输入是否符合
    c.verifyMobileInput=function(){

        $("#mobile").on("keyup",function(){
            var iptTelMaxlength=11;
            var v;
            var curValue=$(this).val();
            var curLength=$(this).val().length;
            if( !(curValue+1>=0) ){
                var vv=$(this).val().substring(0,curValue.length-1)
                $(this).val(vv)
            };
            if(iptTelMaxlength==curLength && c.mobileVerify()){
                //查询操作
            };
            if(curLength>11){
                if( !(curValue+1>=0) ){//有字母时重置
                    alert("号码有误请重新输入")
                    $(this).val("");
                }
                v=$(this).val().substring(0,11);
                $(this).val(v);
            };
            if(curLength>0){
                $(this).addClass("hasVal");
                $(".cleanTxt").show();
            };
        });

    };
    /*验证输入的字符串长度*/
    c.verifyMixTxt=function(inputval,obj,len,txt)   
    {   

            //去除首尾空格   
            inputval = inputval.replace(/^\s*|\s*$/g,"");   
            //零长字串不作处理   
            if ( inputval.length == 0 )   
            {   
                return;   
            }   
            //只能匹配数字,字母或汉字   
            var _match = inputval.match(/^[a-za-z0-9\u4e00-\u9fa5]+$/g);   
            //匹配数字或字母(包括大小写)   
            var codematch = inputval.match(/[a-za-z0-9]/g);   
            //匹配汉字   
            var charmatch = inputval.match(/[\u4e00-\u9fa5]/g);   
            //数字或字母个数   
            var codenum = codematch ? codematch.length : 0;   
            //汉字个数   
            var charnum = charmatch ? charmatch.length : 0;   
            
            if ( _match && codenum+charnum <=len && codenum+charnum >2 )   
            {   
                console.log("输入正确");
                return  true;
            }	
            //obj.value = inputval.substring(0,6);
            //console.log("输入错误!");  
            /*弹出提示*/
            c.tips(txt);
            obj.focus();
            return  false;

        
        
            
    }   
    
    //模版
    c.xxx=function(xxx){


    };


    window.$m = c;

})(window);

 //影响到了easyui自适应高度
/*安卓打开输入框时固定高度*/
//var HEIGHT = $('body').height();
//$(window).resize(function() {
//    $('body').height(HEIGHT);
//});
//
//$(window).on("load",function(){
//    $(".loadPage").fadeOut(500); 
//})
