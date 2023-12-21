<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Edit</title>
</head>
<body>
    <h1>Employee Edit</h1>

    <form action="/rr/update" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${employeeResponseDTO.id}"/>
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" value="${employeeResponseDTO.firstName}" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" value="${employeeResponseDTO.lastName}" required><br>

        <label for="salary">Salary:</label>
        <input type="number" name="salary" value="${employeeResponseDTO.salary}" required><br>

        <label for="department">Department:</label>
        <input type="text" name="department" value="${employeeResponseDTO.department}" required><br>

        <label for="position">Position:</label>
        <input type="text" name="position" value="${employeeResponseDTO.position}" required><br>

        <label for="email">Email:</label>
        <input type="email" name="emailId" value="${employeeResponseDTO.emailId}" required><br>

        <label for="mobile">Mobile:</label>
        <input type="number" name="contactNumber" value="${employeeResponseDTO.contactNumber}" required><br>

        <button type="submit">Update</button>
    </form>
</body>
</html>
