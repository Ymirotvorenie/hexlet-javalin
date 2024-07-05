@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.BasePage
@param Content content
@param Content footer = null
@param BasePage basePage = null

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap-table@1.22.6/dist/bootstrap-table.min.js"></script>
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <div class="mb-3">
            <p>Educational center Hexlet</p>
            <a href="${NamedRoutes.coursesPath()}">Programming courses</a>
        </div>
        <div class="mb-3">
            <p>Hexlet Users</p>
            <a href="${NamedRoutes.usersPath()}">Users</a>
        </div>

            @if(basePage != null && basePage.getFlash() != null)
                <div class="alert alert-${basePage.getVariant()}" role="alert">
                    <p>${basePage.getFlash()}</p>
                </div>
            @endif

        ${content}

        <div>
            @if(footer != null)
            <div class="footer">
                ${footer}
            </div>
            @endif
        </div>
    </body>
</html>
