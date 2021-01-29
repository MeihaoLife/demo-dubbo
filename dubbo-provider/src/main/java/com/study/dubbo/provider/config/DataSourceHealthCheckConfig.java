package com.study.dubbo.provider.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName: DataSourceHealthCheckConfig
 * @Description: 解决数据源健康检测失败异常
 * ConnectionCallback; isValid; nested exception is java.sql.SQLFeatureNotSupportedException: isValid
 * @Author: zhānghào
 * @Date: 2021/1/15 7:08 下午
 * @Version: v1.0
 **/
@Configuration
public class DataSourceHealthCheckConfig extends DataSourceHealthContributorAutoConfiguration {

    @Value("${spring.datasource.validation-query:select 1}")
    private String defaultQuery;


    public DataSourceHealthCheckConfig(Map<String, DataSource> dataSources, ObjectProvider<DataSourcePoolMetadataProvider> metadataProviders) {
        super(dataSources, metadataProviders);
    }

    @Override
    protected AbstractHealthIndicator createIndicator(DataSource source) {
        DataSourceHealthIndicator indicator = (DataSourceHealthIndicator) super.createIndicator(source);
        if (!StringUtils.hasText(indicator.getQuery())) {
            indicator.setQuery(defaultQuery);
        }
        return indicator;
    }
}
