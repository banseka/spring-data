package com.dataLeaason.jude.data_lessons.repository;

import com.dataLeaason.jude.data_lessons.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByGuardianName(String name);
    List<Student> findByLastName(String lastName);

    // JPQL query  for get student by email where email is equal to the first parameter
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);


    //JPQL query for get student first name by email where email is equal to the first parameter
    @Query("select s.firstName from Student s where s.emailId = ?1")
    Student getStudentFirstNameByEmailAddress(String emailId);

    //SQL query or get student by email address
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //SQL query or get student by email address with named params
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


    //SQL query update student firstname by email address
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set s.first_name = :firstName where s.email_address = :emailId ",
            nativeQuery = true
    )
    int updateStudentByEmailAddressNative(@Param("firstName") String firstname, @Param("emailId") String emailId);
}
