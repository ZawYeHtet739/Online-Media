<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container my-5">

    <h1 class="text-info text-center mb-3">Post Create Page</h1>
    <form:form method="post" modelAttribute="post" action="/author/post/create" enctype="multipart/form-data">

        <div class="form-group">
            <label for="cat_id">Category</label>
            <form:select class="form-control" id="cat_id" name="cat_id" path="cat_id">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>

            </form:select>
        </div>
        <div class="form-group">
            <label for="title">Title</label>
            <form:input type="text" class="form-control" id="title" name="title" path="title"/>
            <form:errors path="title" class="text-danger"></form:errors>
        </div>
        <div class="form-group">
            <label for="file">Post Image</label>
            <input type="file" class="form-control-file" id="file" name="file" />
            <form:errors path="file" class="text-danger"></form:errors>

        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <form:textarea class="form-control" type="text" id="content" name="content" rows="3" path="content"/>
            <form:errors path="content" class="text-danger"></form:errors>
        </div>
        <button type="submit" class="btn btn-primary btn-sm">Create</button>
    </form:form>

</div>
