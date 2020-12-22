package com.study.demo.dubbo.consumer.controller;

import com.study.dubbo.api.dto.UserDTO;
import com.study.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/22 5:29 下午
 * @Version: v1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @DubboReference(connections = 1000, cluster = "failover")
    private UserService userService;

    @RequestMapping("/userInfo")
    public UserDTO getUser() {
        return userService.userInfo("231");
    }

}
