<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../../chapter8/css/styles.css"/>
    <title>用户注册</title>
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
<form method="post" action="RegistToDb" >
    请输入用户名：<input type="text" name="name" size="15" /><br/>
    &nbsp;&nbsp;请输入密码：<input type="password" name="pwd" size="15" /><br/>
    &nbsp;&nbsp;二次输入密码：<input type="password" name="pwd2" size="15" /><br/>
    <input type="submit" name="submit" value="注册"/>
</form>
</body>
</html>