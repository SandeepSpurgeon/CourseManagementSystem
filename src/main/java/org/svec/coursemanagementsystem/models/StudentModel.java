package org.svec.coursemanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {

//    private Long id;
    private String rollNo;
    private String fullName;
    private String major;
    private String mobileNo;
    private String email;
    private List<CourseModel> course;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CourseModel> getCourse() {
        return course;
    }

    public void setCourse(List<CourseModel> course) {

        if(this.course == null) {
            this.course = new ArrayList<>();
        }

        this.course.addAll(course);
    }
}
