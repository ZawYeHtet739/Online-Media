<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <table class="table table-bordered">
        <thead>
        <tr class="bg-dark text-white">
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>
                    <c:if test="${user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-danger btn-sm">Ban</a>
                    </c:if>
                    <c:if test="${!user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-dark btn-sm">Active</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>