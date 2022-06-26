package dev.patika.models;

public class PermanentInstructor extends Instructor {
    //fields
    private double hourlySalary;

    //constructors
    public PermanentInstructor() {
        super();
    }

    public PermanentInstructor(String name) {
        super(name);
    }

    public PermanentInstructor(String name, String address, String phoneNumber, double salary, double hourlySalary) {
        super(name, address, phoneNumber, salary);
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
