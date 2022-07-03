package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {
    //fields
    private double hourlySalary;

    //constructors
    public VisitingResearcher() {
        super();
    }

    public VisitingResearcher(String name) {
        super(name);
    }

    public VisitingResearcher(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    //getter&setter

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
