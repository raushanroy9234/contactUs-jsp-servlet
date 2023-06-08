<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ContactUs Application</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: black;
            padding: 10px;
            color: white;
            text-align: center;
        }

        .container {
            margin: 20px;
        }

        h3 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table th,
        table td {
            padding: 8px;
            border: 1px solid #ccc;
        }

        /* Navbar CSS */
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        nav li {
            float: left;
        }

        nav li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        nav li a:hover {
            background-color: #111;
        }
    </style>
</head>
<body>
<header>
    <div>ContactUs Survey</div>
    <nav>
        <ul>
            <li><a href="#">All Requests</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <h3>List of Requests</h3>
    <hr>
    <div class="container text-left">
    </div>
    <br>

    <!-- Active Users Table -->
    <table>
        <caption>List of Active Users</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Message</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${activeUsers}">
            <form action="dashboard" method="post">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.message}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td>
                        <input type="hidden" name="id" value="${user.id}" />
                        <input type="hidden" name="status" value="Archive" />
                        <button type="submit">Archive</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <caption>List of Inactive Users</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Message</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${inactiveUsers}">
            <form action="dashboard" method="post">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.message}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td>
                        <input type="hidden" name="id" value="${user.id}" />
                        <input type="hidden" name="status" value="Active" />
                        <button type="submit">Activate</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
      
