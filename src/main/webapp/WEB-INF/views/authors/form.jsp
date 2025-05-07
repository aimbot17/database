<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>${author.id == null ? 'Add' : 'Edit'} Author</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h1 class="mb-4">${author.id == null ? 'Add New' : 'Edit'} Author</h1>

      <form
        action="${author.id == null ? '/authors' : '/authors/update'}"
        method="post"
      >
        <input type="hidden" name="id" value="${author.id}" />

        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            name="name"
            value="${author.name}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input
            type="email"
            class="form-control"
            id="email"
            name="email"
            value="${author.email}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="biography" class="form-label">Biography</label>
          <textarea
            class="form-control"
            id="biography"
            name="biography"
            rows="3"
          >
${author.biography}</textarea
          >
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/authors" class="btn btn-secondary">Cancel</a>
      </form>
    </div>
  </body>
</html>
