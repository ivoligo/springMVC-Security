
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
    <table border="2">
        <tr>
            <th>id</th>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Город</th>
            <th>Возраст</th>
            <th>Роль</th>
            <th>Действие</th>
        </tr>
        <c:forEach items = "${users}" var = "user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.city}</td>
                <td>${user.age}</td>
                <td>
                        <c:forEach items = "${user.roleSet}" var = "role">
                            ${role.rolesName}
                        </c:forEach>
                </td>
                <td>
                    <form action="/admin/edit/${user.id}" method="get">
                        <input type="submit" value="изменить">
                    </form>
                    <form action="/admin/delete/${user.id}" method = "get">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action = "/admin/add">
        <input type="submit" value="добавить пользователя">
    </form>

    <a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>
