package dev.patika.controllers;

import dev.patika.models.PermanentInstructor;
import dev.patika.services.PermanentInstructorService;

import java.util.List;

public class PermanentInstructorController {
    private final PermanentInstructorService permanentInstructorService = new PermanentInstructorService();

    public List<PermanentInstructor> findAllPermanentInstructors(){
        return permanentInstructorService.findAll();
    }

    public PermanentInstructor findPermanentInstructorById(int id){
        return permanentInstructorService.findById(id);
    }

    public void savePermanentInstructor(PermanentInstructor permanentInstructor){
        permanentInstructorService.saveToDataBase(permanentInstructor);
    }

    public void deletePermanentInstructor(PermanentInstructor permanentInstructor){
        permanentInstructorService.deleteFromDataBase(permanentInstructor);
    }

    public void deletePermanentInstructor(int id){
        permanentInstructorService.deleteFromDataBase(id);
    }

    public void deletePermanentInstructorWithPrimaryId(int id){
        permanentInstructorService.deletePermanentInstructorWithId(id);
    }

    public void updatePermanentInstructor(PermanentInstructor permanentInstructor){
        permanentInstructorService.updateOnDataBase(permanentInstructor);
    }
}
