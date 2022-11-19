package com.dataLeaason.jude.data_lessons.repository;

import com.dataLeaason.jude.data_lessons.entity.Guadian;
import com.dataLeaason.jude.data_lessons.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("jude@gmail.com")
                .firstName("banseka")
                .lastName("jude")
//                .guardianEmail("javka@gmai.com")
//                .guardianMobile("567876543")
//                .guardianName("javka")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guadian guadian = Guadian.builder()
                .name("Javka")
                .email("javka@gmail.com")
                .mobile("997654332")
                .build();

        Student student = Student.builder()
                .firstName("Banseka")
                .lastName("Jude")
                .emailId("bansekajude@gmail.com")
                .guardian(guadian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public  void getStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("students are" + students);
    }

    @Test
    public void getStudentByEmailAddress(){
       Student student =  studentRepository.getStudentByEmailAddress("bansekajude@gmail.com");
       System.out.println("student by email is " + student);
    }

}