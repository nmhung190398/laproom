package com.nmhung.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "tblrole")
@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String title;
    @OneToMany(mappedBy = "role")
    List<UserEntity> users = new ArrayList<UserEntity>();
}
