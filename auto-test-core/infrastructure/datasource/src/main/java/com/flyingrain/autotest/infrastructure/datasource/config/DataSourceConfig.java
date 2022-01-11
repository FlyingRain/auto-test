package com.flyingrain.autotest.infrastructure.datasource.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.flyingrain.autotest.infrastructure.datasource.mapper")
public class DataSourceConfig {
}
