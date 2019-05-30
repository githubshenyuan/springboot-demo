package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.common.base.BaseController;
import com.example.springbootrestfuldemo.common.utils.HttpUtil;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sh on 2019/3/24 18:10
 * @version ideaIU-2018.2.3.win_home
 */
@RestController
public class FileController extends BaseController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("download")
    public String downloadFile() throws IOException {
        String url = "http://localhost:8181/download";
        downloadFile(HttpUtil.downloadFile(url), "123.md");

        return "success";
    }
}
