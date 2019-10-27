<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/16
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zxx">

<head>
    <title>人事管理系统登录</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="Validate Login & Register Forms Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tag Keywords -->

    <!-- css files -->
    <link rel="stylesheet" href="static/login/css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="static/login/css/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->

</head>

<body>
<main>
    <!-- content -->
    <div class="container-agille">
        <div class="formBox level-login">
            <div class="box boxShaddow"></div>
            <div class="box loginBox">
                <h3>请登录</h3>
                <form class="form" action="/login" method="post">
                    <div class="f_row-2">
                        <input type="text" class="input-field" placeholder="请输入账号" name="number" required>
                    </div>
                    <div class="f_row-2 last">
                        <input type="password" name="password" placeholder="请输入密码" class="input-field" required>
                    </div>
                    <div class="f_row-2 last">
                        <input type="checkbox" name="remember" style="width: 14px;height: 14px;float: left" >
                        <label style="float: left;color: #999999;font-size: 14px">七天免登陆</label>
                        <a href="" class="resetTag" style="float: right;color: #999999;font-size: 14px">忘记密码?</a>
                    </div>
                    <input class="submit-w3" type="submit" value="确定登录">

                </form>
            </div>
            <div class="box forgetbox agile">
                <a href="#" class="back icon-back">
                    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                         viewBox="0 0 199.404 199.404" style="enable-background:new 0 0 199.404 199.404;" xml:space="preserve">
						<polygon points="199.404,81.529 74.742,81.529 127.987,28.285 99.701,0 0,99.702 99.701,199.404 127.987,171.119 74.742,117.876
			  199.404,117.876 " />
					</svg>
                </a>
                <h3>重置密码</h3>
                <form class="form" action="#" method="post">
                    <input type="text" name="number" placeholder="用户账号" class="input-field" required>
                    <input type="email" name="email" placeholder="邮箱地址" class="input-field" required>
                    <input type="password" name="password" placeholder="新的密码" class="input-field" required>
                    <input type="password" name="password" placeholder="确认密码" class="input-field" required>
                    <input class="submit-w3" style="background-color: white;color: red" type="submit" value="确定重置">
                </form>
            </div>
            <div class="box registerBox wthree">
                <span class="reg_bg"></span>
                <h3>请注册</h3>
                <form class="form" action="/register" method="post">
                    <div class="f_row-2">
                        <input type="text" class="input-field" placeholder="账号" name="number" required>
                    </div>
                    <div class="f_row-2 last">
                        <input type="password" name="password" placeholder="密码" id="password1" class="input-field" required>
                    </div>
                    <div class="f_row-2 last">
                        <input type="password" name="password2" placeholder="确定密码" id="password2" class="input-field" required>
                    </div>
                    <div class="f_row-2">
                        <input type="text" class="input-field" placeholder="手机号" name="phone" required>
                    </div>
                    <input class="submit-w3" type="submit" value="确定注册">
                </form>
            </div>
            <a href="#" class="regTag icon-add">
                <i class="fa fa-repeat" aria-hidden="true"></i>

            </a>
        </div>
    </div>
    <!-- //content -->
</main>

<!-- copyright -->
<footer>
    <div style="text-align: right;margin: 2vw 2vw; color: #fff;">
        <h2>&copy copyright 2019 wyu160802 | Design by
            <a href="#" style="color: blue">hmp</a>
        </h2>
    </div>
</footer>
<!-- //copyright -->


<!-- js files -->
<!-- Jquery -->
<script src="static/login/js/jquery-2.2.3.min.js"></script>
<!-- //Jquery -->
<!-- input fields js -->
<script src="static/login/js/input-field.js"></script>
<!-- //input fields js -->

<!-- password-script -->
<script>
    window.onload = function () {
        var login_info = '${baseResult.message}';
        console.log(login_info);
        if (login_info!='') {
            alert(login_info)
        }
        document.getElementById("password1").onchange = validatePassword;
        document.getElementById("password2").onchange = validatePassword;
    }

    function validatePassword() {
        var pass2 = document.getElementById("password2").value;
        var pass1 = document.getElementById("password1").value;
        if (pass1 != pass2)
            document.getElementById("password2").setCustomValidity("两次密码不一致");
        else
            document.getElementById("password2").setCustomValidity('');
        //empty string means no validation error
    }
</script>
<!-- //password-script -->
<!-- //js files -->
</body>

</html>
