package org.example.hexlet.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import org.example.hexlet.model.Course;


public class CourseRepository {
    // Тип зависит от того, с какой сущностью идет работа в упражнении
    @Getter
    private static List<Course> entities = new ArrayList<>(List.of(
            new Course(1L, "Java", "Backend development"),
            new Course(2L, "JavaScript", "Fullstack development"),
            new Course(3L, "QA", "Big data development")));

    public static void save(Course course) {
        // Формируется идентификатор
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getName().toLowerCase().startsWith(term.toLowerCase()))
                .toList();
    }

    public static Optional<Course> find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

}

