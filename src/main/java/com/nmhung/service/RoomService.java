package com.nmhung.service;

import com.nmhung.conver.RoomConver;
import com.nmhung.entity.RoomEntity;
import com.nmhung.entity.UserEntity;
import com.nmhung.model.RoomModel;
import com.nmhung.model.UserModel;
import com.nmhung.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomConver roomConver;

    public List<RoomModel> findAll(){
        List<RoomModel> models = new ArrayList<>();
        models = roomRepository.findAll().stream().map(roomConver::toModel).collect(Collectors.toList());
        return models;
    }
    public RoomModel findById(Integer id){
        Optional<RoomEntity> entity = roomRepository.findById(id);
        return entity.isPresent()? roomConver.toModel(entity.get()) : null;
    }

    public boolean add(RoomModel model){
        model.setId(null);
        RoomEntity entity = roomConver.toEtity(model);
        entity = roomRepository.save(entity);
        return entity == null;
    }

    public boolean eidt(RoomModel model){
        if(model.getId() == null){
            return false;
        }
        RoomEntity entity = roomConver.toEtity(model);
        entity = roomRepository.save(entity);
        return entity == null;
    }

    public boolean del(Integer id){
        try{
            roomRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }




}
