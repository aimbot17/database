<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${book.id == null ? 'Add' : 'Edit'} Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">${book.id == null ? 'Add New' : 'Edit'} Book</h1>
        
        <form action="${book.id == null ? '/books' : '/books/update'}" method="post">
            <input type="hidden" name="id" value="${book.id}" />
            
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${book.title}" required>
            </div>
            
            <div class="mb-3">
                <label for="isbn" class="form-label">ISBN</label>
                <input type="text" class="form-control" id="isbn" name="isbn" value="${book.isbn}" required>
            </div>
            
            <div class="mb-3">
                <label for="publicationYear" class="form-label">Publication Year</label>
                <input type="number" class="form-control" id="publicationYear" name="publicationYear" value="${book.publicationYear}">
            </div>
            
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="number" step="0.01" class="form-control" id="price" name="price" value="${book.price}">
            </div>
            
            <div class="mb-3">
                <label for="author" class="form-label">Author</label>
                <select class="form-select" id="author" name="author.id" required>
                    <option value="">Select an author</option>
                    <c:forEach items="${authors}" var="author">
                        <option value="${author.id}" ${book.author != null && book.author.id == author.id ? 'selected' : ''}>${author.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/books" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html> 