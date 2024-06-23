package org.example.hexlet.dto.courses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.hexlet.model.Course;

import lombok.Getter;

@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
    private Map<String, String> queryParams;

    public CoursesPage(List<Course> courses, String header) {
        this.courses = courses;
        this.header = header;
        queryParams = new HashMap<>();
    }
    public void addParam(String paramName, String value) {
        queryParams.put(paramName, value);
    }

    public String getParam(String paramName) {
        return queryParams.get(paramName);
    }
}
