<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <a href="/post/create" class="btn btn-primary btn-sm mb-3">Create <i class="fa fa-plus"></i></a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Category</th>
            <th scope="col">Image</th>
            <th scope="col">Content</th>
            <th scope="col">Date</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.id}</td>
                <td>${post.title}</td>
                <td>${post.user.username}</td>
                <td>${post.category.name}</td>
                <td>
                    <img src="/assets/imgs/${post.image}" alt="${post.image}" width="50" height="50">
                </td>
                <td>${post.content}</td>
                <td>${post.created_at}</td>
                <td>
                    <a href="/post/edit/${post.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/post/delete/${post.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>