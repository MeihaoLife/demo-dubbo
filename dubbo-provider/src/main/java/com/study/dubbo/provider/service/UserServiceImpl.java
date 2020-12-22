package com.study.dubbo.provider.service;

import com.study.dubbo.api.dto.UserDTO;
import com.study.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/22 4:44 下午
 * @Version: v1.0
 **/
@DubboService(timeout = 1000)
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO userInfo(String userId) {
        UserDTO userDTO = UserDTO.builder().userId(123).userName("zhanghao").build();
        return userDTO;
    }
    
}
