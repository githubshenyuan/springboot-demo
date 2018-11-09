package com.example.springbootswagger2demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sh_home on 2018/11/9 15:14
 * @version ideaIU-2018.2.3.win
 */
@EnableSwagger2
@Configuration
public class swagger2 {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger2demo.Controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("测试swagger2")
                // 创建人
                .contact(new Contact("sh", "", "xxxx.xxx.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("测试")
                .build();
    }
}
