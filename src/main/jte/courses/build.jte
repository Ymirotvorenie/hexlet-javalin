@template.layout.page(content = @`
<form action="/courses/build" method="post">
    <div>
        <label for="nameInput">Course name
            <input type="text" name="name" id="nameInput" class="form-control"/>
        </label>
    </div>
    <div>
        <label for="descInput">Email
            <input type="text" name="desc" id="descInput" class="form-control"/>
        </label>
    </div>

    <input type="submit" value="Add course" class="btn btn-primary"/>
</form>
`)