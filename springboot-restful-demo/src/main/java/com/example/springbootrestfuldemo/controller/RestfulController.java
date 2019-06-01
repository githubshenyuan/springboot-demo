package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.common.core.entity.JsonResult;
import com.example.springbootrestfuldemo.common.utils.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sh on 2019/6/2 1:43
 * @version ideaIU-2018.2.3.win_home
 */
@RestController
@RequestMapping("rest")
public class RestfulController {

    @RequestMapping("get")
    public String get() {

        JsonResult jsonResult = HttpUtil.postForUTF8("http://localhost:8181/post", JsonResult.success(), JsonResult.class);
        System.out.println(jsonResult.toString());

        return "";
    }
}
