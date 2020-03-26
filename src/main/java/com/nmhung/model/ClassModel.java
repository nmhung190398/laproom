package com.nmhung.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//@Builder
public class ClassModel {
    protected Integer id;
    protected String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date endDate;
    protected SubjectModel subject;
    protected UserModel teacher;


}
