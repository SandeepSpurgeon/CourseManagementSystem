package org.svec.coursemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.svec.coursemanagementsystem.entites.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
