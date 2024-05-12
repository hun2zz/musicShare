package com.jsp;

import java.util.Objects;

public class User {
    private String id;
    private String password;
    private String email;
    private int age;
    private String name;
    private String nickname;
    private final Gender gender;


    public User(String id, String password, String email, int age, String name, String nickname, Gender gender) {
        this.password = password;
        this.id = id;
        this.email = email;
        this.age = age;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, age, name, nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
