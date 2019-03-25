package com.ouqicha.europebusiness.bean.vo;

import java.util.List;

public class User {
    private String name;
    private List<String> course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }
}
