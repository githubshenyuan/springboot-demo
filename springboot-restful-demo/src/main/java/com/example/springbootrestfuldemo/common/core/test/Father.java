package com.example.springbootrestfuldemo.common.core.test;

/**
 * @author sh on 2019/6/8 23:10
 * @version ideaIU-2018.2.3.win_home
 */
public class Father {
    private String name;
    private String pass;

    Father() {

    }

    Father(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
