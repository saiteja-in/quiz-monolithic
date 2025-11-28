package com.saiteja.quizmonolithic.service;

import com.saiteja.quizmonolithic.dto.QuestionDTO;
import com.saiteja.quizmonolithic.model.Question;
import com.saiteja.quizmonolithic.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<String> addQuestion(QuestionDTO questionDTO) {
        try {
            Question question = new Question();
            question.setQuestionTitle(questionDTO.getQuestionTitle());
            question.setOption1(questionDTO.getOption1());
            question.setOption2(questionDTO.getOption2());
            question.setOption3(questionDTO.getOption3());
            question.setOption4(questionDTO.getOption4());
            question.setRightAnswer(questionDTO.getRightAnswer());
            question.setDifficultylevel(questionDTO.getDifficultylevel());
            question.setCategory(questionDTO.getCategory());

            questionRepository.save(question);
            return ResponseEntity.ok("Question added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to add question");
        }
    }

}
