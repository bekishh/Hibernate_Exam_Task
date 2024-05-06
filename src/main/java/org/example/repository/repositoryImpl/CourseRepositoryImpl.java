package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entities.Course;
import org.example.entities.Student;
import org.example.repository.CourseRepository;
import org.hibernate.HibernateException;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String createCourse(Course course) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return "Course successfully created!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            return entityManager.find(Course.class, courseId);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            course.setName(newCourse.getName());
            course.setDescription(newCourse.getDescription());
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            return "Course successfully updated!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteCourse(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            return "Course successfully deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Student> getCourseStudents(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().commit();
            return course.getStudents();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String assignStudentToCourse(Long courseId, Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            Student student = entityManager.find(Student.class, studentId);
            course.getStudents().add(student);
            entityManager.getTransaction().commit();
            return "Student successfully assigned to course!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }
}
