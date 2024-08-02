package com.atguigu.mySpring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class School {
    private String[] address;
    private List<String> stringList;
    private List<Classroom> classroomList;
    private Set<Student> studentSet;
    private Map<String, Student> classroomStudentMap;

    public School(String[] address, List<String> stringList, List<Classroom> classroomList, Set<Student> studentSet, Map<String, Student> classroomStudentMap) {
        this.address = address;
        this.stringList = stringList;
        this.classroomList = classroomList;
        this.studentSet = studentSet;
        this.classroomStudentMap = classroomStudentMap;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<String, Student> getClassroomStudentMap() {
        return classroomStudentMap;
    }

    public void setClassroomStudentMap(Map<String, Student> classroomStudentMap) {
        this.classroomStudentMap = classroomStudentMap;
    }
}
