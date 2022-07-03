package dev.patika.controllers;

import dev.patika.models.PermanentInstructor;
import dev.patika.models.VisitingResearcher;
import dev.patika.services.PermanentInstructorService;
import dev.patika.services.VisitingResearcherService;

import java.util.List;

public class VisitingResearcherController {
    private final VisitingResearcherService visitingResearcherService = new VisitingResearcherService();

    public List<VisitingResearcher> findAllVisitingResearchers(){
        return visitingResearcherService.findAll();
    }

    public VisitingResearcher findVisitingResearcherById(int id){
        return visitingResearcherService.findById(id);
    }

    public void saveVisitingResearcher(VisitingResearcher visitingResearcher){
        visitingResearcherService.saveToDataBase(visitingResearcher);
    }

    public void deleteVisitingResearcher(VisitingResearcher visitingResearcher){
        visitingResearcherService.deleteFromDataBase(visitingResearcher);
    }

    public void deleteVisitingResearcher(int id){
        visitingResearcherService.deleteFromDataBase(id);
    }

    public void deleteVisitingResearcherWithPrimaryId(int id){
        visitingResearcherService.deleteVisitingResearcherWithId(id);
    }

    public void updateVisitingResearcher(VisitingResearcher visitingResearcher){
        visitingResearcherService.updateOnDataBase(visitingResearcher);
    }
}
