package com.quiz.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // create a quiz
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    // get all quizes
    @GetMapping
    public List<Quiz> getAll() {
        return quizService.get();
    }

    // find by id
    @GetMapping("{id}")
    public Quiz getById(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.getQuizById(id);
    }
}
