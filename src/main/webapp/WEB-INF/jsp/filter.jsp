<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Filter</title>
    <style>
            input {
                position: fixed;
                left:200px;
            }
        </style>
</head>
<body>
    <h2>Employee Filter</h2>

    <form action="/rr/filter" method="post" enctype="multipart/form-data">
        <label for="department">Department:</label>
        <input type="text"  name="department"><br>

        <label for="position">Position:</label>
        <input type="text"  name="position" ><br>

        <label for="paginationLimit">Pagination Limit:</label>
        <input type="number" name="paginationLimit"><br>

        <input style="margin-top:15px" type="submit" value="Filter">
    </form>
    <button style="margin:40px;"><a href="/rr/all">Show list of Employees</a></button>
</body>
</html>