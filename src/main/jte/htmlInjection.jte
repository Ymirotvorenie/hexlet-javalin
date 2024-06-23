@import org.example.hexlet.dto.html.HtmlPage
@param HtmlPage page

@template.layout.page(
    content = @`
        ${page.getCode()}
    `
)
