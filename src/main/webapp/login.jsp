<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户登录</title>
    <style type="text/css">
        body{
            line-height:30px;
        }
        form {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f7f7f7;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<form method="post" action="UserLogin" >
    <h1>用户登录</h1>
    请输入用户名：<input type="text" name="name" size="15" /><br/>
    请输入密码：<input type="password" name="pwd" size="15" /><br/>
    <input type="submit" name="submit" value="登录"/>
</form>
</body>
</html>