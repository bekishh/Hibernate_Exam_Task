package org.example.service;

import org.example.entities.Course;
import org.example.entities.Student;

import java.util.List;

public interface CourseService {
    String createCourse(Course course);

    Course getCourseById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    String deleteCourse(Long courseId);

    List<Student> getCourseStudents(Long courseId);

    String assignStudentToCourse(Long courseId, Long studentId);
}
