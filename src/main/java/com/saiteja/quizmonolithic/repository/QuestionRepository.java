package com.saiteja.quizmonolithic.repository;

import com.saiteja.quizmonolithic.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
