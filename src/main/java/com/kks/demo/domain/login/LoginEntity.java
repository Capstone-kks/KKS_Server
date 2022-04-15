package com.kks.demo.domain.login;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="User")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //for auto increment
    private int userIndex;

    private String userId;
    private String nickName;
    private String userImg;

    @Builder
    public LoginEntity(String userId, String nickName, String userImg){
        this.userId = userId;
        this.nickName = nickName;
        this.userImg = userImg;
    }
}
