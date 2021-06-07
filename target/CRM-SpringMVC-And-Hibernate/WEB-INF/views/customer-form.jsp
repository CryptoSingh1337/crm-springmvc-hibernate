<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by CryptoSingh1337 on 6/1/2021
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/images/favicon.png" rel="icon">
</head>
<body>
    <div id="addForm">
        <div class="bg-secondary bg-gradient">
            <div class="text-center">
                <h1 class="pt-3 pb-3">CRM - Save Customer</h1>
            </div>
        </div>
        <form:form class="form-container" action="/customer/save" method="POST" modelAttribute="customer">
            <form:hidden path="id"/>
            <div class="input-group mb-3 me-5">
                <span class="input-group-text" id="basic-addon1">First Name</span>
                <form:input type="text" cssClass="form-control" name="firstName" path="firstName"/>
                <form:errors cssClass="error ps-5" path="firstName"/>
            </div>
            <div class="input-group mb-3 me-5">
                <span class="input-group-text" id="basic-addon2">Last Name</span>
                <form:input type="text" cssClass="form-control" name="lastName" path="lastName"/>
                <form:errors cssClass="error ps-5" path="lastName"/>
            </div>
            <div class="input-group mb-3 me-5">
                <span class="input-group-text" id="basic-addon3">Email</span>
                <form:input type="email" cssClass="form-control" name="email" path="email"/>
                <form:errors cssClass="error ps-5" path="email"/>
            </div>
            <input type="submit" class="btn btn-primary" value="Save">
            <a class="ms-5" href="/customer/list">Back to list</a>
        </form:form>
    </div>
</body>
</html>
