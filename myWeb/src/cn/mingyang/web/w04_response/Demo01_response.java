package cn.mingyang.web.w04_response;

/**
 *  响应消息：服务器端发送给客户端的数据
 *      数据格式：
 *          1.响应行
 *              1.1.组成：协议/版本  响应状态码  状态码描述
 *              1.2.响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
 *                  1.状态码都是3位数字
 *                  2.分类：
 *                      1xx：服务器就收客户端信息，但没有接受完成，等待一段时候后，发送1xx多状态码。
 *                      2xx：成功  代表：200。
 *                      3xx：重定向。代表：302（重定向），304（访问缓存）。
 *                      4xx：客户端错误。
 *                          代表：
 *                              404（请求路径没有对应的资源）
 *                              405（请求方式没有对应的doXxx方法）
 *                      5xx：服务器端错误。代表：500（服务器内部出现异常）
 *
 *          2.响应头
 *          3.响应空行
 *          4.响应体
 *
 * 响应字符串格式：这是访问erp.visfarm.com
 * HTTP/1.1 200 OK
 * Server: nginx/1.12.2
 * Date: Wed, 18 Sep 2019 14:04:53 GMT
 * Content-Type: text/html;charset=UTF-8
 * Transfer-Encoding: chunked
 * Connection: keep-alive
 * Vary: Accept-Encoding
 * Cache-Control: no-cache, no-store, max-age=0, must-revalidate
 * Pragma: no-cache
 * Expires: 0
 * X-XSS-Protection: 1; mode=block
 * X-Frame-Options: SAMEORIGIN
 * X-Content-Type-Options: nosniff
 * Set-Cookie: JSESSIONID=C2393A9EA5BBEBA3617064FF860B6C05; Path=/; HttpOnly
 * Content-Language: zh-CN
 * Content-Encoding: gzip
 *
 * <!DOCTYPE html>
 * <html>
 * <head>
 * 	<meta charset="utf-8">
 *     <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
 *     <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
 * 	<title>智慧农业ERP</title>
 *     <link rel="SHORTCUT ICON" href="/images/erp/zhny.ico">
 *     <link rel="stylesheet" href="/css/erp/custom.css">
 *     <link rel="stylesheet" type="text/css" href="/css/app-web.css">
 *     <link rel="stylesheet" href="/BJUI/themes/css/style2.css">
 *     <link rel="stylesheet" type="text/css" href="/js/iview/dist/styles/iview.css">
 *
 * </head><style type="text/css">
 *     body{background-color: white;}
 *     #verifyCode {
 * 		padding-right: 70px;
 * 		background-image: url(/verifyCode);
 * 		background-repeat: no-repeat;
 * 		background-position: right center;
 *     }
 * 	.bjui-ajax-mask {
 * 		display: none;
 *        }
 *     .text-danger{color: red;font-weight: 700;}
 *     </style>
 * <body >
 * 	<div class="erp_login">
 *
 * 		<!-- 登录 -->
 * 		<a href="/" class="erp_logo"> <img src="/images/erp/logo.png"></a>
 * 		<form action="/login" method="post">
 * 			<input name="username" id="username" class="erp_input" onFocus=" if(this.value=='输入用户名') this.value=''" placeholder="输入用户名" value="" type="text" autocomplete="off" maxlength="20">
 * 			<input name="password" id="password" class="erp_input" onFocus="$('.login_password').hide()" onBlur="if(this.value=='') $('.login_password').show()" value="" placeholder="输入密码" type="password" autocomplete="off">
 * 			<span class="u_user" title="更换验证码" onclick="$('#verifyCode').css('background-image', 'url(/verifyCode?'+ new Date().getTime() + ')');"><i class="icon-refresh"></i></span>
 * 			<input name="verifyCode" id="verifyCode" class="erp_input" placeholder="输入验证码" onFocus="$('.login_code').hide()" onBlur="if(this.value=='') $('.login_code').show()" value="" type="text" autocomplete="off" maxlength="4">
 * 			<div class="erp_tips"></div>
 * 			<button class="erp_submit" type="submit" onclick="$('form').submit();" href="javascript:;">登录</button>
 * 			<p><a href="/public/retrievePassword">找回密码</a></p>
 * 		</form>
 * 		<!-- 登录 end-->
 *
 * 		<div class="erp_copy">Copyright &copy 2017-2018 智慧农业 粤ICP备15101694</div>
 * 	</div>
 * </body>
 * <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
 * <script type="text/javascript" src="/js/erp/koala.min.1.5.js"></script>
 * <script src="/js/bootstrap.min.js"></script>
 * <script type="text/javascript">
 * $(document).ready(function() {
 * 	$("#head-info").addClass("fadeshow");
 *
 * 	// 手机菜单
 * 	$("#menu").bind('click', function () {
 *            $("#menubox").fadeIn();
 *            $(".menubackground").fadeIn();
 *            $("html,body").css("overflow", "hidden");
 *        });
 *        $(".menubackground").bind('click', function () {
 *            $("#menubox").fadeOut();
 *            $(this).fadeOut();
 *            $("html,body").removeAttr("style");
 *        });
 *
 *       //调用这个插件
 *       $('#goToTop').goToTop();
 * });
 * $(".fadein2").click(function(){
 * 	var t = $(window).scrollTop();
 * 	var h = $(window).height();
 * 	$('body,html').animate({'scrollTop':t+h},400)
 * })
 *
 * //编写jQuery的回到页面顶部的插件
 * jQuery.fn.goToTop = function(){
 *     if($(window).scrollTop() < 1) {
 *         $("#goToTop").hide();//滚动条距离顶端的距离小于showDistance是隐藏goToTop按钮
 *     }
 *     $(window).scroll(function(){
 *             if($(this).scrollTop()>1){
 *                 $("#goToTop").fadeIn();
 *             } else {
 *                 $("#goToTop").fadeOut();
 *             }
 *         });
 *      //给这个按钮绑定一个单击事件
 *     this.bind('click',function(){
 *         $('html,body').animate({scrollTop:0},'slow');
 *         return false;
 *     });
 * }
 * </script>
 * </html><script type="text/javascript">
 * $(document).keyup(function(event){
 *   if(event.keyCode ==13 && $("#verifyCode").val().length == 4 ) $('form').submit();
 * });
 * </script>
 *
 *
 */
public class Demo01_response {
}
