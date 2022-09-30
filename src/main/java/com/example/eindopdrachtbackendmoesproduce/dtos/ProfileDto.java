package com.example.eindopdrachtbackendmoesproduce.dtos;

import javax.persistence.Column;

public class ProfileDto {

    private String username;

    private String firstName;


    private String lastName;

    private int age;

    public ProfileDto() {
    }

    public ProfileDto(String username, String firstName, String lastName, int age) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
