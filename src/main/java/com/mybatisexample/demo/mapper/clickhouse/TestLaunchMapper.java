package com.mybatisexample.demo.mapper.clickhouse;

import com.mybatisexample.demo.TestLaunch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface TestLaunchMapper {

    @Select("SELECT * FROM test_launches limit 10")
    List<TestLaunch> findAll();

}
