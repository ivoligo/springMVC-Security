
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form method="post" action="/login">
        <small>Логин:</small>
        <br>
        <input required type="email" name="j_username" placeholder="Введите email"/>
        <br>
        <small>Пароль:</small>
        <br>
        <input required type="password" name="j_password" placeholder="Введите Пароль"/>
        <br>
        <input type="submit" value="Let's go"/>
    </form>

</body>
</html>
