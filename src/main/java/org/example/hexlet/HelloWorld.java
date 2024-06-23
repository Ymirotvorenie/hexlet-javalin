package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.html.HtmlPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {

//        final List<Course> COURSES = new ArrayList<>(List.of(
//                new Course(1L, "Java", "Backend development"),
//                new Course(2L, "JavaScript", "Fullstack development"),
//                new Course(3L, "QA", "Big data development")));

        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/html/{html}", ctx -> {
            var html = ctx.pathParam("html");
            ctx.contentType("text/html");
//            PolicyFactory policy = new HtmlPolicyBuilder()
//                    .allowElements("a")
//                    .allowUrlProtocols("https")
//                    .allowAttributes("href").onElements("a")
//                    .requireRelNofollowOnLinks()
//                    .toFactory();
            var page = new HtmlPage(html);
            ctx.render("htmlInjection.jte", model("page", page));
        });

        app.get("/courses", ctx -> {
            var courses = new ArrayList<Course>();
            var term = ctx.queryParam("term");
            var desc = ctx.queryParam("desc");
            var header = "Курсы по программированию";
            CoursesPage page;
            if (term != null) {
                courses = new ArrayList<>(CourseRepository.search(term));
                page = new CoursesPage(courses, header);
                page.addParam("term", term);
            } else if (desc != null) {
                courses = new ArrayList<>(CourseRepository.getEntities()
                        .stream()
                        .filter(c -> c.getDescription().toLowerCase().contains(desc.toLowerCase())).toList());
                page = new CoursesPage(courses, header);
                page.addParam("desc", desc);
            } else {
                courses = new ArrayList<>(CourseRepository.getEntities());
                page = new CoursesPage(courses, header);
            }

            ctx.render("courses/index.jte", model("page", page));
        });
        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });
        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var course = CourseRepository.find(id).orElseThrow(() -> new NotFoundResponse("Course not found"));
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.post("/courses/build", ctx -> {
            var name = ctx.formParam("name");
            var desc = ctx.formParam("desc");
            var course = new Course(name, desc);
            course.setId(CourseRepository.getEntities().size() + 1L);

            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

//        app.get("/users", ctx -> ctx.result("GET /users"));
//        app.post("/users", ctx -> ctx.result("POST /users"));
//        app.get("/hello", ctx -> {
//            var name = ctx.queryParam("name");
//            ctx.result(String.format("Hello, %s!", name));
//        });
//
//        app.get("users/{id}/post/{postId}", ctx -> {
//            var id = ctx.pathParam("id");
//            var postId = ctx.pathParam("postId");
//            var escapedPostId = StringEscapeUtils.escapeHtml4(postId);
//            ctx.contentType("text/html");
//            ctx.result("<h1>" + id + " " + escapedPostId + "</h1>");
//            //ctx.result(String.format("User ID: %s, User PostID: %s", id, postId));
//        });
        app.get("/users", ctx -> {
            var page = new UsersPage(UserRepository.getEntities());
            ctx.render("users/build.jte", model("page", page));
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var pass = ctx.formParam("pass");
            var passConfirm = ctx.formParam("passConfirm");

            var user = new User(name, email, pass);

            if (pass.equals(passConfirm)) {
                UserRepository.save(user);
            }

            ctx.redirect("/users");
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);

            ctx.render("users/show.jte", model("page", page));
        });

        app.start(7070); // Стартуем веб-сервер
    }
}
