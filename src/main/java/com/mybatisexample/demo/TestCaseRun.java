package com.mybatisexample.demo;

import java.sql.Timestamp;

public class TestCaseRun {
    private String testKey;
    private String status;
    private Timestamp startDate;
    private Timestamp endDate;
    private String userKey;
    private String testRunKey;
    private String testPlanKey;

    public TestCaseRun() {
    }

    public String getTestKey() {
        return testKey;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public String getUserKey() {
        return userKey;
    }

    public String getTestPlanKey() {
        return testPlanKey;
    }

    public String getTestRunKey() {
        return testRunKey;
    }

    public void setTestRunKey(String testRunKey) {
        this.testRunKey = testRunKey;
    }

    public void setTestPlanKey(String testPlanKey) {
        this.testPlanKey = testPlanKey;
    }
}
