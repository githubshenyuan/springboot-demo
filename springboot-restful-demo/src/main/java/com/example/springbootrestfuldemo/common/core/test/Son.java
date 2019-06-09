package com.example.springbootrestfuldemo.common.core.test;

/**
 * @author sh on 2019/6/8 23:11
 * @version ideaIU-2018.2.3.win_home
 */
public class Son extends Father {


    private String sonName;

    Son() {

    }

    Son(String sonName) {
        super("name","pass");
        this.sonName = sonName;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }


    public static void main(String[] args) {

        Son son = new Son("sonName");

        System.out.println(son);
    }
}
