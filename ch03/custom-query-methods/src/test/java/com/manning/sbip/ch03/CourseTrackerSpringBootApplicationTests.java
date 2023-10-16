package com.manning.sbip.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void 다양한_방법으로_강의를_조회_할_수_있다() {
        // given
        courseRepository.saveAll(getCourseList());

        // when & then
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(3);
        assertThat(courseRepository.existsByName("JavaScript for All")).isTrue();
        assertThat(courseRepository.existsByName("Mastering JavaScript")).isFalse();
        assertThat(courseRepository.countByCategory("Python")).isEqualTo(2);
        assertThat(courseRepository.findByNameStartsWith("Getting Started")).hasSize(3);
    }

    private List<Course> getCourseList() {
        Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4,"Spring Boot gives all the power of the Spring Framework without all of the complexity");
        Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 5, "Learn Spring Security DSL in easy steps");
        Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 3, "Master Spring Boot application deployment with Kubernetes");
        Course rapidPythonCourse = new Course("Getting Started with Python", "Python", 5, "Learn Python concepts in easy steps");
        Course gameDevelopmentWithPython = new Course("Game Development with Python", "Python", 3, "Learn Python by developing 10 wonderful games");
        Course javaScriptForAll = new Course("JavaScript for All", "JavaScript", 4, "Learn basic JavaScript syntax that can apply to anywhere");
        Course javaScriptCompleteGuide = new Course("JavaScript Complete Guide", "JavaScript", 5, "Master JavaScript with Core Concepts and Web Development");

        return Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse, rapidPythonCourse, gameDevelopmentWithPython, javaScriptForAll, javaScriptCompleteGuide);
    }
}
