package com.saiteja.quizmonolithic.repository;

import com.saiteja.quizmonolithic.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
