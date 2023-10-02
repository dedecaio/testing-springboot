package com.caioprogramador.business;

import com.caioprogramador.service.CourseService;
import com.caioprogramador.stubs.CourseServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseBusinessTest {

    @DisplayName("Teste se aparecem 4 cursos quando o parâmetro é Spring")
    @Test
    void testCoursesRelatedToSpring_When_UsingAStub(){
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);


        // When
        List<String> filteredCourses = business.retrieveCoursesRelatedToString("Leandro");
        // Then

        assertEquals(4, filteredCourses.size());
    }


    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent(){
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);


        // When
        List<String> filteredCourses = business.retrieveCoursesRelatedToString("Foo Bar");
        // Then

        assertEquals(0, filteredCourses.size());
    }

}