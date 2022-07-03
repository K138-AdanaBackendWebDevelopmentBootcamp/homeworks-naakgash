package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.repositories.CrudRepository;
import dev.patika.repositories.StudentRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void saveToDataBase(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDataBase(Student student) {
        try {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDataBase(int id) {
        try {
            em.getTransaction().begin();
            em.remove(findById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDataBase(Student student) {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteStudentWithId(int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.createQuery("FROM Student x WHERE x.id = :studentId", Student.class)
                    .setParameter("studentId", id)
                    .getSingleResult();
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }
}
