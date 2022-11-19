package com.dataLeaason.jude.data_lessons.repository;

import com.dataLeaason.jude.data_lessons.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
