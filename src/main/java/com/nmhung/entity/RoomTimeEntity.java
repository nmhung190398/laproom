package com.nmhung.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Table
@Entity(name = "tblroom_time")
@Data
public class RoomTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer shift;
    private Date date;

    @Column(name = "date_start")
    private String dateStart;
    @Column(name = "date_end")
    private String dateEnd;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity clasS;
    @ManyToOne
    @JoinColumn(name = "id_room")
    private RoomEntity room;
}
