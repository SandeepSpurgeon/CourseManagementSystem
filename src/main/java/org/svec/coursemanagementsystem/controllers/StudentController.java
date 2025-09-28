package org.svec.coursemanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svec.coursemanagementsystem.models.StudentModel;
import org.svec.coursemanagementsystem.services.StudentService;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class StudentController {

    private final StudentService studentService;

    private final Logger logger = Logger.getLogger(StudentController.class.getName());

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> getStudents() {
        var students = this.studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK)
                .body(students);
    }
}
