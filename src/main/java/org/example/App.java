package org.example;

import org.example.entities.Course;
import org.example.entities.Student;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.StudentServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);

        CourseService courseService = new CourseServiceImpl();
        StudentService studentService = new StudentServiceImpl();

        while (true) {
            System.out.println("""
                    ----------------- Course -----------------
                    1) Создать курс
                    2) Получить курс по ID
                    3) Обновить курс по ID
                    4) Удалить курс
                    5) Получить всех студентов курса
                    6) Записать студента в курс
                    ----------------- Student -----------------
                    7) Создать студента
                    8) Получить студента по ID
                    9) Обновить студента по ID
                    10) Удалить студента
                    11) Получить все курсы студента
                    12) Получить студентов по недавним зачислениям
                    """);

            switch (scannerNum.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название курса: ");
                    String name = scannerLn.nextLine();

                    System.out.println("Введите описание курса: ");
                    String description = scannerLn.nextLine();

                    System.out.println(courseService.createCourse(new Course(name, description, new ArrayList<>())));
                }
                case 2 -> {
                    System.out.println("Введите ID курса которого хотите найти: ");
                    Long courseId = scannerNum.nextLong();

                    System.out.println(courseService.getCourseById(courseId));
                }
                case 3 -> {
                    System.out.println("Введите ID курса которого хотите обновить: ");
                    Long courseId = scannerNum.nextLong();

                    System.out.println("Введите новое название курса: ");
                    String name = scannerLn.nextLine();

                    System.out.println("Введите новое описание курса: ");
                    String description = scannerLn.nextLine();

                    System.out.println(courseService.updateCourse(courseId, new Course(name, description)));
                }
                case 4 -> {
                    System.out.println("Введите ID курса которого хотите удалить: ");
                    Long courseId = scannerNum.nextLong();

                    System.out.println(courseService.deleteCourse(courseId));
                }
                case 5 -> {
                    System.out.println("Введите ID курса: ");
                    Long courseId = scannerNum.nextLong();

                    System.out.println(courseService.getCourseStudents(courseId));
                }
                case 6 -> {
                    System.out.println("Введите ID курса: ");
                    Long courseId = scannerNum.nextLong();

                    System.out.println("Введите ID студента: ");
                    Long studentId = scannerNum.nextLong();

                    System.out.println(courseService.assignStudentToCourse(courseId, studentId));
                }
                case 7 -> {
                    System.out.println("Введите полное имя студента: ");
                    String fullName = scannerLn.nextLine();

                    System.out.println("Введите email студента: ");
                    String email = scannerLn.nextLine();

                    System.out.println("Введите дату поступления на работу (yyyy mm dd): ");
                    LocalDate enrollmentDate = LocalDate.of(scannerNum.nextInt(), scannerNum.nextInt(), scannerNum.nextInt());

                    System.out.println(studentService.createStudent(new Student(fullName, email, enrollmentDate)));
                }
                case 8 -> {
                    System.out.println("Введите ID студента которого хотите найти: ");
                    Long studentId = scannerNum.nextLong();

                    System.out.println(studentService.getStudentById(studentId));
                }
                case 9 -> {
                    System.out.println("Введите ID студента которого хотите обновить: ");
                    Long studentId = scannerNum.nextLong();

                    System.out.println("Введите новое имя и фамилию для студента: ");
                    String newName = scannerLn.nextLine();

                    System.out.println(studentService.updateStudentName(studentId, newName));
                }
                case 10 -> {
                    System.out.println("Введите ID студента которого хотите удалить: ");
                    Long studentId = scannerNum.nextLong();

                    System.out.println(studentService.deleteStudent(studentId));
                }
                case 11 -> {
                    System.out.println("Введите ID студента: ");
                    Long studentId = scannerNum.nextLong();

                    System.out.println(studentService.getStudentCourses(studentId));
                }
                case 12 -> {
                    System.out.println("Введите лимит для студентов: ");
                    int limit = scannerNum.nextInt();

                    System.out.println(studentService.getStudentsByRecentEnrollments(limit));
                }
            }
        }
    }
}
