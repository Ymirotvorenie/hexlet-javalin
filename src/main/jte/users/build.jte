@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

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
    <form action="${NamedRoutes.usersPath()}" method="post">
        <div>
            <label for="nameInput">Name
                <input type="text" name="name" id="nameInput" class="form-control"/>
            </label>
        </div>
        <div>
            <label for="emailInput">Email
                <input type="text" name="email" id="emailInput" class="form-control"/>
            </label>
        </div>
        <div>
            <label for="passInput">Password
                <input type="text" name="password" id="passInput" class="form-control"/>
            </label>
        </div>
        <div>
            <label for="passConfirmInput">Repeat Password
                <input type="text" name="passwordConfirmation" id="passConfirmInput" class="form-control"/>
            </label>
        </div>
        <input type="submit" value="Registration" class="btn btn-primary"/>
    </form>

    `)
