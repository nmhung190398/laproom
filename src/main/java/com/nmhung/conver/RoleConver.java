package com.nmhung.conver;

import com.nmhung.entity.RoleEntity;
import com.nmhung.model.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleConver extends AbstractConver<RoleEntity, RoleModel> {
    @Override
    public RoleModel toModel(RoleEntity entity) {
        if(entity == null){
            return null;
        }
        return modelMapper.map(entity,RoleModel.class);
    }

    @Override
    public RoleEntity toEtity(RoleModel model) {
        return modelMapper.map(model,RoleEntity.class);
    }
}
