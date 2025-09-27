package org.svec.coursemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.svec.coursemanagementsystem.entites.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long> {

}
