
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
    <form method="post">

        <input required type="text" name="name" placeholder="Имя">
        <input required type="text" name="surname" placeholder="Фамилия">
        <br>
        <input required type="email" name="email" placeholder="email, она же логин">
        <input required type="password" name="password" placeholder="Пароль">
        <br>
        <input required type="text" name="city" placeholder="город">
        <input required type="number" name="age" placeholder="возраст">
            <br>
       <select name = "roleSet">
            <option value="user">user</option>
            <option value="admin">admin</option>
            <option value="otherUser">otherUser</option>
           <option value="webUser">webUser</option>
        </select>
<%--       <input required type="text" name="rolesName" placeholder="Роль">--%>
        <br>
      <input type="submit" value="Сохранить">
    </form>

</body>
</html>
