package dev.patika.controllers;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.services.CourseService;
import dev.patika.services.InstructorService;

import java.util.List;

public class InstructorController {
    private final InstructorService instructorService = new InstructorService();

    public List<Instructor> findAllInstructors(){
        return instructorService.findAll();
    }

    public Instructor findInstructorById(int id){
        return instructorService.findById(id);
    }

    public void saveInstructor(Instructor instructor){
        instructorService.saveToDataBase(instructor);
    }

    public void deleteInstructor(Instructor course){
        instructorService.deleteFromDataBase(course);
    }

    public void deleteInstructor(int id){
        instructorService.deleteFromDataBase(id);
    }

    public void deleteInstructorWithPrimaryId(int id){
        instructorService.deleteInstructorWithId(id);
    }

    public void updateInstructor(Instructor instructor){
        instructorService.updateOnDataBase(instructor);
    }
}
