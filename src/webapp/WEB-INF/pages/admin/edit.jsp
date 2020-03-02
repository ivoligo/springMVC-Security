<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение пользователя</title>
</head>
<body>
 <c:url value="/admin/edit" var="var"/>
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${user.id}">
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
                <td><input required type="password" name="password"></td>
            </tr>

            <tr>
                <td>Город</td>
                <td><input required type="text" name="city"  value="${user.city}"></td>
            </tr>

            <tr>
                <td>Возраст</td>
                <td><input required type="number" name="age"  value="${user.age}"></td>
            </tr>
<%--<c:forEach items = "${user.roleSet}" var = "role">--%>
<%--</c:forEach>--%>
<%--        <select name = "rolSet" multiple>--%>
            <tr>
                <td>Роли </td>
                <td>
                    <select name = "roleSet" multiple>
                        <c:forEach items = "${user.roleSet}" var = "role">
                            <option style="color:#ff00ff" value="${role.rolesName}" >
                                    ${role.rolesName}
                            </option>
                        </c:forEach>
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                        <option value="otherUser">otherUser</option>
                        <option value="webUser">webUser</option>
                    </select>
                </td>
            </tr>

            <tr></tr>
            <tr>
                <td colspan="2" align="center" ><input type="submit" value="применить"> </td>
                <td></td>
            </tr>
        </table>
    </form>
 <a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>
