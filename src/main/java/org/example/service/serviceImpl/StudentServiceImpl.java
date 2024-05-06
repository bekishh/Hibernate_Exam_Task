package org.example.service.serviceImpl;

import org.example.entities.Course;
import org.example.entities.Student;
import org.example.repository.StudentRepository;
import org.example.repository.repositoryImpl.StudentRepositoryImpl;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public String createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public String updateStudentName(Long studentId, String newName) {
        return studentRepository.updateStudentName(studentId, newName);
    }

    @Override
    public String deleteStudent(Long studentId) {
        return studentRepository.deleteStudent(studentId);
    }

    @Override
    public List<Course> getStudentCourses(Long studentId) {
        return studentRepository.getStudentCourses(studentId);
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments(int limit) {
        return studentRepository.getStudentsByRecentEnrollments(limit);
    }
}
