package com.quiz.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quizservice.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    
}
