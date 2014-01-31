<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>
<h1>User database</h1>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Password</td>
    </tr>
    <c:forEach var="user" items="${userCollection}">
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>