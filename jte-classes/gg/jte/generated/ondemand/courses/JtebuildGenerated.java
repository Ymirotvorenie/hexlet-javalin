package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,0,15,15,15,15,15,15,15,15};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n<form action=\"/courses\" method=\"post\">\n    <div>\n        <label for=\"nameInput\">Course name\n            <input type=\"text\" name=\"name\" id=\"nameInput\" class=\"form-control\"/>\n        </label>\n    </div>\n    <div>\n        <label for=\"descInput\">Email\n            <input type=\"text\" name=\"desc\" id=\"descInput\" class=\"form-control\"/>\n        </label>\n    </div>\n\n    <input type=\"submit\" value=\"Add course\" class=\"btn btn-primary\"/>\n</form>\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
