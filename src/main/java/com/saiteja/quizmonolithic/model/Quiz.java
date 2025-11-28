package com.saiteja.quizmonolithic.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "quiz_question_map",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
}
