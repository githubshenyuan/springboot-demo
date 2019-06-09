package com.example.springbootjpademo.common.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sh 2019/3/22 13:32
 * @version ideaIU-2018.2.5.win
 */
public class BaseController {
    @Resource
    public HttpServletRequest request;
    @Resource
    public HttpServletResponse response;

}
