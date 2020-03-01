package com.nmhung.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//@Builder
public class ClassModel {
    private Integer id;
    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private SubjectModel subject;
    private UserModel teacher;
}
