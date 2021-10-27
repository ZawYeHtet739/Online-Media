<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <h1 class="text-info text-center mb-3">Post Edit Page</h1>
    <form:form method="post" modelAttribute="post" action="/post/edit" enctype="multipart/form-data">

        <form:input name="id" value="${post.id}" type="hidden" path="id"/>
        <form:input name="user_id" value="${post.user_id}" type="hidden" path="user_id"/>
        <form:input name="image" value="${post.image}" type="hidden" path="image"/>

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
            <form:input type="text" class="form-control" id="title" name="title" value="${post.title}" path="title"/>
        </div>

        <div class="form-group">
            <label for="file">Post Image</label>
            <form:input type="file" class="form-control-file" id="file" name="file" path="file"/>
        </div>

        <div class="form-group">
            <label for="content">Content</label>
            <form:textarea class="form-control" id="content" name="content" rows="3" path="content"></form:textarea>
        </div>

        <button type="submit" class="btn btn-primary btn-sm">Update</button>

    </form:form>

</div>
