package com.zhouzhou.spring.pojo;

/**
 * @author 周万宁
 * @className User
 * @create 2023/1/1-3:40
 * @description
 */
public class User {
    private  Integer id;
    private  String username;
    private String gender;
    private Integer age;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public User(Integer id, String username, String gender, Integer age, String email) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
