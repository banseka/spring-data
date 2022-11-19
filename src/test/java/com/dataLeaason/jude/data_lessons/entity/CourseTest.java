package com.dataLeaason.jude.data_lessons.entity;

import com.dataLeaason.jude.data_lessons.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseTest {

    @Autowired
    CourseRepository courseRepository;


    @Test
    public  void findCourseByPaging(){
        Pageable firstThreeCourses = PageRequest.of(0, 3);
        courseRepository.findAll(firstThreeCourses).getContent();

        long totalElements = courseRepository.findAll(firstThreeCourses).getTotalElements();

        long totalPages = courseRepository.findAll(firstThreeCourses).getTotalPages();
    }

    @Test
    public void findAllSorting(){
        Pageable sort = PageRequest.of(0, 3, Sort.by("title"));

        Pageable sortByCreditDescending = PageRequest.of(0, 3, Sort.by("credit").descending());

        Pageable sortByCreditAndTitle = PageRequest.of(0, 3, Sort.by("credit").descending().and(Sort.by("title")));

        List<Course> coursesSorted = courseRepository.findAll(sort).getContent();

        List<Course> coursesContainingString = courseRepository.findByTitleContaining("mask", sortByCreditAndTitle).getContent();
    }

}