package com.nmhung.model;

import lombok.Data;

import java.util.Date;

public class ClassDTO extends ClassModel {
    private Integer sum;

    public ClassDTO(Integer id, String code,
                    Integer idSubject,String nameSubject, Integer totalLesson,
                    Integer idUser, String usernameUser, String passwordUser, String fullnameUser, String emailUser,
                    Integer sum
    ) {
        this.id = id;
        this.code = code;
        this.subject = new SubjectModel(idSubject,nameSubject,totalLesson);
        this.teacher = new UserModel(idUser,usernameUser,passwordUser,fullnameUser,emailUser);
        this.sum = sum;
    }
}
