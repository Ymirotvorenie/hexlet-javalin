package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.sql.SQLException;
import java.util.ArrayList;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void index(Context ctx) throws SQLException{
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
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException{
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).orElseThrow(() -> new NotFoundResponse("Course not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("courses/build.jte", model("page", new BuildCoursePage()));
    }

    public static void create(Context ctx) throws SQLException{
        try {
            var checkedName = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название курса должно быть более 2 символов")
                    .get();
            var checkedDesc = ctx.formParamAsClass("desc", String.class)
                    .check(value -> value.length() > 10, "Описание курсо должно быть более 10 символов")
                    .get();
            var course = new Course(checkedName, checkedDesc);
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Course have been created!");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var description = ctx.formParam("desc");
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.sessionAttribute("flash", "Course don't created!");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setVariant("danger");
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) throws SQLException{
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).orElseThrow(() -> new NotFoundResponse("Course not found"));
        var page = new CoursePage(course);
        ctx.render("courses/edit.jte", model("page", page));
    }

    public static void update(Context ctx) throws SQLException{
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var checkedName = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название курса должно быть более 2 символов")
                    .get();
            var checkedDesc = ctx.formParamAsClass("desc", String.class)
                    .check(value -> value.length() > 10, "Описание курсо должно быть более 10 символов")
                    .get();
            var course = CourseRepository.find(id).orElseThrow(() -> new NotFoundResponse("User not found"));
            course.setName(checkedName);
            course.setDescription(checkedDesc);
            //CourseRepository.save(course);
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var description = ctx.formParam("desc");
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
