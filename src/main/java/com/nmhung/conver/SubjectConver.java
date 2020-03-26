package com.nmhung.conver;

import com.nmhung.entity.SubjectEntity;
import com.nmhung.model.SubjectModel;
import org.springframework.stereotype.Component;

@Component
public class SubjectConver extends AbstractConver<SubjectEntity, SubjectModel> {
    @Override
    public SubjectModel toModel(SubjectEntity entity) {
        if(entity == null){
            return null;
        }
        return modelMapper.map(entity,SubjectModel.class);
    }

    @Override
    public SubjectEntity toEtity(SubjectModel model) {
        return modelMapper.map(model,SubjectEntity.class);
    }
}
