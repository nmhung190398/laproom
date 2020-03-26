package com.nmhung.api;


import com.nmhung.model.ClassModel;
import com.nmhung.model.UserModel;
import com.nmhung.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassAPI {


    @Autowired
    ClassService classService;

    @GetMapping("/api/user/teacher/{id}")
    ResponseEntity<List<ClassModel>> findAll(@PathVariable Integer id){
        List<ClassModel> classes = classService.findByTeacher(id);
        return ResponseEntity.ok(classes);
    }
}
