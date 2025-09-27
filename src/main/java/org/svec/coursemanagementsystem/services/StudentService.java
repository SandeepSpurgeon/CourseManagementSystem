package org.svec.coursemanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.svec.coursemanagementsystem.entites.Student;
import org.svec.coursemanagementsystem.repositories.StudentRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final Logger logger = Logger.getLogger(StudentService.class.getName());

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void addStudentsData() {
        var sandeep = new Student("16121A05N7",
                "Valluru Sandeep Spurgeon");
        var zunaid = new Student("16121A05L4",
                "Shaik Zunaid Ahemad");

        this.studentRepository.saveAll(List.of(sandeep, zunaid));
    }
}
