package com.ttttse.entity;

import lombok.Data;

@Data
public class MyUserInfo {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    /*
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
     */
}