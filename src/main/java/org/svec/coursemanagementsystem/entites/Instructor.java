package org.svec.coursemanagementsystem.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "instructor_id")
    private Long id;

    @Column(name = "roll_number")
    private String rollNo;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor(String rollNo, String fullName, String department) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        if(this.courses == null) {
            this.courses = new ArrayList<>();
        }

        this.courses.addAll(courses);
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
