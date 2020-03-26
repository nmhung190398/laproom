package com.nmhung.repository;

import com.nmhung.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsernameAndPassword(String username,String password);
}
