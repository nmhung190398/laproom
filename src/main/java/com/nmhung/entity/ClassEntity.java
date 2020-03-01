package com.nmhung.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Table
@Entity(name = "tblclass")
@Data
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_subject")
    private SubjectEntity subject;

    @ManyToOne(targetEntity = UserEntity.class,fetch=FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private UserEntity teacher;

    @OneToMany(mappedBy = "clasS")
    private List<RoomTimeEntity> roomTime;
}
