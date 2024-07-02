@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        <h1 class="text-body-emphasis">Привет, Хекслет!</h1>
        <p>Javalin + jte</p>

        @if(!page.isVisited())
            Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
        @endif
    `,
    footer = @`
    <a href="https://github.com/Ymirotvorenie">тык</a>
    `
)
