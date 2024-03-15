<%--
  Created by IntelliJ IDEA.
  User: paccy
  Date: 3/13/24
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>Create New User</h2>

<form action="register" method="post">
    <div class="mb-3">
        <label for="firstName" class="form-label">firstName</label>
        <input type="text" class="form-control" id="firstName" name="firstName">

    </div>
    <div class="mb-3">
        <label for="lastName" class="form-label">lastName</label>
        <input type="text" class="form-control" id="lastName" name="lastName">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email">
    </div>

    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>

    <div class="mb-3">
        <label for="age" class="form-label">Age</label>
        <input type="number" class="form-control" id="age" name="age">
    </div>
    <div class="mb-3">
        <label for="institution" class="form-label">Your Institution</label>
        <input type="text" class="form-control" id="institution" name="institution">
    </div>

    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <p>Already have an account <a href="login">LOGIN</a></p>
</form>
</body>
</html>
