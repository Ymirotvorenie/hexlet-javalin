@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <table class="table">
                <thead class="table-light">
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">id</th>
                    <td>${page.getUser().getId()}</td>
                </tr>
                <tr>
                    <th scope="row">Name</th>
                    <td>${page.getUser().getName()}</td>
                </tr>
                <tr>
                    <th scope="row">Last name</th>
                    <td>${page.getUser().getEmail()}</td>
                </tr>
                <tr>
                    <th scope="row">Email</th>
                    <td>${page.getUser().getPassword()}</td>
                </tr>
                </tbody>
            </table>
        </main>
    </div>
    `
)
