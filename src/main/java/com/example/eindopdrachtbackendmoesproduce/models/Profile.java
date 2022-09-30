package com.example.eindopdrachtbackendmoesproduce.models;


import javax.persistence.*;


@Entity
@Table(name = "user_profiles")
public class Profile {


    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;

    public Profile() {
    }

    public Profile(String username, String firstName, String lastName, int age) {
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
