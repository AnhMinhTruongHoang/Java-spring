<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <!-- <link href="/css/demo.css" rel="stylesheet"> -->

        </head>

        <body>
          <div class="container mt-5">
                <div class="d-flex justify-content-between">
                    <h2>User List</h2>
                    <a href="user/create" class="btn btn-success">Create New user</a>
                </div>
                <table class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th scope="col">id</th>
                        <th scope="col">email</th>
                        <th scope="col">fullName</th>
                        <th scope="col">action</th>
                       
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td><button class="btn btn-info">view</button> <button class="btn btn-warning">update</button> <button class="btn btn-danger">delete</button></td>
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td><button class="btn btn-info">view</button> <button class="btn btn-warning">update</button> <button class="btn btn-danger">delete</button></td>
                      </tr>
                    </tbody>
                  </table>
            </body>
          </div>

        </html>