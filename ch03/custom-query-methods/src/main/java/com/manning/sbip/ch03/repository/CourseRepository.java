package com.manning.sbip.ch03.repository;

import com.manning.sbip.ch03.model.Course;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.category=?1")
    Iterable<Course> findAllByCategory(String category);

    @Query("select c from Course c where c.category=:category and c.rating >:rating")
    Iterable<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category,
        @Param("rating") int rating);

    @Query(value = "select * from COURSES where rating=?1", nativeQuery = true)
    Iterable<Course> findAllByRating(int rating);

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.rating=:rating WHERE c.name=:name")
    int updateCourseRatingByName(@Param("rating") int rating, @Param("name") String name);

    Iterable<Course> findAllByCategoryOrderByName(String category);

    boolean existsByName(String name);

    long countByCategory(String category);

    Iterable<Course> findByNameOrCategory(String name, String category);

    Iterable<Course> findByNameStartsWith(String name);

    Stream<Course> streamAllByCategory(String category);

    Iterable<Course> findAllByCategoryAndRating(String category, int rating);
}
