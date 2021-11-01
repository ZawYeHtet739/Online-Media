<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <h1 class="text-info text-center mb-3">Category Edit Page</h1>
    <div class="col-md-6 offset-md-3">

        <form:form action="/admin/cat/edit" method="post" modelAttribute="category">

            <form:input type="hidden" name="id" value="${category.id}" path="id"/>

            <div class="form-group">
                <label for="name">Category Name</label>
                <form:input type="text" class="form-control" id="name" name="name" path="name"
                            value="${category.name}"/>
            </div>
            <button type="submit" class="btn btn-primary btn-sm">Update</button>
        </form:form>
    </div>
</div>
