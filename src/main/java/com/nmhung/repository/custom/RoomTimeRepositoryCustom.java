package com.nmhung.repository.custom;


import com.nmhung.entity.RoomEntity;
import com.nmhung.entity.RoomTimeEntity;

import java.util.Date;
import java.util.List;

public interface RoomTimeRepositoryCustom {
    Integer changeActive(Integer id, Boolean active);
    List<RoomTimeEntity> findByRangeDateAndRoom(Date start, Date end, Integer room,Boolean active);
    List<RoomTimeEntity> findByDate(Date date,Boolean active);
}
