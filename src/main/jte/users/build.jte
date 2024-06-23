@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="post">
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
                    <input type="text" name="pass" id="passInput" class="form-control"/>
                </label>
            </div>
            <div>
                <label for="passConfirmInput">Repeat Password
                    <input type="text" name="passConfirm" id="passConfirmInput" class="form-control"/>
                </label>
            </div>
            <input type="submit" value="Registration" class="btn btn-primary"/>
        </form>

    <div class="mx-auto p-4 py-md-5">
        <main>
            <table class="table caption-top">
                <caption>Hexlet Users</caption>
                <thead class="table-light">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Password</th>
                    <th scope="col">Profile</th>
                </tr>
                </thead>
                <tbody>
                @if(page.getUsers().isEmpty())
                    <tr>
                        <th scope="row">-</th>
                        <td>not found</td>
                        <td>not found</td>
                        <td>not found</td>
                    </tr>
                @else
                    @for(var user : page.getUsers())
                        <tr>
                            <th scope="row">${user.getId()}</th>
                            <td>${user.getName()}</td>
                            <td>${user.getEmail()}</td>
                            <td>${user.getPassword()}</td>
                            <td><a href="/users/${user.getId()}">View profile</a></td>
                        </tr>
                    @endfor
                @endif
                </tbody>
            </table>
        </main>
    </div>
    `
)