package com.saiteja.quizmonolithic.service;

import com.saiteja.quizmonolithic.model.Question;
import com.saiteja.quizmonolithic.model.Quiz;
import com.saiteja.quizmonolithic.repository.QuestionRepository;
import com.saiteja.quizmonolithic.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
