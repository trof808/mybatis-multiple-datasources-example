package com.mybatisexample.demo;

import com.mybatisexample.demo.mapper.clickhouse.TestLaunchMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.clickhouse", sqlSessionFactoryRef="sqlSessionClickHouse")
public class MyBatisClickhouse {

    @Bean(name = "dataSourceClickHouse")
    public DataSource dataSourceClickHouse() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("ru.yandex.clickhouse.ClickHouseDriver");
        dataSourceBuilder.url("jdbc:clickhouse://10.36.7.95:8123/default");
        dataSourceBuilder.username("default");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionClickHouse")
    @Primary
    public SqlSessionFactory sqlSessionFactoryClickHouse() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceClickHouse());
        return factoryBean.getObject();
    }

//    @Bean
//    @Primary
//    public TestLaunchMapper testLaunchMapper1() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryClickHouse());
//        return sqlSessionTemplate.getMapper(TestLaunchMapper.class);
//    }
}
