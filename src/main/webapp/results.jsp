<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <div>
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.userAge}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h2>Single User Search: </h2>
    <div>
        <table border="1" cellpadding="5">
            <caption><h2>User</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
                <tr>
                    <td>${userone.userid}</td>
                    <td>${userone.firstName}</td>
                    <td>${userone.lastName}</td>
                    <td>${userone.userAge}</td>
                </tr>

        </table>
    </div>
</div>

<div><p><a href = "employeeSearch">Back to Search</a></p></div>

</body>
</html>
