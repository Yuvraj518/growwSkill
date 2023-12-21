<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration</h2>

    <form action="/rr/add" method="post" enctype="multipart/form-data">
        <label for="first_name">First Name:</label>
        <input type="text" name="firstName" required><br>

        <label for="last_name">Last Name:</label>
        <input type="text"  name="lastName" required><br>

        <label for="salary">Salary:</label>
        <input type="number" name="salary" required><br>

        <label for="department">Department:</label>
        <input type="text"  name="department" required><br>

        <label for="position">Position:</label>
        <input type="text"  name="position" required><br>

        <label for="email_id">Email Id:</label>
        <input type="email" name="emailId" required><br>

        <label for="contact_number">Contact Number:</label>
        <input type="number" name="contactNumber" required><br>

        <label for="picture">Picture:</label>
        <input type="file"  name="picture"><br>

        <input style="margin-top:15px" type="submit" value="Register">
    </form>
    <button style="margin:10px;"><a href="/rr/all">Show list of Employees</a></button>
</body>
</html>