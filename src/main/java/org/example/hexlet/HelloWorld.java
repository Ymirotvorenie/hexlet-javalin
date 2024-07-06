package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static void main(String[] args) throws SQLException {

        // Создаем приложение
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> {
//            var visited = Boolean.parseBoolean(ctx.cookie("visited"));
//            var page = new MainPage(visited);
//            ctx.render("index.jte", model("page", page));
//            ctx.cookie("visited", String.valueOf(true));
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        //Sessions
        app.get(NamedRoutes.buildSessionsPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        //Courses CRUD
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.courseEditPath("{id}"), CoursesController::edit);
        app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);

        //Users CRUD
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.userEditPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.userPath("{id}"), UsersController::destroy);

        app.start(7070); // Стартуем веб-сервер
    }
}
