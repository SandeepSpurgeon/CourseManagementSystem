package org.svec.coursemanagementsystem.controllers;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svec.coursemanagementsystem.services.StudentService;

import java.util.logging.Logger;

@RestController
public class StudentController {

    private final StudentService studentService;

    private final Logger logger = Logger.getLogger(StudentController.class.getName());

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/data")
    public void run() {
        this.studentService.addStudentsData();
    }

}
