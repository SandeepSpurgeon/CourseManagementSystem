package org.svec.coursemanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svec.coursemanagementsystem.services.InstructorService;
import org.svec.coursemanagementsystem.services.StudentService;

import java.util.logging.Logger;

@RestController
public class CommonController {

    private final StudentService studentService;
    private final InstructorService instructorService;

    private final Logger logger = Logger.getLogger(CommonController.class.getName());


    @Autowired
    public CommonController(StudentService studentService, InstructorService instructorService) {
        this.studentService = studentService;
        this.instructorService = instructorService;
    }

    @GetMapping("/data")
    public void run() {
        logger.info("Running StudentController");

        this.studentService.addStudentsData();
        this.studentService.addStudentProfileDataAndStudent();
        this.studentService.addCoursesData();
        this.studentService.CourseAndStudents();
        this.studentService.fetchCourseAndStudents();
        this.instructorService.addInstructorAndCourse();
    }

}
