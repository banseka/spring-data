package com.dataLeaason.jude.data_lessons.repository;

import com.dataLeaason.jude.data_lessons.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
