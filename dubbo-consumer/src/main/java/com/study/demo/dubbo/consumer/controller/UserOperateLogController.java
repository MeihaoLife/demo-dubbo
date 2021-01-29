package com.study.demo.dubbo.consumer.controller;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import com.study.dubbo.api.dto.UserOperateLogDTO;
import com.study.dubbo.api.service.UserOperateLogService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.omg.SendingContext.RunTime;
import org.springframework.transaction.annotation.Transactional;
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

    /** 写入数据（master），读写分离&分库分表 **/
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

    /** 读取数据(slave)，读写分离&分库分表 **/
    @RequestMapping(value = "/userOperateLog/query/{userId}", method = RequestMethod.GET)
    public List<UserOperateLogDTO> generateUserOperateLog(@PathVariable("userId") long userId) {
        UserOperateLogDTO userOperateLogDTO = UserOperateLogDTO.builder()
                .userId(userId).build();
        userOperateLogDTO.setUserId(userId);
        return userOperateLogService.getList(userOperateLogDTO);
    }

    /** 分布式事务，产生异常会回滚事务，支持手动回滚 **/
    /** 熔断的时候可以手动回滚事务
     DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
     **/
    @LcnTransaction
    @Transactional
    @RequestMapping("/userOperateLog/lcn/generate")
    public UserOperateLogDTO generateUserOperateLogLCN() {

        String groupId = TracingContext.tracing().groupId();
        System.out.println("consumer groupId = " + groupId);
        long userId = new Random().nextInt(1000);
        UserOperateLogDTO userOperateLogDTO = UserOperateLogDTO.builder()
                .userId(userId)
                .operateDesc(userId + ":保存")
                .operateResult((byte)1)
                .build();
        System.out.println(userOperateLogDTO);
        boolean result = userOperateLogService.lcnSave(userOperateLogDTO);
        // 抛出异常分布式事务会回滚
        throw new RuntimeException();
    }
}
