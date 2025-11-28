package com.saiteja.quizmonolithic.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "quiz_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "questiontitle")
    private String questionTitle;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "rightanswer")
    private String rightAnswer;

    @Column(name = "difficultylevel")
    private String difficultylevel;

    @Column(name = "category")
    private String category;
}
