package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //Find all courses by category
    List<Course> findByCATEGORY(String category);
    @Query("select e from Course e order by e.CATEGORY")
    Course courseByCategory();

    //Find all courses by category and order the entities by name
    List<Course> findByCATEGORYOrderByNAME(String category);
    @Query("select e from Course e order by e.NAME")
    Course filter();

    //Checks if a course with the supplied name exists. Return true if exists, false otherwise
    boolean existsByNAME(String name);

    //Returns the count of courses for the given category
    byte countCourseByCATEGORY(String category);

    //Finds all the courses that start with the given course name string
    List<Course> findByNAMEStartsWith(String pattern);

    //Find all courses by category and return a stream
    Stream<Course> streamAllByCATEGORY(String category);
    @Query("select c from Course c where c.CATEGORY = :category and c.RATING > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("CATEGORY") String category , @Param("RATING") int rating);

}
