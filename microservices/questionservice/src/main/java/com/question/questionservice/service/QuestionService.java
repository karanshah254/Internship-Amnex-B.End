package com.question.questionservice.service;

import java.util.List;

import com.question.questionservice.entity.Question;

public interface QuestionService {
    Question create(Question question);

    List<Question> getAllQue();

    Question getQueById(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
