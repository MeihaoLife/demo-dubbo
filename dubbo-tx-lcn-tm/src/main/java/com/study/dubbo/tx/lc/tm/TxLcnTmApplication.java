package com.study.dubbo.tx.lc.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: TxLcnTmApplication
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/1/15 4:57 下午
 * @Version: v1.0
 **/
@SpringBootApplication
@EnableTransactionManagerServer
public class TxLcnTmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxLcnTmApplication.class,args);
    }
}
