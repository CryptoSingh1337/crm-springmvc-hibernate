<%--
  Created by CryptoSingh1337 on 5/31/2021
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/images/favicon.png" rel="icon">
</head>
<body>
    <div id="main">
        <img id="favicon" src="${pageContext.request.contextPath}/assets/images/favicon.png" alt="favicon"/>
        <h1 class="index-heading">Welcome</h1>
        <h2>TO</h2>
        <h2>CRM - Customer Relationship Management</h2>
        <h2>Project</h2>
        <h3 class="stack">Created using <span class="badge bg-secondary">Spring MVC</span> and <span class="badge bg-secondary">Hibernate</span></h3>
        <a href="/customer/list" class="btn btn-primary btn-lg mt-5">See Customer List</a>
    </div>
</body>
</html>
