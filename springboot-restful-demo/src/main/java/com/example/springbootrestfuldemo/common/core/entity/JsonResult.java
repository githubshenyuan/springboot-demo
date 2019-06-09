package com.example.springbootrestfuldemo.common.core.entity;

import java.util.Collection;

/**
 * @author sh 2019/3/21 16:26
 * @version ideaIU-2018.2.5.win
 */
public class JsonResult<T> {
    private Boolean status;
    private String code;
    private String msg;
    private Collection<T> datas;
    private T data;
    private Object object;

    /**
     * 空的构造函数
     */
    public JsonResult() {

    }
    /**
     * 构造函数
     */
    public JsonResult(Boolean status, String code, String msg, T data, Collection<T> datas) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.datas = datas;
    }


    public static <E> JsonResult<E> success() {
        return new JsonResult<E>(true, "200", "success", null, null);
    }

    public static <E> JsonResult<E> success(String msg) {
        return new JsonResult<E>(true, "200", msg, null, null);
    }
    public static <E> JsonResult<E> success( String code,String msg) {
        return new JsonResult<E>(true, code, msg, null, null);
    }
    public static <E> JsonResult<E> success(String code,String msg,E data) {
        return new JsonResult<E>(true, code, msg, data, null);
    }






    public static <E> JsonResult<E> error() {
        return new JsonResult<E>(false, null, null, null, null);
    }
    public static <E> JsonResult<E> error(String msg) {
        return new JsonResult<E>(false, null, msg, null, null);
    }
    public static <E> JsonResult<E> error(String code ,String msg) {
        return new JsonResult<E>(false, code, msg, null, null);
    }

    public static <E> JsonResult<E> error(Boolean status) {
        return new JsonResult<E>(status, null, null, null, null);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Collection<T> getDatas() {
        return datas;
    }

    public void setDatas(Collection<T> datas) {
        this.datas = datas;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", datas=" + datas +
                ", data=" + data +
                ", object=" + object +
                '}';
    }
}
