package org.svec.coursemanagementsystem.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        if(this.students == null) {
            this.students = new ArrayList<>();
        }

        for(Student student: students) {
            student.setCourses(List.of(this));
        }

        this.students.addAll(students);
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        instructor.setCourses(List.of(this));
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
