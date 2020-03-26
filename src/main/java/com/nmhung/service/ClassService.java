package com.nmhung.service;

import com.nmhung.conver.ClassConver;
import com.nmhung.entity.ClassEntity;
import com.nmhung.model.ClassModel;
import com.nmhung.repository.ClassRepository;
import com.nmhung.repository.SubjectRepository;
import com.nmhung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ClassConver classConver;

    public List<ClassModel> findAll(){
        List<ClassModel> models = classRepository.findAll().stream().map(classConver::toModel).collect(Collectors.toList());
        return models;
    }
    public ClassModel findById(Integer id){
        Optional<ClassEntity> entity = classRepository.findById(id);
        return entity.isPresent()? classConver.toModel(entity.get()) : null;
    }

    public boolean add(ClassModel model){
        model.setId(null);
        ClassEntity entity = classConver.toEtity(model);
        entity.setSubject(subjectRepository.getOne(entity.getSubject().getId()));
        entity.setTeacher(userRepository.getOne(entity.getTeacher().getId()));
        entity = classRepository.save(entity);
        return entity != null;
    }

    public boolean eidt(ClassModel model){
        if(model.getId() == null){
            return false;
        }
        ClassEntity entity = classConver.toEtity(model);
        entity = classRepository.save(entity);
        return entity != null;
    }

    public boolean del(Integer id){
        try{
            classRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public List<ClassModel> findByTeacher(Integer id) {
        List<ClassEntity> entities = classRepository.findByTeacherId(id);
        return entities.stream().map(classConver::toModel).collect(Collectors.toList());
    }

}
