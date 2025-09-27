package org.svec.coursemanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.svec.coursemanagementsystem.entites.Student;
import org.svec.coursemanagementsystem.entites.StudentProfile;
import org.svec.coursemanagementsystem.repositories.StudentProfileRepository;
import org.svec.coursemanagementsystem.repositories.StudentRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentProfileRepository studentProfileRepository;

    private final Logger logger = Logger.getLogger(StudentService.class.getName());

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentProfileRepository studentProfileRepository) {
        this.studentRepository = studentRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    @Transactional
    public void addStudentsData() {
        var sandeep = new Student("16121A05N7",
                "Valluru Sandeep Spurgeon");
        var zunaid = new Student("16121A05L4",
                "Shaik Zunaid Ahemad");

        this.studentRepository.saveAll(List.of(sandeep, zunaid));
    }

    @Transactional
    public void addStudentProfileDataAndStudent() {
        var studentProfile1 = new StudentProfile("ComputerScience",
                "8374198879", "sandeepspurgeon@gmail.com");
        var studentProfile2 = new StudentProfile("ComputerScience",
                "9848032919", "zunaidahmead@gmail.com");

        var sandeep = this.studentRepository.getReferenceById(1L);
        sandeep.setStudentProfile(studentProfile1);
        var zunaid = this.studentRepository.getReferenceById(2L);
        zunaid.setStudentProfile(studentProfile2);
    }
}
