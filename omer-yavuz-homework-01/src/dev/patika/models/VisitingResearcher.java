package dev.patika.models;

public class VisitingResearcher extends Instructor {
    //fields
    private double fixedSalary;

    //constructors
    public VisitingResearcher() {
        super();
    }

    public VisitingResearcher(String name) {
        super(name);
    }

    public VisitingResearcher(String name, String address, String phoneNumber, double salary, double hourlySalary) {
        super(name, address, phoneNumber, salary);
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
