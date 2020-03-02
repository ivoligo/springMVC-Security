<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Страница пользователя</title>
</head>
<body>

<%--    <jsp:useBean id="user" scope="session" />--%>
<%--    <c:set var="user" value="${user}"/>--%>

<%--<c:url value="/user" var="var"/>--%>
id = ${user.id}
</table>

<table>
    <tr>
        <td><label>Имя</label></td>
        <td><input required type="text" name="name" value="${user.name}"></td>
    </tr>
    <tr>
        <td><label>Фамилия</label></td>
        <td><input required type="text" name="surname" value="${user.surname}"></td>
    </tr>
    <tr>
        <td>email/login</td>
        <td><input required type="email" name="email"  value="${user.email}" placeholder="email, она же логин"></td>
    </tr>
    <tr>
        <td>Пароль</td>
        <td><input required type="password" name="password" value="${user.password}"></td>
    </tr>
    <tr>
        <td>Город</td>
        <td><input required type="text" name="city"  value="${user.city}"></td>
    </tr>
    <tr>
        <td>Возраст</td>
        <td><input required type="number" name="age"  value="${user.age}"></td>
    </tr>
    <tr>
        <td>Роли </td>
        <td>
            <c:forEach items = "${user.roleSet}" var = "role">
                ${role.rolesName}
            </c:forEach>
        </td>
    </tr>
</table>
<br>
<a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>
