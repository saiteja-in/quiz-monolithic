package com.saiteja.quizmonolithic.repository;

import com.saiteja.quizmonolithic.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM quiz_questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
