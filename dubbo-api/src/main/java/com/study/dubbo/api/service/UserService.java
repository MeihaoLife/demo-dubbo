package com.study.dubbo.api.service;

import com.study.dubbo.api.dto.UserDTO;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/17 3:25 下午
 * @Version: v1.0
 **/
public interface UserService {

    UserDTO userInfo(String userId);
}
