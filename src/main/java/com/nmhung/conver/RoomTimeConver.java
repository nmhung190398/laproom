package com.nmhung.conver;

import com.nmhung.entity.RoomEntity;
import com.nmhung.entity.RoomTimeEntity;
import com.nmhung.model.RoomModel;
import com.nmhung.model.RoomTimeModel;
import org.springframework.stereotype.Component;

@Component
public class RoomTimeConver extends AbstractConver<RoomTimeEntity, RoomTimeModel> {
    @Override
    public RoomTimeModel toModel(RoomTimeEntity entity) {
        if(entity == null){
            return null;
        }
        return modelMapper.map(entity,RoomTimeModel.class);
    }

    @Override
    public RoomTimeEntity toEtity(RoomTimeModel model) {
        return modelMapper.map(model,RoomTimeEntity.class);
    }
}
