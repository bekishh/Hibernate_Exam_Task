package org.example.service.serviceImpl;

import org.example.entities.Course;
import org.example.entities.Student;
import org.example.repository.CourseRepository;
import org.example.repository.repositoryImpl.CourseRepositoryImpl;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        return courseRepository.updateCourse(courseId, newCourse);
    }

    @Override
    public String deleteCourse(Long courseId) {
        return courseRepository.deleteCourse(courseId);
    }

    @Override
    public List<Student> getCourseStudents(Long courseId) {
        return courseRepository.getCourseStudents(courseId);
    }

    @Override
    public String assignStudentToCourse(Long courseId, Long studentId) {
        return courseRepository.assignStudentToCourse(courseId, studentId);
    }
}
