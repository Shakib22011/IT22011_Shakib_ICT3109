package com.example.quizapp.controller;

import com.example.quizapp.model.Student;
import com.example.quizapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Show student ID input page
    @GetMapping("/")
    public String showStudentIdPage() {
        return "student-id"; // Thymeleaf template name
    }

    // Check student and redirect to quiz if exists
    @PostMapping("/checkStudent")
    public String checkStudent(@RequestParam("studentId") String studentId, Model model) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            model.addAttribute("error", "স্টুডেন্ট আইডি পাওয়া যায়নি। আবার চেষ্টা করুন।");
            return "student-id";
        }
        return "redirect:/quiz?studentId=" + studentId;
    }
}
