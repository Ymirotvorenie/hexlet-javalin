package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,8,8,9,9,9,9,9,9,9,9,9,14,14,14,14,14,14,14,14,14,16,16,16,16,16,16,16,16,16,22,22,22,22,22,22,22,22,22,24,24,24,24,24,24,24,24,24,30,30,30,31,31,33,33,34,34,36,36,36,36,36,36,36,36,36,36,36,36,37,37,37,39,39,40,40,41,41,41,41,44,44,44,46,46,46,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n        <br><br>\n        <input type=\"submit\" value=\"Create new course\">\n        <br><br>\n    </form>\n    <form");
				var __jte_html_attribute_1 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n        <label>Course name\n            <input type=\"search\" required name=\"term\"");
				var __jte_html_attribute_2 = page.getParam("term");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        </label>&nbsp;\n        <input type=\"submit\" value=\"Искать\">\n        <br><br>\n    </form>\n\n    <form");
				var __jte_html_attribute_3 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n        <label>Course description\n            <input type=\"search\" required name=\"desc\"");
				var __jte_html_attribute_4 = page.getParam("desc");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_4);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        </label>\n        <input type=\"submit\" value=\"Искать\">\n        <br><br>\n    </form>\n\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пока не добавлено ни одного курса</p>\n        ");
				} else {
					jteOutput.writeContent("\n            ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                <div>\n                    <h2><a");
						var __jte_html_attribute_5 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_5);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</a></h2>\n                    <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p>\n                </div>\n            ");
					}
					jteOutput.writeContent("\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div>          </div>\n        <p>its footer</p>\n    ");
			}
		}, page);
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
