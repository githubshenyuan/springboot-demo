package com.example.springbootswagger2demo.entity;

import java.util.UUID;

/**
 * @author sh_home on 2018/11/9 15:44
 * @version ideaIU-2018.2.3.win
 */
public class UserEntity {
    private String uuid;
    private String username;
    private String password;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
