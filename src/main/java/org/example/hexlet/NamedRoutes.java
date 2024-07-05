package org.example.hexlet;

public class NamedRoutes {
    //route /users
    public static String usersPath() {
        return "/users";
    }

    //route /users/build
    public static String buildUserPath() {
        return "/users/build";
    }

    //route /users/ + String id
    public static String userPath(String id) {
        return "/users/" + id;
    }

    //route /users/ + Long id
    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    //route /users/{id}/edit
    public static String userEditPath(String id) {
        return String.format("/users/%s/edit", id);
    }

    //route /courses
    public static String coursesPath() {
        return "/courses";
    }

    //route /courses/ + String id
    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    //route /courses/ + Long id
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    //route /courses/build
    public static String buildCoursePath() {
        return "/courses/build";
    }

    //route /courses/{id}/edit
    public static String courseEditPath(String id) {
        return String.format("/courses/%s/edit", id);
    }

    public static String sessionsPath() {
        return "/sessions";
    }
    public static String buildSessionsPath() {
        return "/sessions/build";
    }
}
