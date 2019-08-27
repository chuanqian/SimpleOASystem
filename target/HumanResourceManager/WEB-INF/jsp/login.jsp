<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>xxxx系统</title>
		<!--引入样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
		<link href="${pageContext.request.contextPath}/css/icon.css" type="text/css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet" />

		<!--导入jquery和easyui-->
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

	</head>

	<body class="imgbody">
		<h1 class="myTitle">人力资源管理系统</h1>
		<div id="login" class="easyui-window" title="用户登录" style="padding: 35px; width: 400px; height: 270px;">
			<div style="text-align: center; padding: 5px;">
				<form action="login.login" method="post" id="myForm">
					<div>
						<%--@declare id="username"--%>
						<img src="${pageContext.request.contextPath}/images/user.png" widthe="20" height="20" style="position: relative; top: 5px;" />
						<!--用户登录输入框-->
						<label for="userName">用户名:&nbsp;</label>
						<input class="easyui-textbox" type="text" name="userName" placeholder="请输入用户名"></input>
					</div>
					<br />
					<div>
						<%--@declare id="userpassword"--%>
						<img src="${pageContext.request.contextPath}/images/pwd.png" widthe="20" height="20" style="position: relative; top: 5px;" />
						<!--密码登录输入框-->
						<label for="userPassword">密&nbsp;码:&nbsp;&nbsp;&nbsp; </label>
						<input class="easyui-textbox" name="userPassword" type="password" placeholder="请输入密码" ></input>
					</div>
						<span style="color:red">${error}</span>
					<br/>
					<!--登录按钮-->
					<a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok" onclick="login()">登录</a> &nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" >取消</a>
				</form>
			</div>
		</div>

		<script type="text/javascript">
			/* 登录触发方法 */
			function login() {
				//js的submit提交,myForm
				document.getElementById("myForm").submit();
			}
			
					//窗口的设置
		$('#login').window({
			collapsible:false,//关闭折叠按钮
			maximizable:false,//关闭最大化按钮
			minimizable:false,//关闭最小化按钮
			closable:false
		});
		</script>
	</body>

</html>