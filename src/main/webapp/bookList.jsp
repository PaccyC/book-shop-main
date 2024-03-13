<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.paccy.bookshop.models.Book" %>
<html>
<head>
  <title>Book List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<table class="table">
  <thead class="thead-dark">
  <tr>
    <th scope="col">id</th>
    <th scope="col">name</th>
    <th scope="col">Author Name</th>
    <th scope="col">Year Of Publication</th>
    <th scope="col">Category</th>
    <th scope="col">ACTION</th>
  </tr>
  </thead>
  <tbody>
  <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
  <% for (Book book : books) { %>
  <tr>
    <th scope="row"><%= book.getId() %></th>
    <td><%= book.getName() %></td>
    <td><%= book.getAuthor() %></td>
    <td><%= book.getYear_of_publication() %></td>
    <td><%= book.getCategory() %></td>

    <td>
      <form action="deleteBook" method="post">
        <input type="hidden" name="id" value="<%= book.getId() %>">
        <button type="submit" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
          <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
          <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
        </svg></button>
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>

</body>
</html>
