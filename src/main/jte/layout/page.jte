@import gg.jte.Content
@param Content content
@param Content footer = null

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <div>
            <p>Educational center Hexlet</p>
            <a href="/courses">Programming courses</a>
        </div>
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
