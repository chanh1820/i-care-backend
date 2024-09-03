package com.example.icare.sco;

import com.example.icare.sco.dto.SearchTextDTO;

public class EmployeeSCO extends BaseSCO{

    private SearchTextDTO firstName;

    private SearchTextDTO lastName;

    private SearchTextDTO email;

    private SearchTextDTO jobName;

//    private SearchNumberDTO minSalary;

    public EmployeeSCO() {
    }

    public SearchTextDTO getFirstName() {
        return firstName;
    }

    public void setFirstName(SearchTextDTO firstName) {
        this.firstName = firstName;
    }

    public SearchTextDTO getLastName() {
        return lastName;
    }

    public void setLastName(SearchTextDTO lastName) {
        this.lastName = lastName;
    }

    public SearchTextDTO getEmail() {
        return email;
    }

    public void setEmail(SearchTextDTO email) {
        this.email = email;
    }

    public SearchTextDTO getJobName() {
        return jobName;
    }

    public void setJobName(SearchTextDTO jobName) {
        this.jobName = jobName;
    }
}
