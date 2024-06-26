package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,7,7,8,8,8,8,8,8,8,8,8,46,46,53,53,54,54,56,56,56,57,57,57,58,58,58,59,59,59,60,60,60,60,60,60,60,60,60,62,62,63,63,68,68,68,68,68,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n        <div>\n            <label for=\"nameInput\">Name\n                <input type=\"text\" name=\"name\" id=\"nameInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"emailInput\">Email\n                <input type=\"text\" name=\"email\" id=\"emailInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"passInput\">Password\n                <input type=\"text\" name=\"password\" id=\"passInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"passConfirmInput\">Repeat Password\n                <input type=\"text\" name=\"passwordConfirmation\" id=\"passConfirmInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Registration\" class=\"btn btn-primary\"/>\n    </form>\n\n    <div class=\"mx-auto p-4 py-md-5\">\n        <main>\n            <table class=\"table caption-top\">\n                <caption>Hexlet Users</caption>\n                <thead class=\"table-light\">\n                <tr>\n                    <th scope=\"col\">id</th>\n                    <th scope=\"col\">Name</th>\n                    <th scope=\"col\">Email</th>\n                    <th scope=\"col\">Password</th>\n                    <th scope=\"col\">Profile</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n                    <tr>\n                        <th scope=\"row\">-</th>\n                        <td>not found</td>\n                        <td>not found</td>\n                        <td>not found</td>\n                    </tr>\n                ");
				} else {
					jteOutput.writeContent("\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr>\n                            <th scope=\"row\">");
						jteOutput.setContext("th", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</th>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getPassword());
						jteOutput.writeContent("</td>\n                            <td><a");
						var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">View profile</a></td>\n                        </tr>\n                    ");
					}
					jteOutput.writeContent("\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </main>\n    </div>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
