package com.nmhung.conver;

import com.nmhung.entity.RoomEntity;
import com.nmhung.model.RoomModel;
import org.springframework.stereotype.Component;

@Component
public class RoomConver extends AbstractConver<RoomEntity, RoomModel> {
    @Override
    public RoomModel toModel(RoomEntity entity) {
        if(entity == null){
            return null;
        }
        return modelMapper.map(entity,RoomModel.class);
    }

    @Override
    public RoomEntity toEtity(RoomModel model) {
        return modelMapper.map(model,RoomEntity.class);
    }
}
