package com.example.student_library_management_system.responsedto;

import jakarta.persistence.Column;

public class StudentResponseDto {

    // response dto - response data transfer object - it is used to take required output or response fields

    private String name;
    private String dept;
    private String sem;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
