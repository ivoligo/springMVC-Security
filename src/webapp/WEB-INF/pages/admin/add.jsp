<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
    <form method="post">
        <table>
            <tr>
                <td><label>Имя</label></td>
                <td><input required type="text" name="name" ></td>
            </tr>
            <tr>
                <td><label>Фамилия</label></td>
                <td><input required type="text" name="surname" ></td>
            </tr>
            <tr>
                <td><label>email</label></td>
                <td><input required type="email" name="email" placeholder="email, он же логин"></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input required type="password" name="password"></td>
            </tr>
            <tr>
                <td>Город</td>
                <td><input required type="text" name="city"></td>
            </tr>
            <tr>
                <td>Возраст</td>
                <td><input required type="number" name="age" ></td>
            </tr>
            <tr>
                <td><label>Назначьте роль</label></td>
                <td>
                    <select name = "rolSet" multiple>
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                        <option value="otherUser">otherUser</option>
                        <option value="webUser">webUser</option>
                    </select>
                </td>
            </tr>

<%--       <input required type="text" name="rolesName" placeholder="Роль">--%>
        </table>
      <input type="submit" value="Сохранить">
    </form>
    <a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>
