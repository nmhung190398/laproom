package com.nmhung.api;

import com.nmhung.model.UserModel;
import com.nmhung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {

    @Autowired
    UserService userService;

    @GetMapping("/api/user")
    ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> users = userService.findAll();
        return ResponseEntity.ok(users);
    }


}
