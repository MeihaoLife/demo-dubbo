package com.study.dubbo.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName: UserOperateLogDTO
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/13 5:37 下午
 * @Version: v1.0
 **/
@Data
@Builder
@SuppressWarnings("serial")
public class UserOperateLogDTO implements Serializable {

    private Long userId;

    private Date operateTime;

    private String operateDesc;

    private Byte operateResult;

}
