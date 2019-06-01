package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.common.core.base.BaseController;
import com.example.springbootrestfuldemo.common.utils.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.IOException;



/**
 * @author sh on 2019/3/24 18:10
 * @version ideaIU-2018.2.3.win_home
 */
@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("download")
    public String downloadFile() throws IOException {
        String url = "http://localhost:8181/download";
        downloadFile(HttpUtil.downloadFile(url), "123.md");

        return "success";
    }
    @RequestMapping("post")
    public String post() throws IOException {
        String url = "https://192.168.0.95/v3/project/c-9hnqm:p-n8fvx/workloads/deployment:default:rancher";
        String a = "{\n" +
                "    \"containers\": [{\n" +
                "        \"image\": \"192.168.0.40/rancher/rancher:latest\"\n" +
                "    }]\n" +
                "}";
        HttpUtil.post(url, a);

        return "success";
    }

    @RequestMapping("get")
    public String get(@PathParam(value = "url") String url) throws IOException {
        //String url = "https://www.baidu.com/";
        HttpUtil.get(url);

        return "success";
    }

}
