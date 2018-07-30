package org.prezydium.cvmachine.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WorkExperience {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginningDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String jobName;

    private String description;

    public WorkExperience() {
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
