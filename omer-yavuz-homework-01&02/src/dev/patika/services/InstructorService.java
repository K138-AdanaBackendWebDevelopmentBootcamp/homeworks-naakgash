package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.repositories.CrudRepository;
import dev.patika.repositories.InstructorRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CrudRepository<Instructor>, InstructorRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Instructor> findAll() {
        return em.createQuery("FROM Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    public void saveToDataBase(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.persist(instructor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDataBase(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.remove(instructor);
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
    public void updateOnDataBase(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.merge(instructor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteInstructorWithId(int id) {
        try {
            em.getTransaction().begin();

            Instructor foundInstructor = em.createQuery("FROM Instructor x WHERE x.id = :instructorId", Instructor.class)
                    .setParameter("instructorId", id)
                    .getSingleResult();
            em.remove(foundInstructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }
}
