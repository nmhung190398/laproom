package com.nmhung.repository;

import com.nmhung.entity.RoomTimeEntity;
import com.nmhung.repository.custom.RoomTimeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface RoomTimeRepository extends JpaRepository<RoomTimeEntity,Integer>, RoomTimeRepositoryCustom {

//    List<RoomTimeEntity> findByDateGreaterThanEqualAndDateLessThanEqualAndRomId(Date start,Date end,Integer room);
//    List<RoomTimeEntity> findByDateGreaterThanEqualAndDateLessThanEqualAndActive(Date start,Date end,Boolean active);

//    @Query("update RoomTimeEntity as rt set rt.active = ?2 WHERE rt.id = ?1")
//    Integer changeActive(Integer id, Boolean active);


}
