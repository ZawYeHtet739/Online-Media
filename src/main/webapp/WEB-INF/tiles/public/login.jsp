<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <h1 class="text-info text-center">Login to Post</h1>

    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>${error}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${!empty logout}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>${logout}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${!empty  register_success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>${register_success}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <div class="col-md-6 offset-md-3">
        <form action="<c:url value="/j_spring_security_check"/>" method="post">
            <div class="form-group">
                <label for="username">Username : </label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Password : </label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <input type="submit" value="Login" class="btn btn-primary btn-sm float-right">

            <%-- Portect Hack--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        </form>
    </div>
</div>
