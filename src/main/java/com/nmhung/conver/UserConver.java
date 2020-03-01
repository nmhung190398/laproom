package com.nmhung.conver;

import com.nmhung.entity.UserEntity;
import com.nmhung.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConver extends AbstractConver<UserEntity, UserModel>{
    @Override
    public UserModel toModel(UserEntity entity) {
        if(entity == null){
            return null;
        }
        return modelMapper.map(entity,UserModel.class);
    }

    @Override
    public UserEntity toEtity(UserModel model) {
        return modelMapper.map(model,UserEntity.class);
    }
}
