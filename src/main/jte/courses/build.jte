@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(content = @`

        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>

        @endif

<form action="${NamedRoutes.coursesPath()}" method="post">
    <div>
        <label>Course name
            <input type="text" name="name" class="form-control" value="${page.getName()}"/>
        </label>
    </div>
    <div>
        <label>Description
            <input type="text" name="desc" class="form-control" value="${page.getDesc()}"/>
        </label>
    </div>

    <input type="submit" value="Add course" class="btn btn-primary"/>
</form>
`)