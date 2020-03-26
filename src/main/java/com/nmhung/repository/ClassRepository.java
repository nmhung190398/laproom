package com.nmhung.repository;

import com.nmhung.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository  extends JpaRepository<ClassEntity,Integer> {
    List<ClassEntity> findByTeacherId(Integer idTeacher);
}
