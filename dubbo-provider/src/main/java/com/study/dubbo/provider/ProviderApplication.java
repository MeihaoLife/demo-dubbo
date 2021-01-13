package com.study.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: ProviderApplication
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/22 4:42 下午
 * @Version: v1.0
 **/
@SpringBootApplication
@MapperScan("com.study.dubbo.provider.mapper")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}
