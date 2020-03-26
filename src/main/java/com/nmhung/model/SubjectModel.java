package com.nmhung.model;

import lombok.Data;

@Data
public class SubjectModel {
    private Integer id;
    private String name;
    private Integer totalLesson;

    public SubjectModel(Integer id, String name, Integer totalLesson) {
        this.id = id;
        this.name = name;
        this.totalLesson = totalLesson;
    }

    public SubjectModel() {
    }
}
