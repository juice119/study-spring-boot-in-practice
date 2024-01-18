package com.manning.sbip.ch03.repository;

import com.manning.sbip.ch03.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoursePaginationRepository extends PagingAndSortingRepository<Course, Long> {
}
