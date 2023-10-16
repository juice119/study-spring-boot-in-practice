package com.manning.sbip.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CustomizedCourseRepository;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CustomizedCourseRepository courseRepository;

    @Test
    void 강의_생성_후_조회_된다() {
        // given
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        
        // when
        courseRepository.save(course);

        // then
        assertThat(Arrays.asList(courseRepository.findAll()).size()).isEqualTo(1);
    }
}
