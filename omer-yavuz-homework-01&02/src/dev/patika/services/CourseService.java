package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.repositories.CourseRepository;
import dev.patika.repositories.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

// should all business logic is in services
// database access object - DAO
public class CourseService implements CrudRepository<Course>, CourseRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        return em.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    public void saveToDataBase(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDataBase(Course course) {
        try {
            em.getTransaction().begin();
            em.remove(course);
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
    public void updateOnDataBase(Course course) {
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteCourseWithId(int id) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.createQuery("FROM Course x WHERE x.id = :courseId", Course.class)
                    .setParameter("courseId", id)
                    .getSingleResult();
            em.remove(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(em);
        }
    }
}
