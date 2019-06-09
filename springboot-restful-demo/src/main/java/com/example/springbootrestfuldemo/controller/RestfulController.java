package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.common.core.entity.JsonResult;
import com.example.springbootrestfuldemo.common.utils.HttpUtil;
import com.example.springbootrestfuldemo.restful.Settlement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;

/**
 * @author sh on 2019/6/2 1:43
 * @version ideaIU-2018.2.3.win_home
 */
@RestController
@RequestMapping("rest")
public class RestfulController {

    @RequestMapping("get")
    public String get() {

        //JsonResult jsonResult = HttpUtil.postForUTF8("http://localhost:8181/post", JsonResult.success(), JsonResult.class);
        //System.out.println(jsonResult.toString());

        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
                //.addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("http://localhost:8181/")
                .build();
// 创建网络请求接口的实例
        Settlement mApi = retrofit.create(Settlement.class);
        JsonResult jsonResult = mApi.get();
        System.out.println(jsonResult.toString());

        return "";
    }
}
