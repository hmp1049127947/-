<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事登录-登录</title>
<!-- CSS:写前端，如果不是专业的，那就用框架，我们这个项目用了：easyUI框架，其他框架还有：bootstrap -->
<link rel="stylesheet" href="static/login_style/css/supersized.css">
<link rel="stylesheet" href="static/login_style/css/login.css">
<script src="static/login_style/jquery.min.js"></script>
</head>
<body>

	<div id="div_login">
		<p>人事管理Hrm系统</p>
		<div id="div_form">
			<img src="static/login_style/img/logo2.jpg" alt="找不到图片">
			<form action="/login" method="post">
				<table >
					<tr>
						<td class="td1"><img src="static/login_style/img/ic_member.png" alt=""
							style="width: 16px; text-align: right"></td>
						<td><input type="text" name="number" style="height:33px"></td>
					</tr>
					<tr>
						<td class="td1"><img src="static/login_style/img/psw.png" alt=""
							style="width: 16px;"></td>
						<td><input type="password" name="password" style="height:33px"></td>
					</tr>
					<tr style="background-color: inherit">

						<td colspan="2">
							<div>
								<input id="input_submit" type="submit" value="登录" style="width:260px;height:33px">
							</div>
						</td>

					</tr>

				</table>
			</form>
		</div>
	</div>
	<!-- Javascript -->
	<script src="static/login_style/js/supersized.3.2.7.min.js"></script>
	<script src="static/login_style/js/supersized-init.js"></script>

</body>

</html>