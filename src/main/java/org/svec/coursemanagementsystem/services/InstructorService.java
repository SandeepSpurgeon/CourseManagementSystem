package org.svec.coursemanagementsystem.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.svec.coursemanagementsystem.entites.Instructor;
import org.svec.coursemanagementsystem.repositories.CourseRepository;
import org.svec.coursemanagementsystem.repositories.InstructorRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    private final Logger logger = Logger.getLogger(InstructorService.class.getName());

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addInstructorAndCourse() {
        logger.info("Adding instructors");

        var shiva = new Instructor("SVEC-CS-01", "ShivaRam Krishna", "Computer Science");
        var reddy = new Instructor("SVEC-CS-02", "Reddy Shekar", "Computer Science");
        var nag = new Instructor("SVEC-CS-03", "Apple Nagaraj", "Computer Science");

        this.instructorRepository.saveAll(List.of(shiva, reddy, nag));

        var java = this.courseRepository.getReferenceById(1L);
        var python = this.courseRepository.getReferenceById(2L);
        var ds = this.courseRepository.getReferenceById(3L);

        java.setInstructor(shiva);
        python.setInstructor(reddy);
        ds.setInstructor(shiva);

    }
}
