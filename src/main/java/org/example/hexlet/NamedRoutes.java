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

    public static String buildCoursePath() {
        return "/courses/build";
    }
}
