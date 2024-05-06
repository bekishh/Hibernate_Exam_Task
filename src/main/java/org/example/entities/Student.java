package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(unique = true)
    private String email;
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;
    @ManyToMany
    private List<Course> courses;

    public Student(String fullName, String email, LocalDate enrollmentDate) {
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    public Student(String fullName, String email, LocalDate enrollmentDate, List<Course> courses) {
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
