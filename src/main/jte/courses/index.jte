@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    basePage = page,
    content = @`
    <form action="${NamedRoutes.buildCoursePath()}" method="get">
        <br><br>
        <input type="submit" value="Create new course">
        <br><br>
    </form>
    <form action="${NamedRoutes.coursesPath()}" method="get">
        <label>Course name
            <input type="search" required name="term" value="${page.getParam("term")}">
        </label>&nbsp;
        <input type="submit" value="Искать">
        <br><br>
    </form>

    <form action="${NamedRoutes.coursesPath()}" method="get">
        <label>Course description
            <input type="search" required name="desc" value="${page.getParam("desc")}">
        </label>
        <input type="submit" value="Искать">
        <br><br>
    </form>

    <h1>${page.getHeader()}</h1>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page.getCourses())
                <div>
                    <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
    `,
    footer = @`
        <div>          </div>
        <p>its footer</p>
    `
)

