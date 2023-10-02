package com.caioprogramador.business;

import com.caioprogramador.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// SUT System (Method) Under Test
public class CourseBusiness{

    // CourseService is a Dependency
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToString(String student){
        List<String> filteredCourses = new ArrayList<>();

        if ("Foo Bar".equals(student)) return filteredCourses;

        List<String> allCourses = service.retrieveCourses(student);
        for (String course : allCourses){
            if(course.contains("Spring")){
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }
}
