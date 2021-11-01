<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <h1 class="text-info text-center">Register to Post</h1>

    <div class="col-md-6 offset-md-3">
        <form:form action="/register" method="post" modelAttribute="user">
            <div class="form-group">
                <label for="username">Username : </label>
                <form:input type="text" name="username" id="username" class="form-control" path="username"/>
                <form:errors path="username" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <label for="email">Email : </label>
                <form:input type="email" name="email" id="email" class="form-control" path="email"/>
                <form:errors path="email" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <label for="password">Password : </label>
                <form:input type="password" name="password" id="password" class="form-control" path="password"/>
                <form:errors path="password" class="text-danger"></form:errors>
            </div>
            <input type="submit" value="Register" class="btn btn-primary btn-sm float-right">

            <%-- Portect Hack--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        </form:form>
    </div>
</div>
