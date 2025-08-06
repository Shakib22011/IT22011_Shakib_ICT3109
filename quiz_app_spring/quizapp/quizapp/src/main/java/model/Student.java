package com.example.quizapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "student_id"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Auto increment primary key

    @Column(name = "student_id", nullable = false, unique = true)
    private String studentId;  // Student ID entered by user

    private int score;

    public Student() {}

    public Student(String studentId, int score) {
        this.studentId = studentId;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
