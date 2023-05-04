package com.benezeth.MockinApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_Info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "userId")
    int userID;
    @Column(name = "userName")
    String userName;
    @Column(name = "userPhoneNo")
    String userPhoneNo;
    @Column(name = "userAddress")
    String userAddress;
    @Column(name = "userJob")
    String userJob;
}
