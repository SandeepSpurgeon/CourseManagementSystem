package org.svec.coursemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.svec.coursemanagementsystem.entites.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
