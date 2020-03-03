package com.nmhung.repository.custom;

import com.nmhung.model.ClassDTO;

import java.util.List;

public interface ClassRepositoryCustom {
    List<ClassDTO> getStatistical(int idSubject);
}
