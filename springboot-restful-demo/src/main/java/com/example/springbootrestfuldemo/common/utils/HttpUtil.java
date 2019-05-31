package com.example.springbootrestfuldemo.common.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * @author sh on 2019/3/24 20:31
 * @version ideaIU-2018.2.3.win_home
 */
@Component
public class HttpUtil {

    @Resource
    private RestTemplate restTemplate;
    private static HttpUtil httpUtil = new HttpUtil();

    @PostConstruct
    private void init() {
        httpUtil.restTemplate = this.restTemplate;
    }

    public static InputStream downloadFile(String url) throws IOException {
        // String url = "http://localhost:8181/download";
        HttpHeaders header = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        // 指定下载文件类型
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        header.setAccept(list);
        HttpEntity<byte[]> request = new HttpEntity<>(header);
        ResponseEntity<byte[]> response = httpUtil.restTemplate.exchange(url, HttpMethod.GET, request, byte[].class);
        // 取得文件字节
        byte[] result = response.getBody();
        HttpHeaders header1 = response.getHeaders();
        InputStream inputStream = new ByteArrayInputStream(result);

        List<String> res = response.getHeaders().get("Content-disposition");

        return inputStream;
    }

    public static <T> T get(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.getForEntity(url, responseType);
        return responseEntity.getBody();
    }

    public static <T> T post(String url, Class<T> responseType,Object object) {
        Class a =object.getClass();
        HttpEntity httpEntity = new HttpEntity(object, new HttpHeaders());
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.po(url, responseType);
        return responseEntity.getBody();
    }
}
