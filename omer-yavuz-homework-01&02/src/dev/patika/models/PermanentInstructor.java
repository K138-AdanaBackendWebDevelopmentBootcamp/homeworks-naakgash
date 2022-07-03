package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {
    //fields
    private double fixedSalary;

    //constructors
    public PermanentInstructor() {
        super();
    }

    public PermanentInstructor(String name) {
        super(name);
    }

    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    //getter&setter
    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
