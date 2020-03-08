package com.husky.microservicesimpleclient1.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "email")
    private String email;
    @Column(name = "head_img")
    private String headImg;
    @Column(name = "user_level")
    private String userLevel;
}
