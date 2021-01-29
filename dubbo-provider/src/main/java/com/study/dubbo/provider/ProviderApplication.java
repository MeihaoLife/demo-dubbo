package com.study.dubbo.provider;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: ProviderApplication
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/22 4:42 下午
 * @Version: v1.0
 **/
@SpringBootApplication
@MapperScan("com.study.dubbo.provider.mapper")
@EnableDistributedTransaction
@EnableTransactionManagement
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}
