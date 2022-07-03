package dev.patika.controllers;

import dev.patika.models.Student;
import dev.patika.services.StudentService;

import java.util.List;

public class StudentController {
    private final StudentService studentService = new StudentService();

    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    public Student findStudentById(int id){
        return studentService.findById(id);
    }

    public void saveStudent(Student student){
        studentService.saveToDataBase(student);
    }

    public void deleteStudent(Student student){
        studentService.deleteFromDataBase(student);
    }

    public void deleteStudent(int id){
        studentService.deleteFromDataBase(id);
    }

    public void deleteStudentWithPrimaryId(int id){
        studentService.deleteStudentWithId(id);
    }

    public void updateStudent(Student student){
        studentService.updateOnDataBase(student);
    }
}
