<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Authors List</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h1 class="mb-4">Authors List</h1>

      <a href="/authors/new" class="btn btn-primary mb-3">Add New Author</a>
      <a href="/" class="btn btn-secondary mb-3 ms-2">Back to Home</a>

      <table class="table table-striped table-bordered">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Biography</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${authors}" var="author">
            <tr>
              <td>${author.id}</td>
              <td>${author.name}</td>
              <td>${author.email}</td>
              <td>${author.biography}</td>
              <td>
                <a
                  href="/authors/edit/${author.id}"
                  class="btn btn-warning btn-sm"
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
