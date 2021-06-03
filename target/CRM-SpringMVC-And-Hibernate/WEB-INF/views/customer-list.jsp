<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.saransh.utils.SortUtils" %>
<%--
  Created by CryptoSingh1337 on 6/1/2021
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/images/favicon.png" rel="icon">
</head>
<body>
    <div class="bg-secondary bg-gradient">
        <div class="text-center">
            <h1 class="pt-3">CRM - Customers List</h1>
        </div>
        <div class="container p-3">
            <a class="btn btn-lg btn-dark" href="/customer/add">Add Customer</a>
        </div>
    </div>
    <div class="container mt-5">
        <c:choose>
            <c:when test="${customers.size() > 0}">
                <form class="form-container d-flex mb-5" action="/customer/search" method="GET">
                    <input type="text" class="form-control" name="search" placeholder="Search" value="${search}" required>
                    <input type="submit" class="btn btn-primary ms-5" value="Search">
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"><a href="/customer/list?sortBy=${SortUtils.SortByFirstName.value}">First Name</a></th>
                            <th scope="col"><a href="/customer/list?sortBy=${SortUtils.SortByLastName.value}">Last Name</a></th>
                            <th scope="col"><a href="/customer/list?sortBy=${SortUtils.SortByEmail.value}">Email</a></th>
                            <th scope="col">Update / Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td>${customer.firstName}</td>
                                <td>${customer.lastName}</td>
                                <td>${customer.email}</td>
                                <td><a href="/customer/update?id=${customer.id}">Update</a> | <a class="delete" href="/customer/delete?id=${customer.id}" onclick="return confirm('Do you really want to delete this?')">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h3 class="text-center">No record exists!</h3>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
