package org.svec.coursemanagementsystem.models;

public class CourseModel {

    private String name;

    private InstructorModel instructor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstructorModel getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorModel instructor) {
        this.instructor = instructor;
    }
}
