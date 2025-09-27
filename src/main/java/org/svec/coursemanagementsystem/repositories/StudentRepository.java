package org.svec.coursemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.svec.coursemanagementsystem.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
