package com.itvedant.courseregistration.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.courseregistration.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
