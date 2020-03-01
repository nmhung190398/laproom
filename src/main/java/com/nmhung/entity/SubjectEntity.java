package com.nmhung.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "tblsubject")
@Data
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "total_lesson")
    private Integer totalLesson;
    @OneToMany(mappedBy = "subject")
    private List<ClassEntity> classes;
}
