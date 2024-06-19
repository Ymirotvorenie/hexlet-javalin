@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    content = @`
        <h1>${page.getHeader()}</h1>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page.getCourses())
                <div>
                    <h2><a href="/courses/${course.getId()}"></a>${course.getName()}</h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
    `,
    footer = @`
        <p>its footer</p>
    `
)

