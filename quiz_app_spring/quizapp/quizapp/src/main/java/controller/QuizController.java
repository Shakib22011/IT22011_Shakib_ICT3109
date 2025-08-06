package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Student;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Show quiz questions page
    @GetMapping("/quiz")
    public String showQuiz(@RequestParam("studentId") String studentId, Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        model.addAttribute("studentId", studentId);
        return "quiz";
    }

    // Handle quiz submission
    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam("studentId") String studentId,
                             @RequestParam Map<String, String> allParams,
                             Model model) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            model.addAttribute("error", "স্টুডেন্ট আইডি পাওয়া যায়নি।");
            return "student-id";
        }

        List<Question> questions = questionRepository.findAll();

        int score = 0;
        for (Question q : questions) {
            String answer = allParams.get("question_" + q.getId());
            if (answer != null && answer.equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }

        student.setScore(score);
        studentRepository.save(student);

        model.addAttribute("score", score);
        model.addAttribute("total", questions.size());
        model.addAttribute("studentId", studentId);
        return "result";
    }
}
