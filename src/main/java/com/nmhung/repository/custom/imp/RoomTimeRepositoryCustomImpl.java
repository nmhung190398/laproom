package com.nmhung.repository.custom.imp;

import com.nmhung.entity.RoomTimeEntity;
import com.nmhung.repository.custom.RoomTimeRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class RoomTimeRepositoryCustomImpl implements RoomTimeRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Integer changeActive(Integer id, Boolean active) {
        String hql = "update com.nmhung.entity.RoomTimeEntity as rt set rt.active = :active WHERE rt.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("active",active);
        return query.executeUpdate();
    }

    @Override
    public List<RoomTimeEntity> findByRangeDateAndRoom(Date start, Date end, Integer room,Boolean active) {
        String hql = "from com.nmhung.entity.RoomTimeEntity as rt WHERE rt.date >= :startDate and rt.date <= :endDate and rt.room.id = :idRoom ";
        if(active != null){
            hql += "and rt.active = :active ";
        }
        Query query = entityManager.createQuery(hql,RoomTimeEntity.class)
                .setParameter("startDate",start)
                .setParameter("endDate",end)
                .setParameter("idRoom",room);
        if(active != null){
            query.setParameter("active",active);
        }
        return query.getResultList();
    }

    @Override
    public List<RoomTimeEntity> findByDate(Date date, Boolean active) {
        String hql = "from com.nmhung.entity.RoomTimeEntity as rt WHERE rt.date = :date ";
        if(active != null){
            hql += "and rt.active = :active ";
        }
        Query query = entityManager.createQuery(hql,RoomTimeEntity.class)
                .setParameter("date",date);
        if(active != null){
            query.setParameter("active",active);
        }
        return query.getResultList();
    }

    @Override
    public List<RoomTimeEntity> findStatisticalByClass(Integer idClass) {
        String hql = "from com.nmhung.entity.RoomTimeEntity as rt WHERE rt.active = true ";
        hql += " and rt.clasS.id = :idClass ";
        hql += " order by rt.date desc";
        Query query = entityManager.createQuery(hql,RoomTimeEntity.class);
        query.setParameter("idClass",idClass);
        return query.getResultList();
    }
}
