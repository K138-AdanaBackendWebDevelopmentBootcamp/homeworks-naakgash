package dev.patika.services;

import dev.patika.models.Student;
import dev.patika.models.VisitingResearcher;
import dev.patika.repositories.CrudRepository;
import dev.patika.repositories.VisitingResearcherRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class VisitingResearcherService implements CrudRepository<VisitingResearcher>, VisitingResearcherRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<VisitingResearcher> findAll() {
        return em.createQuery("FROM VisitingResearcher", VisitingResearcher.class).getResultList();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return em.find(VisitingResearcher.class, id);
    }

    @Override
    public void saveToDataBase(VisitingResearcher visitingResearcher) {

    }

    @Override
    public void deleteFromDataBase(VisitingResearcher visitingResearcher) {
        try {
            em.getTransaction().begin();
            em.persist(visitingResearcher);
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
    public void updateOnDataBase(VisitingResearcher visitingResearcher) {
        try {
            em.getTransaction().begin();
            em.merge(visitingResearcher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteVisitingResearcherWithId(int id) {
        try {
            em.getTransaction().begin();

            VisitingResearcher foundVisitingResearcher = em.createQuery("FROM VisitingResearcher x WHERE x.id = :visitingResearcherId", VisitingResearcher.class)
                    .setParameter("visitingResearcherId", id)
                    .getSingleResult();
            em.remove(foundVisitingResearcher);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }
}
