package com.nmhung.conver;

import com.nmhung.entity.ClassEntity;
import com.nmhung.entity.UserEntity;
import com.nmhung.model.ClassModel;
import com.nmhung.model.UserModel;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ClassConver extends AbstractConver<ClassEntity, ClassModel> {
    @Override
    public ClassModel toModel(ClassEntity entity) {
        if(entity == null){
            return null;
        }
//        return gson.fromJson(gson.toJson(entity),ClassModel.class);
        return modelMapper.map(entity,ClassModel.class);
    }

    @Override
    public ClassEntity toEtity(ClassModel model) {
//        PropertyMap<ClassEntity, ClassModel> skipModifiedFieldsMap = new PropertyMap<ClassEntity, ClassModel>() {
//            protected void configure() {
//                skip().getIdTeacher();
//                skip().getIdSubject();
//            }
//        };
//        modelMapper.addMappings(skipModifiedFieldsMap);
//        return gson.fromJson(gson.toJson(model),ClassEntity.class);
        return modelMapper.map(model,ClassEntity.class);
    }
}
