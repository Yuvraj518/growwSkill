<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Listing</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
    <h2>Employee Listing</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Salary</th>
                <th>Department</th>
                <th>Position</th>
                <th>Email Address</th>
                <th>Contact Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${getAllEmployees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.department}</td>
                    <td>${employee.position}</td>
                    <td>${employee.emailId}</td>
                    <td>${employee.contactNumber}</td>
                    <td>
                        <a href="<c:url value='/rr/edit/' />${employee.id}">Edit</a>
                        |
                        <a href="<c:url value='/rr/delete/' />${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <button><a href="/rr/registration"> Go to registration Page</a></button>
        <button><a href="/rr/filtration"> Go to Filtration Page</a></button>

</body>
</html>
