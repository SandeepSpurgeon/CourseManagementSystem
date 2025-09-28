package org.svec.coursemanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.svec.coursemanagementsystem.entites.Course;

import java.util.List;

public class InstructorModel {

    private String rollNo;

    private String fullName;

    private String department;

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
}
