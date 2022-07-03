package dev.patika.clients;

import dev.patika.controllers.*;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

// liquibase & flyway -> store database history
public class ManagementClient {
    public static void main(String[] args) {
        CourseController courseController = new CourseController();
        InstructorController instructorController = new InstructorController();
        PermanentInstructorController permanentInstructorController = new PermanentInstructorController();
        StudentController studentController = new StudentController();
        VisitingResearcherController visitingResearcherController = new VisitingResearcherController();

        if (checkTestData() == 0) {
            saveTestData();
        }

        System.out.println("***********************************************************************");

        List<Course> courseList = courseController.findAllCourses();
        for (Course course : courseList) {
            System.out.println(course);
        }

        System.out.println("***********************************************************************");

        List<Instructor> instructorList = instructorController.findAllInstructors();
        instructorList.forEach(System.out::println);

        //instructorList.forEach(x -> System.out.println(x));

        System.out.println("***********************************************************************");

        List<PermanentInstructor> PIList = permanentInstructorController.findAllPermanentInstructors();
        for (int i = 0; i < PIList.size(); i++) {
            System.out.println(PIList.get(i));
        }

        System.out.println("***********************************************************************");

        List<Student> studentList = studentController.findAllStudents();
        Iterator<Student> studentIterator1 = studentList.iterator();
        while(studentIterator1.hasNext()){
            System.out.println(studentIterator1.next());
        }

        /*Iterator<Student> studentIterator2 = studentList.listIterator();
        while(courseIterator2.hasNext()){
            System.out.println(studentIterator2.next());
        }*/

        System.out.println("***********************************************************************");

        List<VisitingResearcher> VRList = visitingResearcherController.findAllVisitingResearchers();
        VRList.forEach(new Consumer<VisitingResearcher>() {
            @Override // anonymous inner class
            public void accept(VisitingResearcher visitingResearcher) {
                System.out.println(visitingResearcher);
            }
        });

        // VRList.forEach((VisitingResearcher visitingResearcher) -> System.out.println(visitingResearcher));
        // VRList.forEach(visitingResearcher -> System.out.println(visitingResearcher));

        System.out.println("***********************************************************************");

        //System.out.println(permanentInstructorController.findPermanentInstructorById(2));
        // System.out.println(courseController.findCourseById(1));

        //Course newCourse = new Course("Yozgat Python Bootcamp", "PYTHON101", 400);
        //courseController.saveCustomer(newCourse);

        //List<Course> courseList = courseController.findAllCourses();
        //courseController.deleteCustomer(courseList.get(4));
        //courseController.deleteCustomer(6);
        //courseController.deleteCustomerWithPrimaryId(7);
        //courseList = courseController.findAllCourses();

        //Course foundCourse = courseList.get(0);
        //foundCourse.setCode("00000");
        //courseController.updateCourse(foundCourse);
    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("FROM Course", Course.class).getResultList().size();
    }

    private static void saveTestData() {
        Course course1 = new Course("Adana Java Bootcamp", "JAVA101", 100);
        Course course2 = new Course("Ankara .NET Bootcamp", ".NET101", 150);
        Course course3 = new Course("Istanbul React Bootcamp", "REACT101", 300);
        Course course4 = new Course("Izmir Angular Bootcamp", "ANG101", 250);

        Instructor PI1 = new PermanentInstructor("Selim Booz", "London", "55263", 1500);
        Instructor VR1 = new VisitingResearcher("Asle Kayne", "Madrid", "47752", 12);

        course1.setInstructor(PI1);
        course2.setInstructor(PI1);
        course3.setInstructor(VR1);
        course4.setInstructor(VR1);

        PI1.getCourses().add(course1);
        PI1.getCourses().add(course2);
        VR1.getCourses().add(course3);
        VR1.getCourses().add(course4);

        Student student1 = new Student("Ashe Nate", LocalDate.of(2000, 10,12),"Italy",true);
        Student student2 = new Student("Kevin Dune", LocalDate.of(1996, 5,7),"London",false);
        Student student3 = new Student("Norton Sale", LocalDate.of(1998, 7,25),"Germany",false);
        Student student4 = new Student("Darius Burn", LocalDate.of(1997, 4,30),"Italy",false);
        Student student5 = new Student("Suzan Klein", LocalDate.of(1993, 5,21),"London",true);
        Student student6 = new Student("Katy Apple", LocalDate.of(2001, 1,17),"USA",true);
        Student student7 = new Student("John Dolt", LocalDate.of(1994, 3,15),"USA",false);
        Student student8 = new Student("Suzy Perry", LocalDate.of(1995, 7,10),"Germany",true);

        course1.getStudents().add(student1);
        course1.getStudents().add(student3);
        course1.getStudents().add(student5);
        course2.getStudents().add(student2);
        course2.getStudents().add(student5);
        course2.getStudents().add(student8);
        course3.getStudents().add(student7);
        course3.getStudents().add(student4);
        course3.getStudents().add(student1);
        course4.getStudents().add(student8);
        course4.getStudents().add(student6);
        course4.getStudents().add(student2);
        course4.getStudents().add(student3);

        student1.getCourses().add(course1);
        student1.getCourses().add(course3);
        student2.getCourses().add(course2);
        student2.getCourses().add(course4);
        student3.getCourses().add(course1);
        student3.getCourses().add(course4);
        student4.getCourses().add(course3);
        student5.getCourses().add(course1);
        student5.getCourses().add(course2);
        student6.getCourses().add(course4);
        student7.getCourses().add(course3);
        student8.getCourses().add(course2);
        student8.getCourses().add(course4);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);

            em.persist(VR1);
            em.persist(PI1);

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);
            em.persist(student7);
            em.persist(student8);

            em.getTransaction().commit();

            System.out.println("All Data Persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
