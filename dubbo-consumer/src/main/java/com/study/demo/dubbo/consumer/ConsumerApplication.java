package com.study.demo.dubbo.consumer;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: ConsumerApplication
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2020/12/22 5:28 下午
 * @Version: v1.0
 **/
@SpringBootApplication
@EnableDistributedTransaction
@EnableTransactionManagement
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
