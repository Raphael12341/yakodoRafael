package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.UserEntity;
import com.benezeth.MockinApp.exception.UserException;
import com.benezeth.MockinApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_info")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //code for getting all user info
    @GetMapping
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    //code for creating user
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }
    //code for getting user by id
    @GetMapping("{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id){
        UserEntity getUser = userRepository.findById(id)
                .orElseThrow(()->new UserException("User does not exist"));

                return ResponseEntity.ok(getUser);
    }
    //code for updating user
    @PutMapping("{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id,@RequestBody UserEntity userDetails ){
        UserEntity updateUser = userRepository.findById(id)
                .orElseThrow(()->new UserException("User does not exist"));

        updateUser.setUserID(userDetails.getUserID());
        updateUser.setUserPhoneNo(userDetails.getUserPhoneNo());
        updateUser.setUserJob(userDetails.getUserJob());
        updateUser.setUserName(userDetails.getUserName());
        updateUser.setUserAddress(updateUser.getUserAddress());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    //code for deleting
    @DeleteMapping("{id}")

    public ResponseEntity<UserEntity> deleteUser(long id){
        UserEntity user = userRepository.findById(id)
                .orElseThrow(()->new UserException("User does not exist"));

        userRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}
