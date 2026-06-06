package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Student {

    @Id
    private Integer roll;
    private String name;
    private String address;
    private String gender;

    public Student() {
    }

    public Student(Integer roll, String name, String address, String gender) {
        this.roll = roll;
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
