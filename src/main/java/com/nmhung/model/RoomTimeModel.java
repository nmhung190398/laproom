package com.nmhung.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RoomTimeModel {
	private Integer id;
	private Integer shift;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
	private Boolean active;
	private ClassModel clasS;
	private RoomModel room;
}
