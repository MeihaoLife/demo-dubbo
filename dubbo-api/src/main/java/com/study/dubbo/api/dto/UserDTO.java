package com.study.dubbo.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserDTO
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/17 3:25 下午
 * @Version: v1.0
 **/
@Data
@Builder
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    private long userId;

    private String userName;

}
