package dev.patika.controllers;

import dev.patika.models.Course;
import dev.patika.services.CourseService;

import java.util.List;
// usually controllers have not business logic
public class CourseController {
    private final CourseService courseService = new CourseService();

    public List<Course> findAllCourses(){
        return courseService.findAll();
    }

    public Course findCourseById(int id){
        return courseService.findById(id);
    }

    public void saveCustomer(Course course){
        courseService.saveToDataBase(course);
    }

    public void deleteCustomer(Course course){
        courseService.deleteFromDataBase(course);
    }

    public void deleteCustomer(int id){
        courseService.deleteFromDataBase(id);
    }

    public void deleteCustomerWithPrimaryId(int id){
        courseService.deleteCourseWithId(id);
    }

    public void updateCourse(Course course){
        courseService.updateOnDataBase(course);
    }

}
