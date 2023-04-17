package com.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name="question_Id")
    private  int questionId;
    private String question;
    @OneToMany(mappedBy = "q", cascade = CascadeType.ALL)
    private List<Answer>  answer;

    public Question() {
    }

    public Question(int questionId, String question, List<Answer> answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
