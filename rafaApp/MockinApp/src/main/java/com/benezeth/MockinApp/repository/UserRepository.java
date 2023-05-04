package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //All crud methods for database
}
