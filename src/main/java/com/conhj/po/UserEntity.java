package com.conhj.po;

import java.util.Objects;

public class UserEntity {
    private int id;
    private String name;
    private String sex;
    private Integer age;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(age, that.age) &&
                Objects.equals(pwd, that.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, pwd);
    }
}
