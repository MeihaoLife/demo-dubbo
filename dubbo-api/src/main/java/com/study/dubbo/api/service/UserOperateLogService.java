package com.study.dubbo.api.service;

import com.study.dubbo.api.dto.UserOperateLogDTO;

import java.util.List;

/**
 * @ClassName: UserOperateLogService
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/13 5:36 下午
 * @Version: v1.0
 **/
public interface UserOperateLogService {

    boolean save(UserOperateLogDTO entity);

    List<UserOperateLogDTO> getList(UserOperateLogDTO userOperateLogModel);
}
