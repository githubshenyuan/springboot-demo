package com.example.springbootelkdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ElkController {
    private static final Logger logger = LoggerFactory.getLogger(ElkController.class);
    @Value("${user.dir}")
    public  String dir;

    @RequestMapping("ng")
    public String nginx(String name, String pass) {
        System.out.println(dir);
        System.out.println("姓名：" + name + "密码" + pass);

        logger.info("test info");
        logger.warn("test warn");
        logger.error("test error");
        logger.debug("test debug");

        return "<p>370405198910204031</p>";
    }

    @RequestMapping("elk1")
    public String demo1() {
        MDC.put("processName", "投保流程");
        String radom = String.valueOf((int) ((Math.random() * 9 + 1) * 10000000))
                + String.valueOf((int) ((Math.random() * 9 + 1) * 10000000));
        MDC.put("processId", radom);


        logger.info("投保开始");
        logger.info("数据校验通过");
        logger.info("投保主数据入库");
        logger.info("保险人信息入库");
        logger.info("被保险人入库");
        logger.error("被保险人入库失败,数据回滚，请尽快处理");
        int a = 1 / 0;



        return "demo1";

    }
    @RequestMapping("elk2")
    public String demo2() {
        MDC.put("processName", "退保流程");
        String radom = String.valueOf((int) ((Math.random() * 9 + 1) * 10000000)) +
                String.valueOf((int) ((Math.random() * 9 + 1) * 10000000));
        MDC.put("processId", radom);

        logger.info("退保开始");
        logger.info("退保数据校验通过");
        logger.info("调用第三方接口进行退保操作");
        logger.error("接口调用失败，回退所有操作，请尽快处理");
        if (true) {
            throw new RuntimeException();
        }
        return "demo2";

    }
    @RequestMapping("elk3")
    public String demo3() {
        String uuid = UUID.randomUUID().toString();
        MDC.put("processName", "定时送数据流程");
        MDC.put("processId", uuid);
        logger.info("定时开始");
        logger.info("定时调用接口送数据");
        logger.error("接口调用失败，回退所有操作，请尽快处理");
        uuid = UUID.randomUUID().toString();
        MDC.put("processId", uuid);
        logger.info("定时开始");
        logger.info("定时调用接口送数据");
        logger.error("接口调用失败，回退所有操作，请尽快处理");
        return "demo2";

    }

    public static void main(String[] args) {
        String radom = String.valueOf((int) ((Math.random() * 9 + 1) * 10000000)) +
                String.valueOf((int) ((Math.random() * 9 + 1) * 10000000));
        System.out.println(radom);
    }
}
