<%--
  Created by IntelliJ IDEA.
  User: paccy
  Date: 3/13/24
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Add New Book</title>
</head>
<body>

<form action="add-book" method="post">
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="name">Book Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Book Name" >
        </div>
        <div class="col-md-4 mb-3">
            <label for="authorName">Author's Names</label>
            <input type="text" class="form-control" id="authorName" name="author" placeholder="Book Author's names" >
        </div>

    </div>

    <div class="form-row">
        <div class="col-md-6 mb-3">
            <label for="yearOfPublication">Year Of Publication</label>
            <input type="text" class="form-control" id="yearOfPublication" name="year_of_publication" placeholder="Year Of Publication" >
        </div>
        <div class="col-md-3 mb-3">
            <label for="category">Category</label>
            <input type="text" class="form-control" id="category" name="category" placeholder="Book Category" >
        </div>

    </div>
    <button class="btn btn-primary" type="submit">Add Book</button>
</form>
</body>
</html>
