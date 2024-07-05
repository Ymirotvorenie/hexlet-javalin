@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        <h1 class="text-body-emphasis">Привет, Хекслет!</h1>
        <p>Javalin + jte</p>

    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
    @endif
    `,
    footer = @`
    <a href="/sessions/build">Login</a><br>
    <a href="https://github.com/Ymirotvorenie">тык</a>
    `
)
