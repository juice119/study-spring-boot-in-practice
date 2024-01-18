package com.manning.sbip.ch03.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.manning.sbip.ch03.model.Course;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@DataJpaTest
class CoursePaginationRepositoryTest {

    @Autowired
    private CoursePaginationRepository courseRepository;

    @Test
    void 첫_번째_페이지를_로드한_후_5개의_레코드를_얻을_때_주어진_데이터를_사용할_수_있습니다() {
        // given
        Pageable pageable = PageRequest.of(0, 5);
        assertThat(courseRepository.findAll(pageable)).hasSize(5);
        assertThat(pageable.getPageNumber()).isEqualTo(0);

        // when & then
        Pageable nextPagable = pageable.next();
        assertThat(courseRepository.findAll(nextPagable)).hasSize(4);
        assertThat(nextPagable.getPageNumber()).isEqualTo(1);
    }

    @Test
    void givenDataAvailableWhenSortsFirstPageThenGetSortedSData() {
        // given
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("Name")));

        // when
        Condition<Course> sortedFirstCourseCondition = new Condition<Course>() {
            @Override
            public boolean matches(Course course) {
                return course.getId() == 4 && course.getName()
                    .equals("Cloud Native Spring Boot Application Development");
            }
        };

        // then
        assertThat(courseRepository.findAll(pageable)).first().has(sortedFirstCourseCondition);
    }

    @Test
    void givenDataAvailableWhenApplyCustomSortThenGetSortedResult() {
        // given
        Pageable customSortPageable = PageRequest.of(0, 5,
            Sort.by("Rating").descending().and(Sort.by("Name")));

        // when
        Condition<Course> customSortFirstCourseCondition = new Condition<Course>() {
            @Override
            public boolean matches(Course course) {
                return course.getId() == 2 && course.getName()
                    .equals("Getting Started with Spring Security DSL");
            }
        };

        // then
        assertThat(courseRepository.findAll(customSortPageable)).first()
            .has(customSortFirstCourseCondition);
    }
}