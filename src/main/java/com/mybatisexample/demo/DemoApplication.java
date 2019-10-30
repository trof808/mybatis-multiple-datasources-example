package com.mybatisexample.demo;

import com.mybatisexample.demo.domain.TestCaseRun;
import com.mybatisexample.demo.domain.TestLaunch;
import com.mybatisexample.demo.mapper.postgres.TestCaseRunMapper;
import com.mybatisexample.demo.mapper.clickhouse.TestLaunchMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final TestCaseRunMapper testCaseRunMapper;
	private final TestLaunchMapper testLaunchMapper;

	public DemoApplication(
			TestCaseRunMapper testCaseRunMapper,
			TestLaunchMapper testLaunchMapper
	) {
		this.testCaseRunMapper = testCaseRunMapper;
		this.testLaunchMapper = testLaunchMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<TestCaseRun> testCaseRuns = testCaseRunMapper.findAll();
		System.out.println(testCaseRuns);

		List<TestLaunch> testLaunches = testLaunchMapper.findAll();
		System.out.println(testLaunches);

		System.out.println("Hello");
	}
}
