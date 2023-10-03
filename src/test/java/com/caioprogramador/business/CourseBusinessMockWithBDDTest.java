package com.caioprogramador.business;

import com.caioprogramador.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

class CourseBusinessMockWithBDDTest {
    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup(){
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @DisplayName("Teste se aparecem 4 cursos quando o parâmetro é Spring")
    @Test
    void testCoursesRelatedToSpring_When_UsingAMock(){



        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When
        List<String> filteredCourses = business.retrieveCoursesRelatedToString("Leandro");
        // Then

        assertThat(filteredCourses.size(), is(4));
    }


    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse(){
        // Given
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        // When
        business.deleteCoursesNotRelatedToString("Leandro");

        // Then
        verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
        verify(mockService).deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
    }


    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerifyThenShould_Should_CallMethod_deleteCourse(){
        // Given
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        String architectureCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";
        String dockerCourse = "Docker do Zero à Maestria - Contêinerização Desmistificada";
        // When
        business.deleteCoursesNotRelatedToString("Leandro");


        // Then
        then(mockService).should()
                        .deleteCourse(dockerCourse);

        then(mockService).should(never()).deleteCourse(architectureCourse);

        verify(mockService, never()).deleteCourse(architectureCourse);
        verify(mockService).deleteCourse(dockerCourse);
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourse(){
        // Given

        /*courses = Arrays.asList(
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada"
        );*/

        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
//        String dockerCourse = "Docker do Zero à Maestria - Contêinerização Desmistificada";
        // When
        business.deleteCoursesNotRelatedToString("Leandro");


        // Then
        then(mockService).should(times(7))
                .deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }


}