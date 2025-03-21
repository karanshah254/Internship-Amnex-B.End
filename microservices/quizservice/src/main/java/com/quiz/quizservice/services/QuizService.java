package com.quiz.quizservice.services;

import java.util.List;

import com.quiz.quizservice.entity.Quiz;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);

    List<Quiz> get();

    Quiz getQuizById(Long id);
}
