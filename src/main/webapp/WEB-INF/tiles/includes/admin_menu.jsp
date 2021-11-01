<div class="container my-2">
    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <div class="btn-group" role="group">
            <button id="btnGroupDrop1" type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Posts
            </button>
            <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <a class="dropdown-item" href="/admin/home">Post All</a>
                <a class="dropdown-item" href="/author/post/create">Post Create</a>
            </div>
        </div>
    </div>
    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <div class="btn-group" role="group">
            <button id="btnGroupDrop2" type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Categories
            </button>
            <div class="dropdown-menu" aria-labelledby="btnGroupDrop2">
                <a class="dropdown-item" href="/admin/cat/all">Category All</a>
                <a class="dropdown-item" href="/admin/cat/create">Category Create</a>
            </div>
        </div>
    </div>
    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <div class="btn-group" role="group">
            <button id="btnGroupDrop3" type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Users
            </button>
            <div class="dropdown-menu" aria-labelledby="btnGroupDrop3">
                <a class="dropdown-item" href="/admin/user/all">User All</a>
            </div>
        </div>
    </div>
</div>