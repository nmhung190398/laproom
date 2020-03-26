package com.nmhung.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "tblroom")
@Data
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    @Column(name = "total_desktop ")
    private Integer totalDesktop ;

    @OneToMany(mappedBy = "room")
    private List<RoomTimeEntity> roomTime;

}
