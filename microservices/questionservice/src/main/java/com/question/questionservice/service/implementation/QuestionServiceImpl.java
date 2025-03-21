package com.question.questionservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.questionservice.entity.Question;
import com.question.questionservice.repository.QuestionRepository;
import com.question.questionservice.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQue() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQueById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Questions not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

}
