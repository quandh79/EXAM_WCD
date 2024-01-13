<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Employee List</h1>
    <a href="/employee" class="btn btn-primary mb-3">Create Employee</a>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Position</th>
            <th>Department</th>
        </tr>

        <c:forEach items="${employeeList}" var="employee">
            <tr style="text-align: center">
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td>
                    <fmt:formatDate value="${employee.birthday}" pattern="dd-MM-yyyy"/>
                </td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:out value="${employee.position}"/></td>
                <td><c:out value="${employee.department}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- Add Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
