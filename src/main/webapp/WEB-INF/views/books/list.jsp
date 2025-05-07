<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Books List</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h1 class="mb-4">Books List</h1>

      <a href="/books/new" class="btn btn-primary mb-3">Add New Book</a>
      <a href="/" class="btn btn-secondary mb-3 ms-2">Back to Home</a>

      <table class="table table-striped table-bordered">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Publication Year</th>
            <th>Price</th>
            <th>Author</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${books}" var="book">
            <tr>
              <td>${book.id}</td>
              <td>${book.title}</td>
              <td>${book.isbn}</td>
              <td>${book.publicationYear}</td>
              <td>$${book.price}</td>
              <td>${book.author.name}</td>
              <td>
                <a href="/books/edit/${book.id}" class="btn btn-warning btn-sm"
                  >Edit</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
