package com.mybatisexample.demo.domain;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Модель таблицы запусков тестов за билдах
 */
public class TestLaunch implements Comparable {

    private String testId;
    private int prId;
    private int jobId;
    private Timestamp jobDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private String uid;
    private String parentUid;
    private String targetBranch;
    private String jobType;
    private String node;
    private String exception;
    private String jobState;
    private List<String> steps;
    private String trace;

    public TestLaunch() {
    }

    public String getTestId() {
        return testId;
    }

    public String getJobType() {
        return jobType;
    }

    public int getPrId() {
        return prId;
    }

    public int getJobId() {
        return jobId;
    }

    public Timestamp getJobDate() {
        return jobDate;
    }

    public String getUid() {
        return uid;
    }

    public String getParentUid() {
        return parentUid;
    }

    public String getTargetBranch() {
        return targetBranch;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public List<String> getSteps() {
        return steps;
    }

    public String getNode() {
        return node;
    }

    public String getException() {
        return exception;
    }

    public String getJobState() {
        return jobState;
    }

    public String getTrace() {
        return trace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestLaunch testLaunch = (TestLaunch) o;
        return prId == testLaunch.prId &&
                jobId == testLaunch.jobId &&
                Objects.equals(testId, testLaunch.testId) &&
                Objects.equals(jobDate, testLaunch.jobDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, prId, jobId, jobDate);
    }

    @Override
    public int compareTo(Object o) {
        return this.jobId - ((TestLaunch) o).getJobId();
    }
}

