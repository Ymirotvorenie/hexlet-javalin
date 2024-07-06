package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,10,10,11,11,11,13,13,14,14,14,14,17,17,17,18,18,18,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1 class=\"text-body-emphasis\">Привет, Хекслет!</h1>\n        <p>Javalin + jte</p>\n\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n        Добро пожаловать, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n    ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <a href=\"/sessions/build\">Login</a><br>\n    <a href=\"https://github.com/Ymirotvorenie\">тык</a>\n    ");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
