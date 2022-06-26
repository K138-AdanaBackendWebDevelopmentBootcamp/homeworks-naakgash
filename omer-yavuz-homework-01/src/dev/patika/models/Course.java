package dev.patika.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 1-fields 2-constructors 3-methods 4-getter&setter 5-equals&hashCode&toString
public class Course {
    //fields
    private String name;
    private String code; // such as Math101
    private int creditScore;
    private Instructor instructor;
    private List<Student> students = new ArrayList<>();

    //constructors
    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(String name, String code, int creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }

    //methods

    //getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //equals&hashCode&toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}
