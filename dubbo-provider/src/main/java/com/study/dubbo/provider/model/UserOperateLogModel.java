package com.study.dubbo.provider.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName: UserOperateLog
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/13 2:44 下午
 * @Version: v1.0
 **/
@Data
@Accessors(chain = true)
@TableName("t_user_operate_log")
public class UserOperateLogModel extends Model<UserOperateLogModel> {

    private Long id;

    private Long userId;

    private Date operateTime;

    private String operateDesc;

    private Byte operateResult;

    private String handlerClass;

    private String handlerMethod;

}
