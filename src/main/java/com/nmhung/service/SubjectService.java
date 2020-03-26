package com.nmhung.service;

import com.nmhung.conver.SubjectConver;
import com.nmhung.entity.SubjectEntity;
import com.nmhung.model.SubjectModel;
import com.nmhung.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectConver subjectConver;

    public List<SubjectModel> findAll(){
        List<SubjectModel> models = subjectRepository.findAll().stream().map(subjectConver::toModel).collect(Collectors.toList());
        return models;
    }
    public SubjectModel findById(Integer id){
        Optional<SubjectEntity> entity = subjectRepository.findById(id);
        return entity.isPresent()? subjectConver.toModel(entity.get()) : null;
    }

    public boolean add(SubjectModel model){
        model.setId(null);
        SubjectEntity entity = subjectConver.toEtity(model);
        entity = subjectRepository.save(entity);
        return entity == null;
    }

    public boolean eidt(SubjectModel model){
        if(model.getId() == null){
            return false;
        }
        SubjectEntity entity = subjectConver.toEtity(model);
        entity = subjectRepository.save(entity);
        return entity == null;
    }

    public boolean del(Integer id){
        try{
            subjectRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
