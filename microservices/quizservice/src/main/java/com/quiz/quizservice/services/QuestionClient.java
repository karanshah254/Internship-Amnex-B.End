package com.quiz.quizservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.quizservice.entity.Question;

@FeignClient(url = "http://localhost:8091", name = "question-service-client")
public interface QuestionClient {

    @GetMapping("question/quiz/{quizId}")
    List<Question> getAllQuestions(@PathVariable Long quizId);
}
