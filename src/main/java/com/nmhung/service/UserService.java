package com.nmhung.service;

import com.nmhung.conver.UserConver;
import com.nmhung.entity.UserEntity;
import com.nmhung.model.UserModel;
import com.nmhung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConver userConver;

    public UserModel findById(Integer id){
        UserEntity entity = userRepository.findById(id).get();
        return userConver.toModel(entity);
    }

    public UserModel login(String username,String password){
        UserEntity entity = userRepository.findByUsernameAndPassword(username,password);
        UserModel userModel = userConver.toModel(entity);
        return userModel;
    }
    public List<UserModel> findAll(){
        List<UserModel> userModels = new ArrayList<>();
        userModels = userRepository.findAll().stream().map(userConver::toModel).collect(Collectors.toList());
        return userModels;
    }

    public boolean add(UserModel model){
        model.setId(null);
        UserEntity entity = userConver.toEtity(model);
        entity = userRepository.save(entity);
        return entity == null;
    }

    public boolean eidt(UserModel model){
        if(model.getId() == null){
            return false;
        }
        UserEntity entity = userConver.toEtity(model);
        entity = userRepository.save(entity);
        return entity == null;
    }

    public boolean del(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
