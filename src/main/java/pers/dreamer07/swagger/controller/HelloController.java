package pers.dreamer07.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import pers.dreamer07.swagger.pojo.User;

/**
 * @program: swagger
 * @description:
 * @author: EMTKnight
 * @create: 2021-03-15
 **/
@Api("用户请求接口")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    /* 标注了 @ApiModel(@ApiModelProperty) 的注解的实体类，只有作为 响应数据/请求数据 出现时才会被扫描  */
    @GetMapping("/user")
    public User getUser(){
        return new User("阿巴巴", "1237");
    }
    @PostMapping("/user2")
    public User postUser(@RequestBody User user){
        return user;
    }

    @ApiOperation("获取 hello2")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String userName){
        return userName;
    }
}
