package com.atguigu.mySpring;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", classroom=" + classroom + "]";
    }
}