package org.example.service;

import org.example.entities.Course;
import org.example.entities.Student;

import java.util.List;

public interface StudentService {
    String createStudent(Student student);

    Student getStudentById(Long studentId);

    String updateStudentName(Long studentId, String newName);

    String deleteStudent(Long studentId);

    List<Course> getStudentCourses(Long studentId);

    List<Student> getStudentsByRecentEnrollments(int limit);
}
