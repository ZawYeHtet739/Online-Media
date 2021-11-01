<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <table class="table table-bordered">
        <thead>
        <tr class="bg-dark text-white">
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a href="/admin/cat/edit/${category.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/admin/cat/delete/${category.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>