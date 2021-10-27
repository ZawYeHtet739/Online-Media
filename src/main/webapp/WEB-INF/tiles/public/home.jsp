<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="col-md-3 mb-3">
                <div class="card">
                    <img src="/assets/imgs/${post.image}" class="card-img-top" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.content}</p>
                        <a href="/post/${post.id}" class="btn btn-primary btn-sm float-right">Detail</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>