package dev.patika.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 1-fields 2-constructors 3-methods 4-getter&setter 5-equals&hashCode&toString
@Entity
public class Student {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthdate;
    private String address;
    private boolean gender;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();
    //constructors
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, LocalDate birthdate, String address, boolean gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address; // true -> female :: false -> male
        this.gender = gender;
    }
    //methods

    //getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    //equals&hashCode&toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gender == student.gender && Objects.equals(name, student.name) && Objects.equals(birthdate, student.birthdate) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, address, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
