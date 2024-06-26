package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,4,4,5,5,7,7,8,8,9,9,9,10,10,11,11,13,13,14,14,14,14,14,14,14,14,14,38,38,38,39,39,39,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <ul>\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\n                    <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                ");
						}
						jteOutput.writeContent("\n            ");
					}
					jteOutput.writeContent("\n        </ul>\n    ");
				}
				jteOutput.writeContent("\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n        <div>\n            <label for=\"nameInput\">Name\n                <input type=\"text\" name=\"name\" id=\"nameInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"emailInput\">Email\n                <input type=\"text\" name=\"email\" id=\"emailInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"passInput\">Password\n                <input type=\"text\" name=\"password\" id=\"passInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <div>\n            <label for=\"passConfirmInput\">Repeat Password\n                <input type=\"text\" name=\"passwordConfirmation\" id=\"passConfirmInput\" class=\"form-control\"/>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Registration\" class=\"btn btn-primary\"/>\n    </form>\n\n    ");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
