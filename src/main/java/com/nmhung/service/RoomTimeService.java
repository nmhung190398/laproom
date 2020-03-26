package com.nmhung.service;

import com.nmhung.conver.RoomTimeConver;
import com.nmhung.entity.RoomTimeEntity;
import com.nmhung.model.RoomModel;
import com.nmhung.model.RoomTimeModel;
import com.nmhung.repository.ClassRepository;
import com.nmhung.repository.RoomRepository;
import com.nmhung.repository.RoomTimeRepository;
import com.nmhung.utils.DateUtils;
import com.nmhung.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoomTimeService {

    @Autowired
    RoomTimeRepository roomTimeRepository;

    @Autowired
    RoomTimeConver roomTimeConver;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ClassRepository classRepository;

    public List<RoomTimeModel> findByDate(Date date, Integer room) {
        Date end = DateUtils.getSunDay(date);
        Date start = DateUtils.getMonDay(date);
        return findByDate(start, end, room, null);
    }

    private List<RoomTimeModel> findByDate(Date start, Date end, Integer room, Boolean active) {
        List<RoomTimeEntity> entities = null;
//        entities = roomTimeRepository.findByDateGreaterThanEqualAndDateLessThanEqualAndRomId(start, end,room);
        entities = roomTimeRepository.findByRangeDateAndRoom(start, end, room, active);
        return entities.stream().map(roomTimeConver::toModel).collect(Collectors.toList());
    }

    public boolean active(Integer id) {
        return roomTimeRepository.changeActive(id, true) > 0;
    }

    public boolean add(RoomTimeModel model) {
        model.setActive(false);
        model.setId(null);
        RoomTimeEntity entity = roomTimeConver.toEtity(model);
        entity.setRoom(roomRepository.getOne(model.getRoom().getId()));
        entity.setClasS(classRepository.getOne(model.getClasS().getId()));
        return roomTimeRepository.save(entity) != null;
    }

    public boolean delete(Integer id) {
        roomTimeRepository.deleteById(id);
        return true;
    }

    public Map<String, RoomTimeModel> getMapByDate(Date date, Integer room) {
        Map<String, RoomTimeModel> map = new HashMap<String, RoomTimeModel>();
        List<RoomTimeModel> list = findByDate(date, room);
        for (RoomTimeModel model : list) {
            int dayOfWeek = DateUtils.dayOfWeek(model.getDate());
            String key = dayOfWeek + "-" + model.getShift();
            map.put(key, model);
        }
        return map;
    }

    public Map<String, RoomTimeModel> getMapByDate(Date date, Integer room, boolean active) {
        Map<String, RoomTimeModel> map = new HashMap<String, RoomTimeModel>();
        Date end = DateUtils.getSunDay(date);
        Date start = DateUtils.getMonDay(date);
        List<RoomTimeModel> list = findByDate(start, end, room, active);
        for (RoomTimeModel model : list) {
            int dayOfWeek = DateUtils.dayOfWeek(model.getDate());
            String key = dayOfWeek + "-" + model.getShift();
            map.put(key, model);
        }
        return map;
    }

    public List<RoomTimeModel> findByDate(Date date) {
        List<RoomTimeEntity> entities = roomTimeRepository.findByDate(date, true);

        List<RoomTimeModel> models = entities.stream().map(roomTimeConver::toModel).collect(Collectors.toList());
        models.sort((o1, o2) -> {
            return o1.getClasS().getTeacher().getId().compareTo(o2.getClasS().getTeacher().getId());
        });
        return models;
    }

    public List<RoomTimeModel> findStatisticalByClass(Integer idClass){
        List<RoomTimeEntity> entities = roomTimeRepository.findStatisticalByClass(idClass);
        List<RoomTimeModel> models = entities.stream().map(roomTimeConver::toModel).collect(Collectors.toList());
        return models;
    }


    public RoomTimeModel findById(Integer id) {
        RoomTimeEntity entity = roomTimeRepository.findById(id).get();
        return roomTimeConver.toModel(entity);
    }
}
