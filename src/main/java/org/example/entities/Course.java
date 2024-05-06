package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "coures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @ManyToMany
    private List<Student> students;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(String name, String description, List<Student> students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }
}
