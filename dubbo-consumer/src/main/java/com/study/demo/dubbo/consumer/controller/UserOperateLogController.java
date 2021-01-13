package com.study.demo.dubbo.consumer.controller;
import com.study.dubbo.api.dto.UserOperateLogDTO;
import com.study.dubbo.api.service.UserOperateLogService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @ClassName: UserOperateLogController
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/13 5:33 下午
 * @Version: v1.0
 **/
@RestController
@RequestMapping("/log")
public class UserOperateLogController {

    @DubboReference
    private UserOperateLogService userOperateLogService;

    @RequestMapping("/userOperateLog/generate")
    public UserOperateLogDTO generateUserOperateLog() {

        long userId = new Random().nextInt(1000);
        UserOperateLogDTO userOperateLogDTO = UserOperateLogDTO.builder()
                .userId(userId)
                .operateDesc(userId + ":保存")
                .operateResult((byte)1)
                .build();
        boolean result = userOperateLogService.save(userOperateLogDTO);
        return userOperateLogDTO;
    }

    @RequestMapping(value = "/userOperateLog/query/{userId}", method = RequestMethod.GET)
    public List<UserOperateLogDTO> generateUserOperateLog(@PathVariable("userId") long userId) {
        UserOperateLogDTO userOperateLogDTO = UserOperateLogDTO.builder()
                .userId(userId).build();
        userOperateLogDTO.setUserId(userId);
        return userOperateLogService.getList(userOperateLogDTO);
    }
}
