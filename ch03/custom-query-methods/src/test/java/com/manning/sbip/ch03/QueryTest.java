package com.manning.sbip.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class QueryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {
        saveMockCourses();
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(3);
        assertThat(courseRepository.findAllByRating(3)).hasSize(2);
        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 3)).hasSize(2);
        courseRepository.updateCourseRatingByName(4,
            "Getting Started with Spring Cloud Kubernetes");
        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 3)).hasSize(3);
    }


    private void saveMockCourses() {
        Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development",
            "Spring", 4,
            "Spring Boot gives all the power of the Spring Framework without all of the complexity");
        Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL",
            "Spring", 5, "Learn Spring Security DSL in easy steps");
        Course springCloudKubernetesCourse = new Course(
            "Getting Started with Spring Cloud Kubernetes", "Spring", 3,
            "Master Spring Boot application deployment with Kubernetes");
        Course rapidPythonCourse = new Course("Getting Started with Python", "Python", 5,
            "Learn Python concepts in easy steps");
        Course gameDevelopmentWithPython = new Course("Game Development with Python", "Python", 3,
            "Learn Python by developing 10 wonderful games");
        Course javaScriptForAll = new Course("JavaScript for All", "JavaScript", 4,
            "Learn basic JavaScript syntax that can apply to anywhere");
        Course javaScriptCompleteGuide = new Course("JavaScript Complete Guide", "JavaScript", 5,
            "Master JavaScript with Core Concepts and Web Development");

        List<Course> courses = Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse,
            springCloudKubernetesCourse, rapidPythonCourse, gameDevelopmentWithPython,
            javaScriptForAll, javaScriptCompleteGuide);
        courseRepository.saveAll(courses);
    }
}

