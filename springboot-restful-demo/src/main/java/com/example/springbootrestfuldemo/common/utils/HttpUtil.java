package com.example.springbootrestfuldemo.common.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
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

    public static String get(String url) {
        ResponseEntity<String> responseEntity = httpUtil.restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }
    public static <T> T  postForEntity(String url,Object object ,Class<T> responseType) {
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.postForEntity(url, object, responseType);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }
    public static <T> T  postForUTF8(String url,Object object ,Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(object, httpHeaders);
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.postForEntity(url, httpEntity, responseType);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    public static <T> T getForEntity(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.getForEntity(url,responseType);
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }


    public static <T> T get(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = httpUtil.restTemplate.getForEntity(url, responseType);
        return responseEntity.getBody();
    }

    public static String post(String url,String object) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<String> cookies = new ArrayList<>();
        cookies.add("R_SESS=token-w8k65:6g9zzdbb7j88nrmbwms5d5pv4zhtztjf5kx29ht9k5424dkz7rg7h6");
        httpHeaders.put(HttpHeaders.COOKIE,cookies);
        HttpEntity<String> httpEntity =  new HttpEntity<>(object,httpHeaders);
        ResponseEntity<String> responseEntity = httpUtil.restTemplate.postForEntity(url,httpEntity,String.class);
        return responseEntity.getBody();
    }
}
