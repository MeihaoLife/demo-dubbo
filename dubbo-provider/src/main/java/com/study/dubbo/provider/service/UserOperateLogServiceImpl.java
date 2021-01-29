package com.study.dubbo.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.study.dubbo.api.dto.UserOperateLogDTO;
import com.study.dubbo.api.service.UserOperateLogService;
import com.study.dubbo.provider.mapper.UserOperateLogMapper;
import com.study.dubbo.provider.model.UserOperateLogModel;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: IUserOperateLogService
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/13 2:53 下午
 * @Version: v1.0
 **/
@DubboService
public class UserOperateLogServiceImpl extends ServiceImpl<UserOperateLogMapper, UserOperateLogModel> implements UserOperateLogService {

    @Override
    public boolean save(UserOperateLogDTO userOperateLogDTO) {
        UserOperateLogModel model = new UserOperateLogModel();
        BeanUtils.copyProperties(userOperateLogDTO, model);
        return super.save(model);
    }

    @Override
    @Transactional
    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    public boolean lcnSave(UserOperateLogDTO userOperateLogDTO) {

        String groupId = TracingContext.tracing().groupId();
        System.out.println("consumer groupId = " + groupId);
        UserOperateLogModel model = new UserOperateLogModel();
        BeanUtils.copyProperties(userOperateLogDTO, model);
        return super.save(model);
    }

    @Override
    public List<UserOperateLogDTO> getList(UserOperateLogDTO userOperateLogDTO) {

        UserOperateLogModel userOperateLogModel = new UserOperateLogModel();
        BeanUtils.copyProperties(userOperateLogDTO, userOperateLogModel);
        if (userOperateLogModel.getUserId() == null) {
            return Collections.emptyList();
        }
        QueryWrapper<UserOperateLogModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userOperateLogModel.getUserId());
        List<UserOperateLogModel> userOperateLogModels = this.baseMapper.selectList(queryWrapper);
        if (userOperateLogModels.size() == 0) {
            return Collections.emptyList();
        }
        List<UserOperateLogDTO> returnList = new ArrayList<>(userOperateLogModels.size());
        userOperateLogModels.forEach(model -> returnList.add(UserOperateLogDTO.builder()
                .userId(model.getUserId())
                .operateTime(model.getOperateTime())
                .operateDesc(model.getOperateDesc())
                .operateResult(model.getOperateResult()).build()));

        return returnList;
    }
}
