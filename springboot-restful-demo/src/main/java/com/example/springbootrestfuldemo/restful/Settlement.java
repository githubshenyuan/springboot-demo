package com.example.springbootrestfuldemo.restful;

import com.example.springbootrestfuldemo.common.core.entity.JsonResult;
import retrofit2.http.GET;

/**
 * @author sh 2019/6/6 16:59
 * @version ideaIU-2018.2.5.win
 */

public interface Settlement {

    @GET(value = "get")
    JsonResult get();
}
