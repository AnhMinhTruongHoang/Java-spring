<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User id: ${id}</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
    <div class="container mt-5">
        <div class="text-center mb-3">
            <h2>*</h2>
        </div>

        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th colspan="2" class="text-center">User Information</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><strong>ID</strong></td>
                    <td>${id}</td>
                </tr>
                <tr>
                    <td><strong>Email</strong></td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td><strong>Full Name</strong></td>
                    <td>${user.fullName}</td>
                </tr>
                <tr>
                    <td><strong>Address</strong></td>
                    <td>${user.address}</td>
                </tr>
                <tr>
                    <td><strong>Phone Number</strong></td>
                    <td>${user.phone}</td>
                </tr>
            </tbody>
            
        </table>
       <div style="display: flex; justify-content: center;"> 
        <a href="/admin/user" class="btn btn-success">BACK</a>
      </div>
    </div>
</body>

</html>
