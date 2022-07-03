package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.models.PermanentInstructor;
import dev.patika.repositories.CrudRepository;
import dev.patika.repositories.PermanentInstructorRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class PermanentInstructorService implements CrudRepository<PermanentInstructor>, PermanentInstructorRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<PermanentInstructor> findAll() {
        return em.createQuery("FROM PermanentInstructor", PermanentInstructor.class).getResultList();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return em.find(PermanentInstructor.class, id);
    }

    @Override
    public void saveToDataBase(PermanentInstructor permanentInstructor) {
        try {
            em.getTransaction().begin();
            em.persist(permanentInstructor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDataBase(PermanentInstructor permanentInstructor) {
        try {
            em.getTransaction().begin();
            em.remove(permanentInstructor);
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
    public void updateOnDataBase(PermanentInstructor permanentInstructor) {
        try {
            em.getTransaction().begin();
            em.merge(permanentInstructor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deletePermanentInstructorWithId(int id) {
        try {
            em.getTransaction().begin();

            Instructor foundPermanentInstructor = em.createQuery(
                    "FROM PermanentInstructor x WHERE x.id = :permanentInstructor", PermanentInstructor.class)
                    .setParameter("permanentInstructor", id)
                    .getSingleResult();
            em.remove(foundPermanentInstructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }
}
