
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>LOGIN USER</h2>
<form action="login" method="post">

    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email">

    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>

    <input type="submit" class="btn btn-primary" value="LOGIN"><br><br>
</form>

<p>Don't have an account ? <a href="register">Register</a></p>
</body>
</html>
