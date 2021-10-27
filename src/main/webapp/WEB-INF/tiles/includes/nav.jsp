<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid bg-dark">
    <nav class="container navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="/">
            <img src="/assets/imgs/coder.png" alt="" width="30" height="30" class="rounded">
            <span class="text-white ml-3">Online Media</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">

                <c:forEach var="cat" items="${categories}">
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="/cat/${cat.id}">${cat.name}</a>
                    </li>
                </c:forEach>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Member
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test="${!pageContext.request.userPrincipal.authenticated}">
                            <a class="dropdown-item" href="/login">Login</a>
                            <a class="dropdown-item" href="/register">Register</a>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.authenticated}">
                        <c:url var="logoutUrl" value="/logout"></c:url>
                        <form action="${logoutUrl}" method="post">
                            <input type="submit" value="logout" class="btn btn-default ml-2">
                                <%-- Portect Hack--%>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </form>
                    </div>
                    </c:if>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Member
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contact">Contact</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/cat/all">Show All Categories</a>
                        <a class="dropdown-item" href="/admin/user/all">Show All Users</a>
                    </div>
                </li>

            </ul>
        </div>
    </nav>
</div>