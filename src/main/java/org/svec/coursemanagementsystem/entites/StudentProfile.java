package org.svec.coursemanagementsystem.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_profile_id")
    private Long id;

    @Column(name = "major")
    private String major;

    @Column(name = "mobile_number")
    private String mobileNo;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "studentProfile")
    private Student student;


    public StudentProfile() {
    }

    public StudentProfile(String major, String mobileNo, String email) {
        this.major = major;
        this.mobileNo = mobileNo;
        this.email = email;
    }


    public Long getId() {
        return id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
