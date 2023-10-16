package com.manning.sbip.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import com.manning.sbip.ch03.domain.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
        // given
        Course course = new Course("SpringBook", "Spring", 4, "Spring Tutorial Book");

        // when
        Course saveCourse = courseRepository.save(course);

        // then
        Course findedCourse = courseRepository.findById(saveCourse.getId()).get();
        assertThat(findedCourse).isEqualTo(course);
    }

    @Test
    public void givenUpdateCourseWhenLoadTheCourseThenExpectUpdatedCourse() {
        // given
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4,
            "'Spring Boot gives all the power of the Spring Framework without all of the complexities");

        // when
        courseRepository.save(course);
        course.setRating(5);
        Course savedCourse = courseRepository.save(course);

        // then
        assertThat(courseRepository.findById(savedCourse.getId()).get().getRating()).isEqualTo(5);
    }

    @Test
    void givenDeleteCourse() {
        // given
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4,
            "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        Course savedCourse = courseRepository.save(course);

        // when
        courseRepository.delete(course);

        // then
        assertThat(courseRepository.findById(savedCourse.getId()).isPresent()).isFalse();
    }
}
