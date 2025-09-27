package org.svec.coursemanagementsystem.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "roll_number")
    private String rollNo;

    @Column(name = "full_name")
    private String fullName;


    public Student() {
    }

    public Student(String rollNo, String fullName) {
        this.rollNo = rollNo;
        this.fullName = fullName;
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


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
