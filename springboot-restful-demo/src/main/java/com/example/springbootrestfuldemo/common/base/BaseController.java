package com.example.springbootrestfuldemo.common.base;

import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author sh on 2019/3/24 17:13
 * @version ideaIU-2018.2.3.win_home
 */
public class BaseController {
    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;

    public void downloadFile(File file) throws FileNotFoundException {
        downloadFile(new FileInputStream(file), file.getName());
    }

    public void downloadFile(InputStream inputStream ,String fileName) {
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            FileCopyUtils.copy(inputStream, response.getOutputStream());

        } catch (IOException ex) {
            System.out.println("[文件下载][异常]");
        }

    }


}
