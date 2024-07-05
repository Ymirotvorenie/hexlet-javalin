package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,20,20,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,24,27,27,28,28,28,28,29,29,29,31,31,33,33,33,36,36,38,38,38,40,40,44,44,44,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, BasePage basePage) {
		jteOutput.writeContent("\n<!DOCTYPE HTML>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap-table@1.22.6/dist/bootstrap-table.min.js\"></script>\n        <title>Hexlet Javalin Example</title>\n    </head>\n    <body>\n        <div class=\"mb-3\">\n            <p>Educational center Hexlet</p>\n            <a");
		var __jte_html_attribute_0 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Programming courses</a>\n        </div>\n        <div class=\"mb-3\">\n            <p>Hexlet Users</p>\n            <a");
		var __jte_html_attribute_1 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Users</a>\n        </div>\n\n            ");
		if (basePage != null && basePage.getFlash() != null) {
			jteOutput.writeContent("\n                <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(basePage.getVariant());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\n                    <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(basePage.getFlash());
			jteOutput.writeContent("</p>\n                </div>\n            ");
		}
		jteOutput.writeContent("\n\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n\n        <div>\n            ");
		if (footer != null) {
			jteOutput.writeContent("\n            <div class=\"footer\">\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\n            </div>\n            ");
		}
		jteOutput.writeContent("\n        </div>\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		BasePage basePage = (BasePage)params.getOrDefault("basePage", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, basePage);
	}
}
