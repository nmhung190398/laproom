package com.nmhung.conver;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;


abstract class AbstractConver<E, M> {
    protected ModelMapper modelMapper = new ModelMapper();
    protected Gson gson;
    public abstract M toModel(E entity);
    public abstract E toEtity(M model);

    public AbstractConver() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
//                .setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        this.gson = new Gson();
    }
}
