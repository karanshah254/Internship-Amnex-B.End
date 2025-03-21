package com.quiz.quizservice.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.repository.QuizRepository;
import com.quiz.quizservice.services.QuestionClient;
import com.quiz.quizservice.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) { // add new quiz
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> allQuizes = quizRepository.findAll();

        List<Quiz> newQuizList = allQuizes.stream().map(
                quiz -> {
                    quiz.setQuestions(questionClient.getAllQuestions(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getAllQuestions(quiz.getId()));
        return quiz;
    }

}
