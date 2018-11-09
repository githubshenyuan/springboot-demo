package com.example.springbootswagger2demo.Controller;

import com.example.springbootswagger2demo.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Password;

/**
 * @author sh_home on 2018/11/9 15:24
 * @version ideaIU-2018.2.3.win
 */
@RestController
@Api("用户操作类")
public class SwaggerController {
    @ApiOperation("查询用户")
    @GetMapping("/get")
    public String get(String name) {
        System.out.println("查询：" + name);

        return name;
    }
    @ApiOperation("注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",paramType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", paramType = "String")
    })
    @PostMapping("/set")
    public String set(String username, String password) {
        System.out.println("设置账号："+username+"设置密码："+password);
        return "success";
    }

    @PostMapping("/update")
    @ApiOperation("更新用户信息")
    @ApiImplicitParam(name = "userEntity", value = "用户信息", paramType = "UserEntity")
    public UserEntity update(UserEntity userEntity) {
        System.out.println(userEntity.toString());

        return userEntity;
    }

}
