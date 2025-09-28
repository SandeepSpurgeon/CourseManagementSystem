package org.svec.coursemanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.svec.coursemanagementsystem.entites.Course;
import org.svec.coursemanagementsystem.entites.Student;
import org.svec.coursemanagementsystem.entites.StudentProfile;
import org.svec.coursemanagementsystem.models.CourseModel;
import org.svec.coursemanagementsystem.models.InstructorModel;
import org.svec.coursemanagementsystem.models.StudentModel;
import org.svec.coursemanagementsystem.repositories.CourseRepository;
import org.svec.coursemanagementsystem.repositories.StudentProfileRepository;
import org.svec.coursemanagementsystem.repositories.StudentRepository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final CourseRepository courseRepository;

    private final Logger logger = Logger.getLogger(StudentService.class.getName());

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentProfileRepository studentProfileRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addStudentsData() {
        logger.info("Adding students data");

        var sandeep = new Student("16121A05N7",
                "Valluru Sandeep Spurgeon");
        var zunaid = new Student("16121A05L4",
                "Shaik Zunaid Ahemad");

        this.studentRepository.saveAll(List.of(sandeep, zunaid));
    }

    @Transactional
    public void addStudentProfileDataAndStudent() {
        logger.info("Adding student profile data and mapping relationship to student");

        var studentProfile1 = new StudentProfile("ComputerScience",
                "8374198878", "sandeepsparzen@gmail.com");
        var studentProfile2 = new StudentProfile("ComputerScience",
                "9848032919", "zunaidahmead@gmail.com");

        var sandeep = this.studentRepository.getReferenceById(1L);
        sandeep.setStudentProfile(studentProfile1);
        var zunaid = this.studentRepository.getReferenceById(2L);
        zunaid.setStudentProfile(studentProfile2);
    }

    @Transactional
    public void addCoursesData() {
        logger.info("Adding courses data");

        var java = new Course("Java");
        var python = new Course("Python");
        var ds = new Course("Data Structures");

        this.courseRepository.saveAll(List.of(java, python, ds));
    }

    @Transactional
    public void CourseAndStudents() {
        logger.info("Adding students in the courses");

        var java = this.courseRepository.getReferenceById(1L);
        var python = this.courseRepository.getReferenceById(2L);
        var ds = this.courseRepository.getReferenceById(3L);

        var sandeep = this.studentRepository.getReferenceById(1L);
        var zunaid = this.studentRepository.getReferenceById(2L);

        java.setStudents(List.of(sandeep));
        python.setStudents(List.of(zunaid));
        ds.setStudents(List.of(sandeep, zunaid));
    }

    @Transactional(readOnly = true)
    public void fetchCourseAndStudents() {
        logger.info("Fetching courses and Students data");

        var ds = this.courseRepository.findById(3L).get();
        System.out.println(ds);
        System.out.println(ds.getStudents());

        if(ds.getStudents().isEmpty()) {
            throw new RuntimeException("Students not found");
        }
    }

    @Transactional(readOnly = true)
    public List<StudentModel> getStudents() {
        logger.info("Fetching student data");

        Student student = this.studentRepository.findById(1L).get();
        Student student1 = this.studentRepository.findById(2L).get();

        StudentModel stu = new StudentModel();
        stu.setFullName(student.getFullName());
        stu.setRollNo(student.getRollNo());
        stu.setMajor(student.getStudentProfile().getMajor());
        stu.setEmail(student.getStudentProfile().getEmail());
        stu.setMobileNo(student.getStudentProfile().getMobileNo());


        StudentModel stu1 = new StudentModel();
        stu1.setFullName(student1.getFullName());
        stu1.setRollNo(student1.getRollNo());
        stu1.setMajor(student1.getStudentProfile().getMajor());
        stu1.setEmail(student1.getStudentProfile().getEmail());
        stu1.setMobileNo(student1.getStudentProfile().getMobileNo());

//        // System.out.println("Courses:" + student.getCourses());
        for(Course course: student.getCourses()) {

            var instructor = new InstructorModel();
            instructor.setFullName(course.getInstructor().getFullName());
            instructor.setRollNo(course.getInstructor().getRollNo());
            instructor.setDepartment(course.getInstructor().getDepartment());

            var courseModel = new CourseModel();
            courseModel.setName(course.getName());
            courseModel.setInstructor(instructor);
            stu.setCourse(List.of(courseModel));
        }

/*        stu.setCourse(student.getCourses().stream().map(
                (course) -> {
                    var courseModel = new CourseModel();
                    courseModel.setName(course.getName());
                    return courseModel;
                }).collect(Collectors.toList()));*/

        stu1.setCourse(student1.getCourses().stream().map(
                        (course) -> {
                            var instructor = new InstructorModel();
                            instructor.setFullName(course.getInstructor().getFullName());
                            instructor.setRollNo(course.getInstructor().getRollNo());
                            instructor.setDepartment(course.getInstructor().getDepartment());

                            var courseModel = new CourseModel();
                            courseModel.setName(course.getName());
                            courseModel.setInstructor(instructor);
                            return courseModel;
                        }).collect(Collectors.toList()));

/*
        for(Course course: student1.getCourses()) {
            var courseModel = new CourseModel();
            courseModel.setName(course.getName());
            stu1.setCourse(List.of(courseModel));
        }
*/

        /*for(Course course: student.getCourses()) {
            System.out.println("Instructor: " + course.getInstructor());
        }

        System.out.println("Student: " + student1);
        System.out.println("Student: " + student1.getStudentProfile());
        System.out.println("Courses:" + student1.getCourses());

        for(Course course: student1.getCourses()) {
            System.out.println("Instructor: " + course.getInstructor());
        }

*/

        return List.of(stu, stu1);
    }
}
