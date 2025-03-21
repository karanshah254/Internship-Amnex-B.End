package com.question.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.questionservice.entity.Question;
import com.question.questionservice.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // get all questions
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQue();
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping("{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQueById(id);
    }

    // get all questions of a quiz
    @GetMapping("quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
