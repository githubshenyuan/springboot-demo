package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.common.utils.PathUtil;
import com.example.springbootjpademo.entity.UserEntity;
import com.example.springbootjpademo.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sh on 2019/4/13 21:06
 * @version ideaIU-2018.2.3.win_home
 */
@RestController
public class GetController {
    @Resource
    UserServiceImpl userService;

    Logger logger = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "get")
    public String get() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String a = "ip地址: " + addr.getHostAddress() + "\n 版本号:1.7 \n 1:1 \n 1:1 \n 1:1 \n 1:1 \n 1:1 ";
        logger.info(a);

        return a;
    }
    @RequestMapping(value = "ex")
    public String set() {
        int b = 1 / 0;
        String a = "";
        System.out.println();
        return "";
    }

    @RequestMapping(value = "user")
    public String getUser() {
        UserEntity userEntity = userService.get();
        if (userEntity == null) {
            return null;
        }
        String a = PathUtil.getTmpPath();

        if (StringUtils.isEmpty(a)) {
            return null;
        }

        return "user";
    }
}
