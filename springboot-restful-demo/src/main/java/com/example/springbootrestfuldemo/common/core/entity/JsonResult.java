package com.example.springbootrestfuldemo.common.core.entity;

/**
 * @author sh on 2019/6/2 1:38
 * @version ideaIU-2018.2.3.win_home
 */
public class JsonResult {

    private boolean status;
    private String code;
    private String msg;

    public JsonResult(){}
    public JsonResult(boolean status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }


    public static JsonResult success() {
        return new JsonResult(true, "200", "success");
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
