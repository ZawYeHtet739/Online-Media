<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container my-5">
    <h1 class="text-info text-center mb-3">Category Create Page</h1>
    <div class="col-md-6 offset-md-3">

        <form:form action="/cat/create" method="post" modelAttribute="category">
            <div class="form-group">
                <label for="name">Category Name</label>
                <form:input type="text" class="form-control" id="name" name="name" path="name"/>
            </div>
            <button type="submit" class="btn btn-primary btn-sm">Create</button>
        </form:form>
    </div>
</div>