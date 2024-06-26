package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,18,18,18,22,22,22,26,26,26,30,30,30,36,36,36,37,37,37,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"mx-auto p-4 py-md-5\">\n        <main>\n            <table class=\"table\">\n                <thead class=\"table-light\">\n                <tr>\n                    <th scope=\"col\"></th>\n                    <th scope=\"col\"></th>\n                </tr>\n                </thead>\n                <tbody>\n                <tr>\n                    <th scope=\"row\">id</th>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr>\n                    <th scope=\"row\">Name</th>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getName());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr>\n                    <th scope=\"row\">Last name</th>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr>\n                    <th scope=\"row\">Email</th>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getPassword());
				jteOutput.writeContent("</td>\n                </tr>\n                </tbody>\n            </table>\n        </main>\n    </div>\n    ");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
